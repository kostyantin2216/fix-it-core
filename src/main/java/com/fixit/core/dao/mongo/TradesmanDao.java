/**
 * 
 */
package com.fixit.core.dao.mongo;

import java.util.List;

import org.bson.types.ObjectId;

import com.fixit.core.data.mongo.MapArea;
import com.fixit.core.data.mongo.Tradesman;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/15 21:59:08 GMT+2
 */
public interface TradesmanDao extends MongoDao<Tradesman> {
	public final static String TABLE_NAME = "Tradesman";
	
	public final static String PROP_PROFESSION_ID = "professionId";
	public final static String PROP_LEAD_ID = "leadId";
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
	
	List<Tradesman> getTradesmenForArea(MapArea area);
	List<Tradesman> getTradesmenForArea(int professionId, MapArea area);
	String getTelephoneForTradsman(ObjectId id);
}
