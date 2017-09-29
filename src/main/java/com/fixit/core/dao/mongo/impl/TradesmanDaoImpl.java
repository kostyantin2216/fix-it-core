package com.fixit.core.dao.mongo.impl;

import static com.mongodb.client.model.Filters.all;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.in;
import static com.mongodb.client.model.Projections.include;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fixit.core.config.GsonManager;
import com.fixit.core.config.MongoClientManager;
import com.fixit.core.dao.mongo.TradesmanDao;
import com.fixit.core.data.mongo.MapArea;
import com.fixit.core.data.mongo.Tradesman;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

@Repository("tradesmanDao")
public class TradesmanDaoImpl extends MongoDaoImpl<Tradesman>
		implements TradesmanDao {
	
	@Autowired
	public TradesmanDaoImpl(MongoClientManager mongoClientManager, GsonManager gsonManager) {
		super(mongoClientManager.getCollection(TABLE_NAME), gsonManager.getMongoGson());
	}
	
	@Override
	public List<Tradesman> getTradesmenForArea(MapArea area) {
		FindIterable<Document> result = mCollection.find(
				all(PROP_WORKING_AREAS, Arrays.asList(area.get_id()))
		);
		
		return convertToList(result.iterator());
	}
	
	@Override
	public List<Tradesman> getTradesmenForArea(int professionId, MapArea area) {
		FindIterable<Document> result = mCollection.find(and(
					in(PROP_WORKING_AREAS, Arrays.asList(area.get_id().toHexString())),
					in(PROP_PROFESSIONS, professionId)
				)
		);
		
		return convertToList(result.iterator());
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<Tradesman> getEntityClass() {
		return Tradesman.class;
	}

	@Override
	public String getTelephoneForTradsman(ObjectId id) {
		FindIterable<Document> result = mCollection.find(new Document("_id", id))
												   .projection(include(PROP_TELEPHONE));
		MongoCursor<Document> cursor = result.iterator();
		if(cursor.hasNext()) {
			Document doc = cursor.next();
			return doc.getString(PROP_TELEPHONE);
		}
		return null;
	}

}
