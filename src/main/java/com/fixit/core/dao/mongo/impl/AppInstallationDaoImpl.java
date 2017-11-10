/**
 * 
 */
package com.fixit.core.dao.mongo.impl;

import static com.mongodb.client.model.Filters.eq;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fixit.core.config.GsonManager;
import com.fixit.core.config.MongoClientManager;
import com.fixit.core.dao.mongo.AppInstallationDao;
import com.fixit.core.data.mongo.AppInstallation;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/24 22:43:38 GMT+2
 */
@Repository("appInstallationDao")
public class AppInstallationDaoImpl extends MongoDaoImpl<AppInstallation> implements AppInstallationDao {
	
	@Autowired
	public AppInstallationDaoImpl(MongoClientManager mongoClientManager, GsonManager gsonManager) {
		super(mongoClientManager.getCollection(TABLE_NAME), gsonManager.getMongoGson());
	}
	
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
