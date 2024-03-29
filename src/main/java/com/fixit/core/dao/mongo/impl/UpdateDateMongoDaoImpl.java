/**
 * 
 */
package com.fixit.core.dao.mongo.impl;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Filters.lt;
import static com.mongodb.client.model.Filters.lte;

import java.util.Date;
import java.util.List;

import org.bson.Document;

import com.fixit.core.dao.mongo.UpdateDateMongoDao;
import com.fixit.core.data.mongo.UpdateDateMongoModelObject;
import com.fixit.core.utils.Formatter;
import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/01 12:45:20 GMT+3
 */
public abstract class UpdateDateMongoDaoImpl<DMO extends UpdateDateMongoModelObject> extends MongoDaoImpl<DMO> implements UpdateDateMongoDao<DMO> {

	public UpdateDateMongoDaoImpl(MongoCollection<Document> collection, Gson gson) {
		super(collection, gson);
	}

	@Override
	public List<DMO> getBeforeUpdateDate(Date updateDate) {
		return convertToList(
				mCollection
					.find(gt(getUpdatePropertyName(), updateDate))
					.iterator()
		);
	}

	@Override
	public List<DMO> getAfterUpdateDate(Date updateDate) {
		return convertToList(
				mCollection
					.find(lt(getUpdatePropertyName(), updateDate))
					.iterator()
		);
	}

	@Override
	public List<DMO> getTodaysUpdates() {
		Date now = new Date();
		return convertToList(
				mCollection
				.find(and(
						gte(getUpdatePropertyName(), Formatter.getStartOfDay(now)), 
						lte(getUpdatePropertyName(), Formatter.getEndOfDay(now))
				))
				.iterator()
		);
	}

}
