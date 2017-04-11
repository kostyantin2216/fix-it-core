/**
 * 
 */
package com.fixit.core.dao.mongo;

import com.fixit.core.data.mongo.SynchronizationParams;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/03/30 23:17:19 GMT+3
 */
public interface SynchronizationParamsDao extends MongoDao<SynchronizationParams> {

	public SynchronizationParams findByTableName(String name);
	
}
