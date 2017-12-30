/**
 * 
 */
package com.fixit.core.dao.mongo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;

import com.fixit.core.data.mongo.User;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/15 22:00:02 GMT+2
 */
public interface UserDao extends MongoDao<User> {
	public final static String TABLE_NAME = "User";
	
	public final static String PROP_NAME = "name";
	public final static String PROP_EMAIL = "email";
	public final static String PROP_TELEPHONE = "telephone";
	public final static String PROP_USER_AVATER_URL = "userAvatarUrl";
	public final static String PROP_FACEBOOK_ID = "facebookId";
	public final static String PROP_GOOGLE_ID = "googleId";
	
	List<User> findByTelephone(String telephone);
	User findFirstWithTelephone(String telephone);
	
	Map<ObjectId, Map<String, String>> getDataForReviews(Set<ObjectId> forUsers);
}
