/**
 * 
 */
package com.fixit.core.data.mongo;

import java.util.Arrays;

import org.bson.types.ObjectId;

import com.fixit.core.data.SynchronizationAction;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/03/30 23:12:58 GMT+3
 */
public class SynchronizationParams implements MongoModelObject {

	private ObjectId _id;
	private String tableName;
	private SynchronizationAction[] actions;
	
	public ObjectId get_id() {
		return _id;
	}
	
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	public SynchronizationAction[] getActions() {
		return actions;
	}
	
	public void setActions(SynchronizationAction[] actions) {
		this.actions = actions;
	}
	
	@Override
	public String toString() {
		return "SynchronizationParams [_id=" + _id + ", tableName=" + tableName + ", appDaoClassName=" + ", actions=" + Arrays.toString(actions) + "]";
	}
	
}
