/**
 * 
 */
package com.fixit.core.tasks;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/03/30 22:44:37 GMT+3
 * 
 * 	Lazy load errors since they aren't supposed to happen in the first place.
 * 	Critical error if the error caused the task to stop.
 */
public class TaskResult<T> {
	
	private T result;
	private List<Error> errors;
	private boolean criticalError;
	
	public T getResult() {
		return result;
	}
	
	public void setResult(T result) {
		this.result = result;
	}
	
	public List<Error> getErrors() {
		return errors;
	}
	
	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
	
	public boolean isCriticalError() {
		return criticalError;
	}
	
	public void addError(String msg) {
		addError(msg, null);
	}
	
	public void addError(String msg, Throwable t) {
		if(this.errors == null) {
			this.errors = new ArrayList<>();
		}
		this.errors.add(new Error(msg, t));
	}
	
	public void criticalError(String msg) {
		criticalError(msg, null);
	}
	
	public void criticalError(String msg, Throwable t) {
		this.criticalError = true;
		addError(msg, t);
	}
	
	public Error getFirstError() {
		return errors != null && !errors.isEmpty() ? errors.get(0) : null;
	}

	@Override
	public String toString() {
		return "TaskResult [result=" + result + ", errors=" + errors + ", criticalError=" + criticalError + "]";
	}
	
	public static class Error {
		private final String msg;
		private final Throwable t;
		
		private Error(String msg, Throwable t) {
			this.msg = msg;
			this.t = t;
		}
		
		public String getMsg() {
			return msg;
		}

		public Throwable getT() {
			return t;
		}

		@Override
		public String toString() {
			return "TaskError [msg=" + msg + ", t=" + t + "]";
		}
	}
	
}
