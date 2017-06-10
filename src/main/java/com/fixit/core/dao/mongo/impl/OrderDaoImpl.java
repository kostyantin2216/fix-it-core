package com.fixit.core.dao.mongo.impl;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.mongo.OrderDao;
import com.fixit.core.data.mongo.Order;

@Repository("orderDao")
public class OrderDaoImpl extends MongoDaoImpl<Order> 
		implements OrderDao {

	public final static String TABLE_NAME = "Job";
	
	public final static String PROP_TRADESMAN_ID = "tradesmanId";
	public final static String PROP_USER_ID = "userId";
	public final static String PROP_LOCATION = "location";
	public final static String PROP_COMMENT = "comment";
	public final static String PROP_PROBLEMS = "problems";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<Order> getEntityClass() {
		return Order.class;
	}

}
