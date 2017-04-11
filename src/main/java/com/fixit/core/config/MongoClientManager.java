package com.fixit.core.config;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
@PropertySource("classpath:mongo.properties")
public class MongoClientManager implements ApplicationListener<ContextClosedEvent> {

	private final MongoClient mClient;
	private final MongoDatabase mDatabase;
	
	@Autowired
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
	
	@Override
	public void onApplicationEvent(ContextClosedEvent event) {
		mClient.close();
	}

}
