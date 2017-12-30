/**
 * 
 */
package com.fixit.core.data;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/11/17 14:57:29 GMT+2
 */
public class KeyValuePair<K, V> {

	private final K key;
	private final V value;
	
	public KeyValuePair(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "{" + key + ": " + value + "}";
	}
}
