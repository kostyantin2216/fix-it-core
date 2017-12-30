/**
 * 
 */
package com.fixit.core.general;

import com.fixit.core.data.sql.StoredProperty;
import com.fixit.core.data.sql.StoredProperty.Type;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/12/01 16:27:00 GMT+2
 */
public class TypedProperty {
	
	private final StoredProperty.Type mType;
	private final Object mValue;
	
	public TypedProperty(StoredProperty property) {
		mType = property.getValueType();
		if(mType != null) {
			final String value = property.getValue();
			switch (mType) {
				case STRING:
					mValue = value;
					break;
				case BOOLEAN:
					mValue = Boolean.parseBoolean(value);
					break;
				case INTEGER:
					mValue = Integer.parseInt(value);
					break;
				case DOUBLE:
					mValue = Double.parseDouble(value);
					break;
				default:
					mValue = null;
			}
		} else {
			mValue = null;
		}
	}
	
	public Object get() {
		return mValue;
	}
	
	public StoredProperty.Type getType() {
		return mType;
	}

	public String getOrDefault(String defaultValue) {
		if(mType != null && mType == Type.STRING) {
			return (String) mValue;
		}
		return defaultValue;
	}
	
	public boolean getOrDefault(boolean defaultValue) {
		if(mType != null && mType == Type.STRING) {
			return (boolean) mValue;
		}
		return defaultValue;
	}
	
	public int getOrDefault(int defaultValue) {
		if(mType != null && mType == Type.STRING) {
			return (int) mValue;
		}
		return defaultValue;
	}
	
	public double getOrDefault(double defaultValue) {
		if(mType != null && mType == Type.STRING) {
			return (double) mValue;
		}
		return defaultValue;
	}
	
}
