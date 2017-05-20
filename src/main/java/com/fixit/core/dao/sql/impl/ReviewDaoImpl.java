package com.fixit.core.dao.sql.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.sql.ReviewDao;
import com.fixit.core.data.sql.Review;
import com.fixit.core.data.sql.Review.ReviewPK;

@Repository("reviewDao")
public class ReviewDaoImpl extends SqlDaoImpl<Review, ReviewPK> 
		implements ReviewDao {
	
	public final static String TABLE_NAME = "Review";
	
	public final static String PROP_USER_ID = "userId";
	public final static String PROP_TRADESMAN_ID = "tradesmanId";
	public final static String PROP_TITLE = "title";
	public final static String PROP_CONTENT = "content";
	public final static String PROP_RATING = "rating";
	public final static String PROP_IS_ON_DISPLAY = "isOnDisplay";
	public final static String PROP_CREATED_AT = "createdAt";

	@Override
	public Long getCountForTradesman(String tradesmanId) {
		Map<String, Object> props = new HashMap<>();
		props.put(PROP_TRADESMAN_ID, tradesmanId);
		return getCount(props);
	}
	
	@Override
	public List<Review> getReviewsForTradesman(String tradesmanId) {
		return findByProperty(PROP_TRADESMAN_ID, tradesmanId);
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<Review> getEntityClass() {
		return Review.class;
	}

}
