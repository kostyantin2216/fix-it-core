/**
 * 
 */
package com.fixit.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fixit.core.dao.sql.StoredPropertyDao;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/09 17:41:32 GMT+3
 */
@Component
public class CoreConfiguration {
	
	private final StoredPropertyDao mStoredPropertyDao;
	
	@Autowired
	public CoreConfiguration(StoredPropertyDao storedPropertyDao) {
		mStoredPropertyDao = storedPropertyDao;
	}
	/*
	public Integer getInt(String key) {
		StoredProperty storedProperty
		return mStoredPropertyDao.findById(id)
	}*/

}
