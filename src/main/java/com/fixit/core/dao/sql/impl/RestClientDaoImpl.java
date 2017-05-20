/**
 * 
 */
package com.fixit.core.dao.sql.impl;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.sql.RestClientDao;
import com.fixit.core.data.sql.RestClient;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/25 19:43:28 GMT+2
 */
@Repository("restClientDao")
public class RestClientDaoImpl extends SqlDaoImpl<RestClient, String> implements RestClientDao {

	public final static String TABLE_NAME = "RestClient";
	
	public final static String PROP_ID = "id";
	public final static String PROP_NAME = "name";
	public final static String PROP_USER_AGENT = "userAgent";
	public final static String PROP_KEY = "key";
	public final static String PROP_IS_ACTIVE = "isActive";

	@Override
	public RestClient findByName(String name) {
		return findOneByProperty(PROP_NAME, name);
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<RestClient> getEntityClass() {
		return RestClient.class;
	}

}
