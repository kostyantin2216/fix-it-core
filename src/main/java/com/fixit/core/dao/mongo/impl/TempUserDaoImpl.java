/**
 * 
 */
package com.fixit.core.dao.mongo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fixit.core.config.GsonManager;
import com.fixit.core.config.MongoClientManager;
import com.fixit.core.dao.mongo.TempUserDao;
import com.fixit.core.data.mongo.TempUser;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/11/10 23:54:06 GMT+2
 */
@Repository("tempUserDao")
public class TempUserDaoImpl extends MongoDaoImpl<TempUser> implements TempUserDao {

	@Autowired
	public TempUserDaoImpl(MongoClientManager mongoClientManager, GsonManager gsonManager) {
		super(mongoClientManager.getCollection(TABLE_NAME), gsonManager.getMongoGson());
	}
	
	@Override
	public List<TempUser> findByTelephone(String telephone) {
		return findByProperty(PROP_TELEPHONE, telephone);
	}
	
	@Override
	public TempUser findFirstWithTelephone(String telephone) {
		List<TempUser> users = findByTelephone(telephone);
		if(users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<TempUser> getEntityClass() {
		return TempUser.class;
	}

}
