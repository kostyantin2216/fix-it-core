/**
 * 
 */
package com.fixit.core.dao.sql.impl;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.mongo.impl.MongoDaoImpl;
import com.fixit.core.dao.sql.AppInstallationDao;
import com.fixit.core.data.mongo.AppInstallation;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/24 22:43:38 GMT+2
 */
@Repository("appInstallationDao")
public class AppInstallationDaoImpl extends MongoDaoImpl<AppInstallation> implements AppInstallationDao {

	public final static String TABLE_NAME = "AppInstallation";
	
	public final static String PROP_ID = "id";
	public final static String PROP_PLAY_STORE_URL = "playStoreUrl";
	public final static String PROP_DEVICE = "device";
	public final static String PROP_VERSION = "version";
	public final static String PROP_IP = "ip";
	public final static String PROP_CREATED_AT = "createdAt";

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<AppInstallation> getEntityClass() {
		return AppInstallation.class;
	}

}
