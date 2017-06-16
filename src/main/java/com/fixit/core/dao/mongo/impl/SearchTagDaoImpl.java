/**
 * 
 */
package com.fixit.core.dao.mongo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fixit.core.config.GsonManager;
import com.fixit.core.config.MongoClientManager;
import com.fixit.core.dao.mongo.SearchTagDao;
import com.fixit.core.data.mongo.SearchTag;

/**
 * @author 		Kostyantin
 * @createdAt 	2016/12/16 20:26:37 GMT+2
 */
@Repository("searchDao")
public class SearchTagDaoImpl extends MongoDaoImpl<SearchTag> implements SearchTagDao {

	public final static String TABLE_NAME = "SearchTag";
	
	public final static String PROP_TAG = "tag";
	public final static String PROP_MAPPINGS = "mappings";

	@Autowired
	public SearchTagDaoImpl(MongoClientManager mongoClientManager, GsonManager gsonManager) {
		super(mongoClientManager.getCollection(TABLE_NAME), gsonManager.getMongoGson());
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<SearchTag> getEntityClass() {
		return SearchTag.class;
	}

}
