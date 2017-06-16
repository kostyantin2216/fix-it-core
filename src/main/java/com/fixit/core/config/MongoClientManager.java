package com.fixit.core.config;

import javax.annotation.PreDestroy;

import org.bson.Document;
import org.springframework.core.env.Environment;

import com.fixit.core.logging.FILog;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoClientManager  {

	private final MongoClient mClient;
	private final MongoDatabase mDatabase;
	
	public MongoClientManager(Environment env) {
		mClient = new MongoClient(
				env.getProperty("host"),
				Integer.parseInt(env.getProperty("port"))
		);
		mDatabase = mClient.getDatabase(env.getProperty("database"));
	}
	
	public MongoCollection<Document> getCollection(String name) {
		return mDatabase.getCollection(name);
	}
	
	@PreDestroy
	public void cleanUp() {
		FILog.i("closing mongo client");
		mClient.close();
	}

}
