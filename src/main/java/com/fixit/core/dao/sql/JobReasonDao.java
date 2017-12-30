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
	List<JobReason> findReasonsForProfession(Integer professionId);
}
