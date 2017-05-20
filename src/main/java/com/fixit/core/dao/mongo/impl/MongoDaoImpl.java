package com.fixit.core.dao.mongo.impl;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;

import com.fixit.core.config.CoreContextProvider;
import com.fixit.core.dao.mongo.MongoDao;
import com.fixit.core.dao.queries.DataResourceQuery;
import com.fixit.core.dao.queries.MongoDataResourceQueryProcessor;
import com.fixit.core.data.mongo.MongoModelObject;
import com.fixit.core.exceptions.IllegalQueryPropertyException;
import com.fixit.core.logging.FILog;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

@Scope("request")
public abstract class MongoDaoImpl<E extends MongoModelObject> 
		implements MongoDao<E> {

	protected final MongoCollection<Document> mCollection;
	protected final Gson mGson;
	private final MongoDataResourceQueryProcessor queryProcessor;
	
	public MongoDaoImpl() {
		mCollection = CoreContextProvider.getMongoClientManager().getCollection(getTableName());
		mGson = CoreContextProvider.getGsonManager().getMongoGson();
		queryProcessor = new MongoDataResourceQueryProcessor();
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
	public List<E> find(Bson bsonFilter) {
		return convertToList(mCollection.find(bsonFilter).iterator());
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
	
	@Override
	public List<E> processQueries(DataResourceQuery... queries) {
		Set<Bson> queryDocs = new HashSet<>();
		Bson latestQuery = null;
		for(DataResourceQuery query : queries) {
			Class<?> propType = BeanUtils.findPropertyType(query.getProp(), getEntityClass());
			if(propType.getName().equals(Object.class.getName())) {
				throw new IllegalQueryPropertyException("Data query property \"" + query.getProp() + "\" does not exist");
			} else {
				Bson bsonQuery = queryProcessor.process(query, propType.getName());
				if(bsonQuery != null) {
					latestQuery = bsonQuery;
					queryDocs.add(bsonQuery);
				}
			}
		}

		if(latestQuery != null) {
			return find(queryDocs.size() == 1 ? latestQuery : Filters.and(queryDocs));
		} else {
			return Collections.emptyList();
		}
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
