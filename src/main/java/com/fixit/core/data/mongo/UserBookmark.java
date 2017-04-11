/**
 * 
 */
package com.fixit.core.data.mongo;

import java.util.Arrays;

import org.bson.types.ObjectId;

import com.fixit.core.data.DataMapping;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/16 20:30:01 GMT+2
 */
public class UserBookmark implements MongoModelObject {

	private ObjectId _id;
	private ObjectId userId;
	private DataMapping[] mappings;
	
	public UserBookmark() { }
	
	public UserBookmark(ObjectId userId, DataMapping[] mappings) {
		this.userId = userId;
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

	public ObjectId getUserId() {
		return userId;
	}

	public void setUserId(ObjectId userId) {
		this.userId = userId;
	}

	public DataMapping[] getMappings() {
		return mappings;
	}

	public void setMappings(DataMapping[] mappings) {
		this.mappings = mappings;
	}

	@Override
	public String toString() {
		return "UserBookmark [_id=" + _id + ", userId=" + userId + ", mappings=" + Arrays.toString(mappings) + "]";
	}

}
