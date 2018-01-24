/**
 * 
 */
package com.fixit.core.dao.mongo;

import com.fixit.core.data.mongo.OrderRequest;

/**
 * @author 		Kostyantin
 * @createdAt 	2018/01/17 18:36:20 GMT+2
 */
public interface OrderRequestDao extends MongoDao<OrderRequest> {
	
	public final static String TABLE_NAME = "OrderRequest";

	public final static String PROP_TRADESMEN = "tradesmen";
	public final static String PROP_USER_ID = "userId";
	public final static String PROP_PROFESSION_ID = "professionId";
	public final static String PROP_LOCATION = "location";
	public final static String PROP_COMMENT = "comment";
	public final static String PROP_TRAFFIC_SRC_ID = "trafficSourceId";
	public final static String PROP_ORDER_TYPE = "orderType";
	public final static String PROP_CREATED_AT = "createdAt";
	
}
