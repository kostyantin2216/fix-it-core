package com.fixit.core.dao.mongo.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fixit.core.config.GsonManager;
import com.fixit.core.config.MongoClientManager;
import com.fixit.core.dao.mongo.OrderDataDao;
import com.fixit.core.data.mongo.OrderData;

@Repository("orderDataDao")
public class OrderDataDaoImpl extends MongoDaoImpl<OrderData> 
		implements OrderDataDao {

	@Autowired
	public OrderDataDaoImpl(MongoClientManager mongoClientManager, GsonManager gsonManager) {
		super(mongoClientManager.getCollection(TABLE_NAME), gsonManager.getMongoGson());
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<OrderData> getEntityClass() {
		return OrderData.class;
	}
	
	@Override
	public List<OrderData> getOrdersForUser(ObjectId userId) {
		return findByProperty(PROP_USER_ID, userId.toHexString());
	}

}
