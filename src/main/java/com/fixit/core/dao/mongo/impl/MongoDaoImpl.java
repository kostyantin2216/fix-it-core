package com.fixit.core.dao.mongo.impl;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import static com.mongodb.client.model.Filters.regex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;

import com.fixit.core.dao.mongo.MongoDao;
import com.fixit.core.dao.queries.DataResourceQuery;
import com.fixit.core.dao.queries.MongoDataResourceQueryProcessor;
import com.fixit.core.data.mongo.MongoModelObject;
import com.fixit.core.exceptions.IllegalQueryPropertyException;
import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.DeleteOneModel;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.WriteModel;

@Scope("request")
public abstract class MongoDaoImpl<E extends MongoModelObject> 
		implements MongoDao<E> {

	protected final MongoCollection<Document> mCollection;
	protected final Gson mGson;
	private final MongoDataResourceQueryProcessor queryProcessor;
	
	public MongoDaoImpl(MongoCollection<Document> collection, Gson gson) {
		mCollection = collection;
		mGson = gson;
		queryProcessor = new MongoDataResourceQueryProcessor();
	}
	
	@Override
	public void save(E entity) {
		Document insertDoc = Document.parse(mGson.toJson(entity));
		mCollection.insertOne(insertDoc);
		entity.set_id(insertDoc.getObjectId(PROP_ID));
	}

	@Override
	public void update(E entity) {
		ObjectId id = entity.get_id();
		entity.set_id(null);
		mCollection.updateOne(
				eq(PROP_ID, id), 
				new Document("$set", Document.parse(mGson.toJson(entity)))
		);
		entity.set_id(id);
	}

	@Override
	public void delete(ObjectId id) {
		mCollection.deleteOne(eq(PROP_ID, id));
	}
	
	@Override
	public void deleteMany(List<E> entities) {
		List<WriteModel<Document>> writes = new ArrayList<WriteModel<Document>>();
		
		for(E entity : entities) {
			writes.add(new DeleteOneModel<Document>(new Document(PROP_ID, entity.get_id())));
		}
		
		mCollection.bulkWrite(writes);
	}
	
	@Override
	public List<E> find(Bson bsonFilter) {
		return convertToList(mCollection.find(bsonFilter).iterator());
	}

	@Override
	public E findById(ObjectId id) {
		MongoCursor<Document> cursor = mCollection.find(new Document(PROP_ID, id)).iterator();
		if(cursor != null && cursor.hasNext()) {
			try {
				return convertToType(cursor.next());
			} finally {
				cursor.close();
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
	public E findOneByMap(Map<String, Object> properties) {
		List<Bson> filters = new ArrayList<>();
		
		for(Map.Entry<String, Object> entry : properties.entrySet()) {
			filters.add(eq(entry.getKey(), entry.getValue()));
		}
		
		Document doc = mCollection.find(and(filters)).first();
		if(doc != null) {
			return mGson.fromJson(doc.toJson(), getEntityClass());
		}
		return null;
	}
	
	@Override
	public List<E> findIn(String property, Object... values) {
		FindIterable<Document> resultItr = mCollection.find(in(property, values));
		return convertToList(resultItr.iterator());
	}

	@Override
	public List<E> findByProperty(String property, Object value) {
		FindIterable<Document> result = mCollection.find(eq(property, value));
		return convertToList(result.iterator());
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
	public List<E> findByStartingWith(String property, String value) {
		Document query = new Document(property, value);

		String pattern = "^" + Pattern.quote(query.getString(property)) + ".*";

		FindIterable<Document> result = mCollection.find(regex(property, pattern, "i"));
		return convertToList(result.iterator());
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
			try {
				while(cursor.hasNext()) {
					String json = cursor.next().toJson();
					results.add(mGson.fromJson(json, getEntityClass()));
				}
			} finally {
				cursor.close();
			}
		}
		
		return results;
	}
	
	protected E convertToType(Document document) {
		return document != null ? mGson.fromJson(document.toJson(), getEntityClass()) : null;
	}
	
}
