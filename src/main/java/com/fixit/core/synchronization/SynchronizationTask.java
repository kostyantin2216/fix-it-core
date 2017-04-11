/**
 * 
 */
package com.fixit.core.synchronization;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeansException;

import com.fixit.core.config.CoreContextProvider;
import com.fixit.core.dao.mongo.SynchronizationParamsDao;
import com.fixit.core.data.mongo.SynchronizationParams;
import com.fixit.core.logging.FILog;
import com.fixit.core.synchronization.processors.SynchronizationProcessor;
import com.fixit.core.tasks.TaskResult;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/03/29 22:21:16 GMT+3
 */
@SuppressWarnings("rawtypes")
public class SynchronizationTask {
	
	private final static String PROCESSOR_NAME_SUFFIX = "Processor";
	
	private final SynchronizationParamsDao synchronizationParamsDao;
	
	private final Date firstSynchronization;

	public SynchronizationTask(SynchronizationParamsDao synchronizationParamsDao, Date firstSynchronizationDate) {
		this.synchronizationParamsDao = synchronizationParamsDao;
		this.firstSynchronization = firstSynchronizationDate;
	}
	
	public TaskResult<List<SynchronizationResult>> process(Map<String, Set<SynchronizationAction>> historyMap) {
		TaskResult<List<SynchronizationResult>> result = new TaskResult<>();		
		
		List<SynchronizationResult> synchronizationResults = new ArrayList<>();
		for(Map.Entry<String, Set<SynchronizationAction>> historyEntry : historyMap.entrySet()) {
			String name = historyEntry.getKey().toLowerCase();
			SynchronizationResult synchronizationResult = process(name, historyEntry.getValue());
			if(synchronizationResult != null) {
				synchronizationResults.add(synchronizationResult);
			} else {
				result.addError("error while synchronizing " + name);
			}
		}
		result.setResult(synchronizationResults);
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	private SynchronizationResult process(String name, Set<SynchronizationAction> actions) {
		String processorName = name + PROCESSOR_NAME_SUFFIX;
		try {
			SynchronizationProcessor processor = (SynchronizationProcessor) CoreContextProvider.getBean(processorName);
			SynchronizationParams params = synchronizationParamsDao.findByTableName(name);
			SynchronizationResult result = processor.process(firstSynchronization, params, actions);
			result.setName(name);
			return result;
		} catch(ClassCastException e) {
			FILog.e(processorName + " bean is not of type " + SynchronizationProcessor.class.getName(), e);
		} catch(BeansException e) {
			FILog.e(processorName + " bean cannot be found", e);
		}
		return null;
	}
	
}
