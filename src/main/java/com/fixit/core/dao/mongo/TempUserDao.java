/**
 * 
 */
package com.fixit.core.dao.mongo;

import java.util.List;

import com.fixit.core.data.mongo.TempUser;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/11/10 23:53:09 GMT+2
 */
public interface TempUserDao extends MongoDao<TempUser> {
	public final static String TABLE_NAME = "TempUser";
	
	public final static String PROP_NAME = "name";
	public final static String PROP_EMAIL = "email";
	public final static String PROP_TELEPHONE = "telephone";
	public final static String PROP_CREATED_AT = "createdAt";
	
	public List<TempUser> findByTelephone(String telephone);

	public TempUser findFirstWithTelephone(String telephone);
	
}
