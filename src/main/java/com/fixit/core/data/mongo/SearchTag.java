/**
 * 
 */
package com.fixit.core.data.mongo;

import java.util.Arrays;

import org.bson.types.ObjectId;

import com.fixit.core.data.DataMapping;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/16 20:22:35 GMT+2
 */
public class SearchTag implements MongoModelObject {
	
	private ObjectId _id;
	private String tag;
	private DataMapping[] mappings;
	
	public SearchTag() { }

	public SearchTag(String tag, DataMapping[] mappings) {
		this.tag = tag;
		this.mappings = mappings;
	}

	@Override
	public ObjectId get_id() {
		return _id;
	}

	@Override
	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public DataMapping[] getMappings() {
		return mappings;
	}

	public void setMappings(DataMapping[] mappings) {
		this.mappings = mappings;
	}
	
	@Override
	public String toString() {
		return "SearchTag [_id=" + _id + ", tag=" + tag + ", mappings=" + Arrays.toString(mappings) + "]";
	}

}
