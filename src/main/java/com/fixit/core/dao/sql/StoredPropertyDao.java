/**
 * 
 */
package com.fixit.core.dao.sql;

import java.util.List;

import com.fixit.core.dao.CommonDao;
import com.fixit.core.data.sql.StoredProperty;
import com.fixit.core.data.sql.StoredProperty.StoredPropertyPK;
import com.fixit.core.general.PropertyGroup;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/21 22:07:53 GMT+2
 */
public interface StoredPropertyDao extends CommonDao<StoredProperty, StoredPropertyPK> {
	public List<StoredProperty> getPropertyForGroup(String group);
	public PropertyGroup getPropertyGroup(PropertyGroup.Group group);
	public StoredProperty find(String group, String key);
}
