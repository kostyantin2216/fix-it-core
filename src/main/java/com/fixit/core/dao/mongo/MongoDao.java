/**
 * 
 */
package com.fixit.core.dao.mongo;

import java.util.List;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.fixit.core.dao.CommonDao;
import com.fixit.core.data.mongo.MongoModelObject;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/15 21:52:21 GMT+2
 */
public interface MongoDao<DMO extends MongoModelObject> extends CommonDao<DMO, ObjectId> {
	public final static String PROP_ID = "_id";
	List<DMO> find(Bson bsonFilter);
}
