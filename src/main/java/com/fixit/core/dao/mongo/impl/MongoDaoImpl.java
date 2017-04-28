package com.fixit.core.dao.mongo.impl;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.context.annotation.Scope;

import com.fixit.core.config.CoreContextProvider;
import com.fixit.core.dao.mongo.MongoDao;
import com.fixit.core.data.mongo.MongoModelObject;
import com.fixit.core.logging.FILog;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

@Scope("request")
public abstract class MongoDaoImpl<E extends MongoModelObject> 
		implements MongoDao<E> {

	protected final MongoCollection<Document> mCollection;
	protected final Gson mGson;
	
	public MongoDaoImpl() {
		mCollection = CoreContextProvider.getMongoClientManager().getCollection(getTableName());
		mGson = CoreContextProvider.getGsonManager().getMongoGson();
	}
	
	@Override
	public void save(E entity) {
		Document insertDoc = Document.parse(mGson.toJson(entity));
		mCollection.insertOne(insertDoc);
		entity.set_id(insertDoc.getObjectId("_id"));
	}

	@Override
	public void update(E entity) {
		mCollection.insertOne(Document.parse(mGson.toJson(entity)));
	}

	@Override
	public void delete(ObjectId id) {
		mCollection.deleteOne(eq("_id", id));
	}

	@Override
	public E findById(ObjectId id) {
		MongoCursor<Document> cursor = mCollection.find(new Document("_id", id)).iterator();
		if(cursor != null) {
			if(cursor.hasNext()) {
				String json = cursor.next().toJson();
				FILog.i("found: " + json);
				return mGson.fromJson(json, getEntityClass());
			}
		}
		return null;
	}

	@Override
	public E findOneByProperty(String property, Object value) {
		Document doc = mCollection.find(eq(property, value)).first();
		if(doc != null) {
			return mGson.fromJson(doc.toJson(), getEntityClass());
		}
		return null;
	}

	@Override
	public List<E> findByProperty(String property, Object value) {
		return convertToList(mCollection.find(eq(property, value)).iterator());
	}

	@Override
	public List<E> findByMap(Map<String, Object> properties) {
		List<Bson> filters = new ArrayList<>();
		
		for(Map.Entry<String, Object> entry : properties.entrySet()) {
			filters.add(eq(entry.getKey(), entry.getValue()));
		}
		
		return convertToList(mCollection.find(and(filters)).iterator());
	}

	@Override
	public List<E> findAll() {
		return convertToList(mCollection.find().iterator());
	}
	
	protected List<E> convertToList(MongoCursor<Document> cursor) {
		List<E> results = new ArrayList<>();
		
		if(cursor != null) {
			while(cursor.hasNext()) {
				String json = cursor.next().toJson();
				results.add(mGson.fromJson(json, getEntityClass()));
			}
		}
		
		return results;
	}
	
}
