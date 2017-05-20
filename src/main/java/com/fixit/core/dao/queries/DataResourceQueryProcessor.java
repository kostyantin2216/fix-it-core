/**
 * 
 */
package com.fixit.core.dao.queries;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/05/17 20:41:17 GMT+3
 */
public interface DataResourceQueryProcessor<RESULT> {
	
	RESULT process(DataResourceQuery query, String valueTypeClassName);
	
	public enum QueryOperator {
		EQUAL("="),
		NOT_EQUAL("!="),
		GREATE_THEN(">"),
		LESS_THEN("<"),
		LESS_THEN_OR_EQUAL("<=", "=<"),
		GREATER_THEN_OR_EQUAL(">=", "=>");
		
		final String[] operators;
		
		QueryOperator(String... operators) {
			this.operators = operators;
		}
		
		public static QueryOperator findByOperator(String operator) {
			for(QueryOperator queryOperator : values()) {
				for(String stringOperator : queryOperator.operators) {
					if(stringOperator.equals(operator)) {
						return queryOperator;
					}
				}
			}
			return null;
		}
	}
}	
