package com.fixit.core.config;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fixit.core.config.json.FieldExclusionStrategyManager;
import com.fixit.core.config.json.ObjectIdTypeAdatper;
import com.fixit.core.dao.mongo.MapAreaDao;
import com.fixit.core.dao.mongo.OrderDataDao;
import com.fixit.core.dao.mongo.TradesmanDao;
import com.fixit.core.dao.mongo.impl.MongoDaoImpl;
import com.fixit.core.dao.sql.ProfessionDao;
import com.fixit.core.dao.sql.StoredPropertyDao;
import com.fixit.core.dao.sql.impl.TradesmanLeadDaoImpl;
import com.fixit.core.data.mongo.MapArea;
import com.fixit.core.data.mongo.OrderData;
import com.fixit.core.data.mongo.Tradesman;
import com.fixit.core.data.sql.Profession;
import com.fixit.core.data.sql.TradesmanLead;
import com.fixit.core.general.PropertyGroup;
import com.fixit.core.general.StoredProperties;
import com.fixit.core.utils.Formatter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class GsonManager {

	private final Gson mMongoGson;
	private final Gson mServerNotifierGson;
	private final Gson mRestResourceGson;
	
	@Autowired
	public GsonManager(StoredPropertyDao storedPropertyDao) {
		mMongoGson = new GsonBuilder()
				.registerTypeAdapter(ObjectId.class, new ObjectIdTypeAdatper())
				.create();
		mServerNotifierGson = new GsonBuilder()
				.registerTypeAdapter(ObjectId.class, new ObjectIdTypeAdatper())
				.setDateFormat(storedPropertyDao.find(
						PropertyGroup.Group.events.name(), 
						StoredProperties.EVENTS_NOTIFY_DATE_FORMAT
					).getValue())
				.addSerializationExclusionStrategy(
						new FieldExclusionStrategyManager.Builder()
    					.add(Tradesman.class, 
    							TradesmanDao.PROP_PASSWORD, 
    							TradesmanDao.PROP_WORKING_DAYS,
    							TradesmanDao.PROP_WORKING_AREAS,
    							TradesmanDao.PROP_LOGO_URL,
    							TradesmanDao.PROP_FEATURE_IMAGE_URL)
    					.add(Profession.class, 
    							ProfessionDao.PROP_DESCRIPTION,
    							ProfessionDao.PROP_IMAGE_URL,
    							ProfessionDao.PROP_NAME_PLURAL)
    					.add(TradesmanLead.class, 
    							TradesmanLeadDaoImpl.PROP_SHOPIFY_ID)
    					.add(MapArea.class, 
    							MapAreaDao.PROP_GEOMETRY)
    					.build())
				.setPrettyPrinting()
				.create();
		mRestResourceGson = new GsonBuilder()
				.setDateFormat(Formatter.FORMAT_REST_DATE)
				.registerTypeAdapter(ObjectId.class, new ObjectIdTypeAdatper())
                .enableComplexMapKeySerialization()
				.addSerializationExclusionStrategy(
						new FieldExclusionStrategyManager.Builder()
	    					.add(Tradesman.class, 
	    							TradesmanDao.PROP_PASSWORD, 
	    							TradesmanDao.PROP_LEAD_ID,
	    							TradesmanDao.PROP_WORKING_AREAS,
	    							TradesmanDao.PROP_ID_PROVIDED,
	    							TradesmanDao.PROP_TRADE_CERTIFICATE_PROVIDED)
	    					.add(OrderData.class, 
	    							OrderDataDao.PROP_USER_ID)
	    					.build())
				.create();
	}

	/**
	 * This will be used in {@link MongoDaoImpl} which is request scoped.
	 * In order to prevent making a ridiculous amount of Gson Object's we create it once.
	 * 
	 * @return Gson object configured for MongoDao.
	 */
	public Gson getMongoGson() {
		return mMongoGson;
	}
	
	public Gson getServerNotifierGson() {
		return mServerNotifierGson;
	}
	
	/**
	 * Creates a builder for rest resources, this should only be called twice once for
	 * a normal gson and once for a pretty print gson.
	 * 
	 * @return GsonBuilder for rest resource gson.
	 */
	public Gson getRestResourceGson() {
		return mRestResourceGson;
	}

	
}
