package com.fixit.core.dao.mongo.impl;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.mongo.UserDao;
import com.fixit.core.data.mongo.User;

@Repository("userDao")
public class UserDaoImpl extends MongoDaoImpl<User>
		implements UserDao {

	public final static String TABLE_NAME = "User";
	
	public final static String PROP_NAME = "name";
	public final static String PROP_EMAIL = "email";
	public final static String PROP_TELEPHONE = "telephone";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}

}
