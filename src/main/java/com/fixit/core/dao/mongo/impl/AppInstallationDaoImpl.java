/**
 * 
 */
package com.fixit.core.dao.mongo.impl;

import static com.mongodb.client.model.Filters.eq;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.mongo.AppInstallationDao;
import com.fixit.core.data.mongo.AppInstallation;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/24 22:43:38 GMT+2
 */
@Repository("appInstallationDao")
public class AppInstallationDaoImpl extends MongoDaoImpl<AppInstallation> implements AppInstallationDao {

	public final static String TABLE_NAME = "AppInstallation";
	
	public final static String PROP_PLAY_STORE_URL = "playStoreUrl";
	public final static String PROP_DEVICE = "device";
	public final static String PROP_VERSION = "version";
	public final static String PROP_IP = "ip";
	public final static String PROP_CREATED_AT = "createdAt";
	
	public final static String SUB_ID = ".id";
	
	@Override
	public List<AppInstallation> findByDeviceId(String deviceId) {
		return convertToList(
				mCollection.find(eq(PROP_DEVICE + SUB_ID, deviceId)).iterator()
		);
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<AppInstallation> getEntityClass() {
		return AppInstallation.class;
	}

}
