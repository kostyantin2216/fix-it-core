/**
 * 
 */
package com.fixit.core.dao.sql.impl;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.sql.StoredPropertyDao;
import com.fixit.core.data.sql.StoredProperty;
import com.fixit.core.data.sql.StoredProperty.StoredPropertyPK;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/21 22:09:02 GMT+2
 */
@Repository("storedPropertyDao")
public class StoredPropertyDaoImpl extends SqlDaoImpl<StoredProperty, StoredPropertyPK> implements StoredPropertyDao {

	public final static String TABLE_NAME = "StoredProperty";
	
	public final static String PROP_GROUP = "group";
	public final static String PROP_KEY = "key";
	public final static String PROP_VALUE = "value";
	public final static String PROP_UPDATED_AT = "updatedAt";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}
	
	@Override
	public Class<StoredProperty> getEntityClass() {
		return StoredProperty.class;
	}

}
