/**
 * 
 */
package com.fixit.core.general;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import com.fixit.core.dao.sql.StoredPropertyDao;
import com.fixit.core.data.sql.StoredProperty;
import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/04/27 22:40:51 GMT+3
 */
public class PropertyGroup {
		
	public enum Group {
		events,
		sms,
		mail,
		web, 
		forms, 
		orders, 
		rest
	}

	private final ImmutableMap<String, TypedProperty> properties;
	private final Gson gson;
	
	public PropertyGroup(StoredPropertyDao dao, Group group) {
		this.gson = new Gson();
		List<StoredProperty> properties = dao.getPropertyForGroup(group.name());
		
		if(properties != null && !properties.isEmpty()) {
			this.properties = ImmutableMap.copyOf(properties
					.stream()
					.collect(
							Collectors.toMap(
									StoredProperty::getKey, 
									TypedProperty::new
							)
					)
			);
		} else {
			this.properties = ImmutableMap.of();
		}
	}
	
	public boolean getBoolean(String key, boolean defaultValue) {
		TypedProperty property = properties.get(key);
		if(property != null) {
			return property.getOrDefault(defaultValue);
		}
		return defaultValue;
	}
	
	public String getString(String key, String defaultValue) {
		TypedProperty property = properties.get(key);
		if(property != null) {
			return property.getOrDefault(defaultValue);
		}
		return defaultValue;
	}
	
	public int getInteger(String key, int defaultValue) {
		TypedProperty property = properties.get(key);
		if(property != null) {
			return property.getOrDefault(defaultValue);
		}
		return defaultValue;
	}
	
	public double getDouble(String key, double defaultValue) {
		TypedProperty property = properties.get(key);
		if(property != null) {
			return property.getOrDefault(defaultValue);
		}
		return defaultValue;
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
			Object value = properties.get(key).get();
			if(value != null) {
				props.put(key, value);
			}
		}
		return props;
	}
}
