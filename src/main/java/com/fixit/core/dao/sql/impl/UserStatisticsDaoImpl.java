package com.fixit.core.dao.sql.impl;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.sql.UserStatisticsDao;
import com.fixit.core.data.sql.UserStatistics;

@Repository
public class UserStatisticsDaoImpl extends SqlDaoImpl<UserStatistics, String>
		implements UserStatisticsDao {
	
	public final static String TABLE_NAME = "UserStatistics";
	
	public final static String PROP_USER_ID = "userId";
	public final static String PROP_JOBS_ORDERED = "jobsOrdered";
	public final static String PROP_REVIEWS_MADE = "reviewsMade";
	public final static String PROP_REGISTRATION_DATE = "registrationDate";

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<UserStatistics> getEntityClass() {
		return UserStatistics.class;
	}

}
