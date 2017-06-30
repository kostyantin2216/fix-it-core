/**
 * 
 */
package com.fixit.core.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/06/28 00:14:45 GMT+3
 */
public class MapBuilder<K, V> {
	
	private Map<K, V> map;
	
	public MapBuilder() {
		map = new HashMap<>();
	}

	public MapBuilder(Map<K, V> map) {
		this.map = map;
	}
	
	public MapBuilder<K, V> put(K key, V value) {
		this.map.put(key, value);
		return this;
	}
	
	public Map<K, V> build() {
		return map;
	}
	
}
