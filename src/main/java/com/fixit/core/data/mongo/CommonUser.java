/**
 * 
 */
package com.fixit.core.data.mongo;

import com.fixit.core.dao.UserType;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/11/10 23:51:55 GMT+2
 */
public interface CommonUser extends MongoModelObject {
	UserType getType();
	String getName();
	String getEmail();
	String getTelephone();
}
