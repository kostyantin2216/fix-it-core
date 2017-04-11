/**
 * 
 */
package com.fixit.core.dao.mongo.impl;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.mongo.SynchronizationParamsDao;
import com.fixit.core.data.mongo.SynchronizationParams;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/03/30 23:18:25 GMT+3
 */
@Repository("synchronizationParamsDao")
public class SynchronizationParamsDaoImpl extends MongoDaoImpl<SynchronizationParams>
	implements SynchronizationParamsDao {
	
	public final static String TABLE_NAME = "SynchronizationParams";
	
	public final static String PROP_TABLE_NAME = "tableName";
	public final static String PROP_ACTIONS = "actions";

	@Override
	public SynchronizationParams findByTableName(String name) {
		return findOneByProperty(PROP_TABLE_NAME, name);
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<SynchronizationParams> getEntityClass() {
		return SynchronizationParams.class;
	}

}
