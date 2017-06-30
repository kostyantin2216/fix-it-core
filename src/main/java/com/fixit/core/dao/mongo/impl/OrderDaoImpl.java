package com.fixit.core.dao.mongo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fixit.core.config.GsonManager;
import com.fixit.core.config.MongoClientManager;
import com.fixit.core.dao.mongo.OrderDao;
import com.fixit.core.data.mongo.Order;

@Repository("orderDao")
public class OrderDaoImpl extends MongoDaoImpl<Order> 
		implements OrderDao {

	@Autowired
	public OrderDaoImpl(MongoClientManager mongoClientManager, GsonManager gsonManager) {
		super(mongoClientManager.getCollection(TABLE_NAME), gsonManager.getMongoGson());
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<Order> getEntityClass() {
		return Order.class;
	}

}
