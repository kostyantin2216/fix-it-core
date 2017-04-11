/**
 * 
 */
package com.fixit.core.dao.mongo.impl;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.mongo.UserBookmarkDao;
import com.fixit.core.data.mongo.UserBookmark;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/16 20:32:24 GMT+2
 */
@Repository("userBookmarkDao")
public class UserBookmarkDaoImpl extends MongoDaoImpl<UserBookmark> implements UserBookmarkDao {

	public final static String TABLE_NAME = "UserBookmark";
	
	public final static String PROP_USER_ID = "userId";
	public final static String PROP_MAPPINGS = "mappings";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<UserBookmark> getEntityClass() {
		return UserBookmark.class;
	}

}
