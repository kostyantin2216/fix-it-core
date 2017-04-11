/**
 * 
 */
package com.fixit.core.data.mongo;

import org.bson.types.ObjectId;

import com.fixit.core.data.UpdateDateDataModelObject;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/03/31 16:56:03 GMT+3
 */
public interface UpdateDateMongoModelObject extends MongoModelObject, UpdateDateDataModelObject<ObjectId> {

}
