/**
 * 
 */
package com.fixit.core.dao.mongo;

import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;

import com.fixit.core.data.mongo.User;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/15 22:00:02 GMT+2
 */
public interface UserDao extends MongoDao<User> {
	Map<ObjectId, Map<String, String>> getDataForReviews(Set<ObjectId> forUsers);
}
