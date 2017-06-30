/**
 * 
 */
package com.fixit.core.dao.mongo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fixit.core.config.GsonManager;
import com.fixit.core.config.MongoClientManager;
import com.fixit.core.dao.mongo.UserBookmarkDao;
import com.fixit.core.data.mongo.UserBookmark;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/16 20:32:24 GMT+2
 */
@Repository("userBookmarkDao")
public class UserBookmarkDaoImpl extends MongoDaoImpl<UserBookmark> implements UserBookmarkDao {

	@Autowired
	public UserBookmarkDaoImpl(MongoClientManager mongoClientManager, GsonManager gsonManager) {
		super(mongoClientManager.getCollection(TABLE_NAME), gsonManager.getMongoGson());
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<UserBookmark> getEntityClass() {
		return UserBookmark.class;
	}

}
