/**
 * 
 */
package com.fixit.core.dao.mongo;

import java.util.List;

import com.fixit.core.data.mongo.AppInstallation;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/24 22:42:37 GMT+2
 */
public interface AppInstallationDao extends MongoDao<AppInstallation> {
	public final static String TABLE_NAME = "AppInstallation";
	
	public final static String PROP_PLAY_STORE_URL = "playStoreUrl";
	public final static String PROP_DEVICE = "device";
	public final static String PROP_VERSION = "version";
	public final static String PROP_IP = "ip";
	public final static String PROP_CREATED_AT = "createdAt";
	
	public final static String SUB_ID = ".id";
	
	List<AppInstallation> findByDeviceId(String deviceId);
}
