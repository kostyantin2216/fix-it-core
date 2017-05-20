/**
 * 
 */
package com.fixit.core.general;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.fixit.core.dao.sql.StoredPropertyDao;
import com.fixit.core.data.sql.StoredProperty;
import com.fixit.core.logging.FILog;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/27 22:40:51 GMT+3
 */
public class PropertyGroup {
	
	private final static String LOG_TAG = PropertyGroup.class.getSimpleName();
	
	public enum Group {
		mail,
		web, 
		forms
	}

	private final ImmutableMap<String, Object> properties;
	private final Gson gson;
	
	public PropertyGroup(StoredPropertyDao dao, Group group) {
		this.gson = new Gson();
		List<StoredProperty> properties = dao.getPropertyForGroup(group.name());
		
		if(properties != null) {
		Map<String, Object> propertiesMap = new HashMap<>();
		for(StoredProperty property : properties) {
				StoredProperty.Type type = property.getValueType();
				if(type != null) {
					final String key = property.getKey();
					final String value = property.getValue();
					switch (type) {
						case STRING:
							propertiesMap.put(key, value);
							break;
						case BOOLEAN:
							propertiesMap.put(key, Boolean.parseBoolean(value));
							break;
						case INTEGER:
							propertiesMap.put(key, Integer.parseInt(value));
							break;
						case DOUBLE:
							propertiesMap.put(key, Double.parseDouble(value));
							break;
					}
				}
			}
			this.properties = ImmutableMap.copyOf(propertiesMap);
		} else {
			this.properties = ImmutableMap.of();
		}
	}
	
	public Boolean getBoolean(String key, Boolean defaultVal) {
		try {
			return (Boolean) properties.get(key);
		} catch (ClassCastException e) {
			handleCCE(key, e);
			return defaultVal;
		}
	}
	
	public String getString(String key, String defaultVal) {
		try {
			return (String) properties.get(key);
		} catch (ClassCastException e) {
			handleCCE(key, e);
			return defaultVal;
		}
	}
	
	public Integer getInteger(String key, Integer defaultVal) {
		try {
			return (Integer) properties.get(key);
		} catch (ClassCastException e) {
			handleCCE(key, e);
			return defaultVal;
		}
	}
	
	public Double getDouble(String key, Double defaultVal) {
		try {
			return (Double) properties.get(key);
		} catch (ClassCastException e) {
			handleCCE(key, e);
			return defaultVal;
		}
	}
	
	private void handleCCE(String key, ClassCastException e) {
		FILog.e(LOG_TAG, "Wrong type for property with key: " + key, e, true);
	}
	
	public <T> T getJsonProperty(String key, Class<T> type) {
		return gson.fromJson(getString(key, ""), type);
	}

	public <T> List<T> getJsonProperty(String key, Type listType) {
		return gson.fromJson(getString(key, ""), listType);
	}
	
	public Properties extractProperties(String... keys) {
		Properties props = new Properties();
		for(String key : keys) {
			Object value = properties.get(key);
			if(value != null) {
				props.put(key, value);
			}
		}
		return props;
	}
}
