/**
 * 
 */
package com.fixit.core.dao.sql.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.sql.JobReasonDao;
import com.fixit.core.data.sql.JobReason;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/06/01 17:22:23 GMT+3
 */
@Repository("jobReasonDao")
public class JobReasonDaoImpl extends UpdateDateSqlDaoImpl<JobReason, Integer> implements JobReasonDao {
	
	@Override
	public List<JobReason> findReasonsForProfession(Integer professionId) {
		return findByProperty(PROP_PROFESSION_ID, professionId);
	}

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public Class<JobReason> getEntityClass() {
		return JobReason.class;
	}
	
	@Override
	public String getUpdatePropertyName() {
		return PROP_UPDATED_AT;
	}
}
