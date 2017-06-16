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

	public final static String TABLE_NAME = "AppLog";
	
	public final static String PROP_LEVEL = "level";
	public final static String PROP_TAG = "tag";
	public final static String PROP_MESSAGE = "message";
	public final static String PROP_STACK_TRACE = "stackTrace";
	public final static String PROP_USER_ID = "userId";
	public final static String PROP_DEVICE_INFO = "deviceInfo";
	public final static String PROP_VERSION_INFO = "versionInfo";
	public final static String PROP_CREATED_AT = "createdAt";
	
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
