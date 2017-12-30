/**
 * 
 */
package com.fixit.core.dao.sql;

import java.util.List;

import com.fixit.core.dao.CommonDao;
import com.fixit.core.data.sql.StoredProperty;
import com.fixit.core.data.sql.StoredProperty.StoredPropertyPK;
import com.fixit.core.general.PropertyGroup;
import com.fixit.core.general.PropertyGroup.Group;
import com.fixit.core.general.TypedProperty;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/21 22:07:53 GMT+2
 */
public interface StoredPropertyDao extends CommonDao<StoredProperty, StoredPropertyPK> {
	public List<StoredProperty> getPropertyForGroup(String group);
	public PropertyGroup getPropertyGroup(Group group);
	public StoredProperty find(String group, String key);
	public TypedProperty findTyped(String group, String key);
	public TypedProperty findTyped(Group group, String key);
	
	public int get(String group, String key, int defaultValue);
	public boolean get(String group, String key, boolean defaultValue);
	public String get(String group, String key, String defaultValue);
	public double get(String group, String key, double defaultValue);
}
