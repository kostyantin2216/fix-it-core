/**
 * 
 */
package com.fixit.core.dao.mongo;

import java.util.List;

import org.bson.types.ObjectId;

import com.fixit.core.data.mongo.OrderData;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/15 21:55:03 GMT+2
 */
public interface OrderDataDao extends MongoDao<OrderData> {
	public final static String TABLE_NAME = "Order";
	
	public final static String PROP_TRADESMEN = "tradesmen";
	public final static String PROP_USER_ID = "userId";
	public final static String PROP_PROFESSION_ID = "professionId";
	public final static String PROP_LOCATION = "location";
	public final static String PROP_JOB_REASONS = "jobReasons";
	public final static String PROP_COMMENT = "comment";
	public final static String PROP_FEEDBACK_PROVIDED = "feedbackProvided";
	public final static String PROP_CREATED_AT = "createdAt";
	
	public List<OrderData> getOrdersForUser(ObjectId userId);

}
