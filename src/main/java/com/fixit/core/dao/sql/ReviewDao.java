package com.fixit.core.dao.sql;

import java.util.List;

import com.fixit.core.data.sql.Review;
import com.fixit.core.data.sql.Review.ReviewPK;

public interface ReviewDao extends SqlDao<Review, ReviewPK> {
	Long getCountForTradesman(String tradesmanId);
	List<Review> getReviewsForTradesman(String tradesmanId);
}
