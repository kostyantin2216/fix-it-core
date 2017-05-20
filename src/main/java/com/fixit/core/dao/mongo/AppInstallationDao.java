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
	List<AppInstallation> findByDeviceId(String deviceId);
}
