package com.fixit.core.dao.mongo.impl;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fixit.core.config.GsonManager;
import com.fixit.core.config.MongoClientManager;
import com.fixit.core.dao.mongo.OrderDataDao;
import com.fixit.core.data.UserType;
import com.fixit.core.data.mongo.OrderData;
import com.mongodb.client.model.UpdateOneModel;
import com.mongodb.client.model.WriteModel;

@Repository("orderDataDao")
public class OrderDataDaoImpl extends MongoDaoImpl<OrderData> 
		implements OrderDataDao {

	@Autowired
	public OrderDataDaoImpl(MongoClientManager mongoClientManager, GsonManager gsonManager) {
		super(mongoClientManager.getCollection(TABLE_NAME), gsonManager.getMongoGson());
	}
	
	@Override
	public List<OrderData> getOrdersForUser(ObjectId userId) {
		return findByProperty(PROP_USER_ID, userId.toHexString());
	}
	
	@Override
	public List<OrderData> getOrdersForUsersOfType(String[] userIds, UserType userType) {
		Bson bson = and(in(PROP_USER_ID, userIds), eq(PROP_USER_TYPE, userType.toString()));
		MongoClientManager.printBson(bson);
		return convertToList(mCollection.find(bson).iterator());
	}
	
	@Override
	public void updateUsersForOrders(List<OrderData> orders) {
		List<WriteModel<Document>> writes = new ArrayList<WriteModel<Document>>();
		for(OrderData order : orders) {
			Map<String, Object> orderData = new HashMap<>();
			orderData.put(PROP_USER_ID, order.getUserId());
			orderData.put(PROP_USER_TYPE, order.getUserType());
			writes.add(new UpdateOneModel<>(
					new Document(PROP_ID, order.get_id()), 
					new Document("$set", Document.parse(mGson.toJson(orderData)))
			));
		}
		
		mCollection.bulkWrite(writes);
	}
	
	@Override
	public List<OrderData> getOrdersForTradesman(ObjectId tradesmanId) {
		return findByProperty(PROP_TRADESMEN, tradesmanId.toHexString());
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<OrderData> getEntityClass() {
		return OrderData.class;
	}

}
