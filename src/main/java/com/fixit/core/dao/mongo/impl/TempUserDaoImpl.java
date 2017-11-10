/**
 * 
 */
package com.fixit.core.dao.mongo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fixit.core.config.GsonManager;
import com.fixit.core.config.MongoClientManager;
import com.fixit.core.dao.mongo.TempUserDao;
import com.fixit.core.data.mongo.TempUser;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/11/10 23:54:06 GMT+2
 */
@Repository("tempUserDao")
public class TempUserDaoImpl extends MongoDaoImpl<TempUser> implements TempUserDao {

	@Autowired
	public TempUserDaoImpl(MongoClientManager mongoClientManager, GsonManager gsonManager) {
		super(mongoClientManager.getCollection(TABLE_NAME), gsonManager.getMongoGson());
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<TempUser> getEntityClass() {
		return TempUser.class;
	}

}
