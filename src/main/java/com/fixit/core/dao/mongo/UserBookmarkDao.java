/**
 * 
 */
package com.fixit.core.dao.mongo;

import com.fixit.core.data.mongo.UserBookmark;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/16 20:31:42 GMT+2
 */
public interface UserBookmarkDao extends MongoDao<UserBookmark> {
	public final static String TABLE_NAME = "UserBookmark";
	
	public final static String PROP_USER_ID = "userId";
	public final static String PROP_MAPPINGS = "mappings";
}
