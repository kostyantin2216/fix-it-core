/**
 * 
 */
package com.fixit.core.dao.mongo;

import com.fixit.core.data.mongo.Order;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/15 21:55:03 GMT+2
 */
public interface OrderDao extends MongoDao<Order> {
	public final static String TABLE_NAME = "Job";
	
	public final static String PROP_TRADESMAN_ID = "tradesmanId";
	public final static String PROP_USER_ID = "userId";
	public final static String PROP_LOCATION = "location";
	public final static String PROP_COMMENT = "comment";
	public final static String PROP_PROBLEMS = "problems";
	
}
