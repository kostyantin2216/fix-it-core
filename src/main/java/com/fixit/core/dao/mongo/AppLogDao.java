/**
 * 
 */
package com.fixit.core.dao.mongo;

import com.fixit.core.data.mongo.AppLog;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/16 21:03:36 GMT+2
 */
public interface AppLogDao extends MongoDao<AppLog> {

	public final static String TABLE_NAME = "AppLog";
	
	public final static String PROP_LEVEL = "level";
	public final static String PROP_TAG = "tag";
	public final static String PROP_MESSAGE = "message";
	public final static String PROP_STACK_TRACE = "stackTrace";
	public final static String PROP_USER_ID = "userId";
	public final static String PROP_DEVICE_INFO = "deviceInfo";
	public final static String PROP_VERSION_INFO = "versionInfo";
	public final static String PROP_CREATED_AT = "createdAt";

}
