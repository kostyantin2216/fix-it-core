package com.fixit.core.dao.sql;

import com.fixit.core.data.sql.Review;
import com.fixit.core.data.sql.Review.ReviewPK;

public interface ReviewDao extends SqlDao<Review, ReviewPK> {
	Integer getCountForTradesman(String tradesmanId);
}
