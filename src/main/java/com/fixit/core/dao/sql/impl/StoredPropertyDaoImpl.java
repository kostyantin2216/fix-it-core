/**
 * 
 */
package com.fixit.core.dao.sql.impl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.sql.StoredPropertyDao;
import com.fixit.core.data.sql.StoredProperty;
import com.fixit.core.data.sql.StoredProperty.StoredPropertyPK;
import com.fixit.core.general.PropertyGroup;
import com.fixit.core.general.PropertyGroup.Group;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/21 22:09:02 GMT+2
 */
@Repository("storedPropertyDao")
public class StoredPropertyDaoImpl extends SqlDaoImpl<StoredProperty, StoredPropertyPK> implements StoredPropertyDao {

	private final ConcurrentMap<String, PropertyGroup> propertyGroupsCache = new ConcurrentHashMap<>();
	
	public final static String TABLE_NAME = "StoredProperty";
	
	public final static String PROP_GROUP = "group";
	public final static String PROP_KEY = "key";
	public final static String PROP_VALUE = "value";
	public final static String PROP_UPDATED_AT = "updatedAt";
	
	@Override
	public List<StoredProperty> getPropertyForGroup(String group) {
		return findByProperty(PROP_GROUP, group);
	}

	@Override
	public PropertyGroup getPropertyGroup(Group group) {
		PropertyGroup propertyGroup = propertyGroupsCache.get(group.name());
		if(propertyGroup == null) {
			propertyGroup = new PropertyGroup(this, group);
			propertyGroupsCache.putIfAbsent(group.name(), propertyGroup);
		}
		return propertyGroup;
	}
	
	@Override
	public StoredProperty find(String group, String key) {
		return findById(new StoredPropertyPK(group, key));
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}
	
	@Override
	public Class<StoredProperty> getEntityClass() {
		return StoredProperty.class;
	}

}
