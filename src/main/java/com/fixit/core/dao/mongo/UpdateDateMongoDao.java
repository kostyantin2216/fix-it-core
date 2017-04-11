/**
 * 
 */
package com.fixit.core.dao.mongo;

import org.bson.types.ObjectId;

import com.fixit.core.dao.UpdateDateDao;
import com.fixit.core.data.mongo.UpdateDateMongoModelObject;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/03/31 17:00:12 GMT+3
 */
public interface UpdateDateMongoDao<DMO extends UpdateDateMongoModelObject> extends UpdateDateDao<DMO, ObjectId> {

}
