/**
 * 
 */
package com.fixit.core.data;

import com.fixit.core.data.mongo.CommonUser;
import com.fixit.core.data.mongo.OrderData;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/12/01 22:08:56 GMT+2
 */
public class UserLead {

	private final CommonUser user;
	private final OrderData order;

	public UserLead(CommonUser user, OrderData order) {
		this.user = user;
		this.order = order;
	}

	public CommonUser getUser() {
		return user;
	}

	public OrderData getOrder() {
		return order;
	}
	
}
