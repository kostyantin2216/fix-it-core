package com.fixit.core.dao.mongo.impl;

import static com.mongodb.client.model.Filters.*;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Repository;

import com.fixit.core.dao.mongo.TradesmanDao;
import com.fixit.core.data.mongo.MapArea;
import com.fixit.core.data.mongo.Tradesman;
import com.mongodb.client.FindIterable;

@Repository("tradesmanDao")
public class TradesmanDaoImpl extends MongoDaoImpl<Tradesman>
		implements TradesmanDao {

	public final static String TABLE_NAME = "Tradesman";
	
	public final static String PROP_LEAD_ID = "leadId";
	public final static String PROP_PROFESSION_ID = "proffesionId";
	public final static String PROP_NAME = "name";
	public final static String PROP_EMAIL = "email";
	public final static String PROP_TELEPHONE = "telephone";
	public final static String PROP_PASSWORD = "password";
	public final static String PROP_LOGO_URL = "logoUrl";
	public final static String PROP_RATING = "rating";
	public final static String PROP_LAST_KNOWN_LAT = "lastKnownLat";
	public final static String PROP_LAST_KNOWN_LONG = "lastKnownLong";
	public final static String PROP_WORKING_AREAS = "workingAreas";
	public final static String PROP_WORKING_DAYS = "workingDays";
	public final static String PROP_SUBSCRIPTION_EXPIRY_TIME = "subscriptionExpiryTime";
	
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
					in(PROP_WORKING_AREAS, Arrays.asList(area.get_id().toString())),
					eq(PROP_PROFESSION_ID, professionId)
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

}
