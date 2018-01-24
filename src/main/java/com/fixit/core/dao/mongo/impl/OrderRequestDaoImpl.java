/**
 * 
 */
package com.fixit.core.dao.mongo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fixit.core.config.GsonManager;
import com.fixit.core.config.MongoClientManager;
import com.fixit.core.dao.mongo.OrderRequestDao;
import com.fixit.core.data.mongo.OrderRequest;

/**
 * @author 		Kostyantin
 * @createdAt 	2018/01/17 18:39:10 GMT+2
 */
@Repository("orderRequestDao")
public class OrderRequestDaoImpl extends MongoDaoImpl<OrderRequest> implements OrderRequestDao {

	@Autowired
	public OrderRequestDaoImpl(MongoClientManager mongoClientManager, GsonManager gsonManager) {
		super(mongoClientManager.getCollection(TABLE_NAME), gsonManager.getMongoGson());
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<OrderRequest> getEntityClass() {
		return OrderRequest.class;
	}

}
