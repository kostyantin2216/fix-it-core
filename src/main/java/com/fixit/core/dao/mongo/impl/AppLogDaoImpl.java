/**
 * 
 */
package com.fixit.core.dao.mongo.impl;

import org.springframework.stereotype.Repository;

import com.fixit.core.config.GsonManager;
import com.fixit.core.config.MongoClientManager;
import com.fixit.core.dao.mongo.AppLogDao;
import com.fixit.core.data.mongo.AppLog;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/16 21:04:06 GMT+2
 */
@Repository("appLogDao")
public class AppLogDaoImpl extends MongoDaoImpl<AppLog> implements AppLogDao {
	
	public AppLogDaoImpl(MongoClientManager mongoClientManager, GsonManager gsonManager) {
		super(mongoClientManager.getCollection(TABLE_NAME), gsonManager.getMongoGson());
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<AppLog> getEntityClass() {
		return AppLog.class;
	}

}
