/**
 * 
 */
package com.fixit.core.dao.sql;

import java.util.List;

import com.fixit.core.data.sql.JobReason;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/06/01 17:21:20 GMT+3
 */
public interface JobReasonDao extends UpdateDateSqlDao<JobReason, Integer> {

	public final static String TABLE_NAME = "JobReason";
	
	public final static String PROP_ID = "id";
	public final static String PROP_PROFESSION_ID = "professionId";
	public final static String PROP_NAME = "name";
	public final static String PROP_COMMENT = "comment";
	public final static String PROP_UPDATED_AT = "updatedAt";
	
	List<JobReason> findReasonsForProfession(Integer professionId);
}
