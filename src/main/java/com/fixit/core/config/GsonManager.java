package com.fixit.core.config;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.fixit.core.config.json.ObjectIdTypeAdatper;
import com.fixit.core.dao.mongo.impl.MongoDaoImpl;
import com.fixit.core.utils.DateUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class GsonManager {

	private final Gson mMongoGson;
	
	public GsonManager() {
		mMongoGson = new GsonBuilder()
				.registerTypeAdapter(ObjectId.class, new ObjectIdTypeAdatper())
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
	
	/**
	 * Creates a builder for rest resources, this should only be called twice once for
	 * a normal gson and once for a pretty print gson.
	 * 
	 * @return GsonBuilder for rest resource gson.
	 */
	private GsonBuilder getRestResourceGsonBuilder() {
		return new GsonBuilder()
				.setDateFormat(DateUtils.FORMAT_REST_DATE)
				.registerTypeAdapter(ObjectId.class, new ObjectIdTypeAdatper())
                .enableComplexMapKeySerialization();
	}
	
	public Gson getRestResourceGson() {
		return getRestResourceGsonBuilder().create();
	}
	
	public Gson getRestResourcePrettyGson() {
		return getRestResourceGsonBuilder().setPrettyPrinting().create();
	}
}
