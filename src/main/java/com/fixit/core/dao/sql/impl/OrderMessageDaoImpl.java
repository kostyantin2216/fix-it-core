/**
 * 
 */
package com.fixit.core.dao.sql.impl;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.sql.OrderMessageDao;
import com.fixit.core.data.sql.OrderMessage;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/05/29 18:10:38 GMT+3
 */
@Repository("orderMessageDao")
public class OrderMessageDaoImpl extends SqlDaoImpl<OrderMessage, String> 
	implements OrderMessageDao {
	
	public final static String TABLE_NAME = "OrderMessage";
	
	public final static String PROP_MESSAGE_SID = "messageSid";
	public final static String PROP_ORDER_ID = "orderId";
	public final static String PROP_USER_ID = "userId";
	public final static String PROP_TRADESMAN_ID = "tradesmanId";
	public final static String PROP_CONTENT = "cotent";
	public final static String PROP_SENT_AT = "sentAt";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<OrderMessage> getEntityClass() {
		return OrderMessage.class;
	}

}
