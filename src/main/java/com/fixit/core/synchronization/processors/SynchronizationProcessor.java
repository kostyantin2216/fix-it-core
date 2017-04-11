/**
 * 
 */
package com.fixit.core.synchronization.processors;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fixit.core.dao.UpdateDateDao;
import com.fixit.core.data.UpdateDateDataModelObject;
import com.fixit.core.data.mongo.SynchronizationParams;
import com.fixit.core.synchronization.SynchronizationAction;
import com.fixit.core.synchronization.SynchronizationResult;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/03/30 22:01:12 GMT+3
 */
public interface SynchronizationProcessor<DAO extends UpdateDateDao<DMO, ID>, DMO extends UpdateDateDataModelObject<ID>, ID extends Serializable> {

	public SynchronizationResult<DMO, ID> process(Date firstSynchronization, SynchronizationParams params, Set<SynchronizationAction> actions);
	public String getDmoName();
	
}
