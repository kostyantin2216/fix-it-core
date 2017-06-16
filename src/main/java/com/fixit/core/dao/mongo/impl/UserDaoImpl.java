package com.fixit.core.dao.mongo.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fixit.core.config.GsonManager;
import com.fixit.core.config.MongoClientManager;
import com.fixit.core.dao.mongo.UserDao;
import com.fixit.core.data.mongo.User;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

@Repository("userDao")
public class UserDaoImpl extends MongoDaoImpl<User>
		implements UserDao {

	public final static String TABLE_NAME = "User";
	
	public final static String PROP_NAME = "name";
	public final static String PROP_EMAIL = "email";
	public final static String PROP_TELEPHONE = "telephone";
	public final static String PROP_USER_AVATER_URL = "userAvatarUrl";
	public final static String PROP_FACEBOOK_ID = "facebookId";
	public final static String PROP_GOOGLE_ID = "googleId";

	@Autowired
	public UserDaoImpl(MongoClientManager mongoClientManager, GsonManager gsonManager) {
		super(mongoClientManager.getCollection(TABLE_NAME), gsonManager.getMongoGson());
	}
	
	@Override
	public Map<ObjectId, Map<String, String>> getDataForReviews(Set<ObjectId> forUsers) {
		FindIterable<Document> find = mCollection.find(Filters.in(PROP_ID, forUsers))
				.projection(Projections.include(PROP_NAME, PROP_USER_AVATER_URL));

		Map<ObjectId, Map<String, String>> result = new HashMap<>();
		MongoCursor<Document> cursor = find.iterator();
		try {
			while (cursor.hasNext()) {
				Document doc = cursor.next();
				Map<String, String> data = new HashMap<>();
				data.put(PROP_NAME, doc.getString(PROP_NAME));
				data.put(PROP_USER_AVATER_URL, doc.getString(PROP_USER_AVATER_URL));
				result.put(doc.getObjectId(PROP_ID), data);
			}
		} finally {
			cursor.close();
		}

		return result;
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

}
