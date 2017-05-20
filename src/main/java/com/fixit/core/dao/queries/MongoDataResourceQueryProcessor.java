/**
 * 
 */
package com.fixit.core.dao.queries;

import org.bson.conversions.Bson;

import com.fixit.core.exceptions.IllegalQueryOperandException;
import com.mongodb.client.model.Filters;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/05/20 13:06:48 GMT+3
 */
public class MongoDataResourceQueryProcessor extends BaseDataResourceQueryProcessor<Bson> {
	
	@Override
	public Bson process(DataResourceQuery query, String valueTypeClassName) {
		Object value = convertValue(query.getVal(), valueTypeClassName);
		if(value != null) {
			return getBson(query, value);
		}
		return null;
	}

	private Bson getBson(DataResourceQuery query, Object value) {
		QueryOperator operator = QueryOperator.findByOperator(query.getOp());
		if(operator != null) {
			switch(operator) {
			case GREATE_THEN:
				return Filters.gt(query.getProp(), value);
			case GREATER_THEN_OR_EQUAL:
				return Filters.gte(query.getProp(), value);
			case LESS_THEN:
				return Filters.lt(query.getProp(), value);
			case LESS_THEN_OR_EQUAL:
				return Filters.lte(query.getProp(), value);
			case EQUAL:
				return Filters.eq(query.getProp(), value);
			case NOT_EQUAL:
				return Filters.ne(query.getProp(), value);
			default:
				return null;
			}
		} else {
			throw new IllegalQueryOperandException("Data query operand \"" + query.getOp() + "\" is illegal.");
		}
	}	

}
