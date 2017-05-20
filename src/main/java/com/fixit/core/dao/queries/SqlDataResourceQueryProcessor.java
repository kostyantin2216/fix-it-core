/**
 * 
 */
package com.fixit.core.dao.queries;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.fixit.core.exceptions.IllegalQueryOperandException;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/05/17 20:44:44 GMT+3
 */
public class SqlDataResourceQueryProcessor extends BaseDataResourceQueryProcessor<Criterion> {
	
	@Override
	public Criterion process(DataResourceQuery query, String valueTypeClassName) {
		Object value = convertValue(query.getVal(), valueTypeClassName);
		if(value != null) {
			return getCriterion(query, value);
		}
		return null;
	}
	
	public Criterion getCriterion(DataResourceQuery query, Object value) throws IllegalQueryOperandException {		
		QueryOperator operator = QueryOperator.findByOperator(query.getOp());
		if(operator != null) {
			switch(operator) {
				case GREATE_THEN:
					return Restrictions.gt(query.getProp(), value);
				case GREATER_THEN_OR_EQUAL:
					return Restrictions.ge(query.getProp(), value);
				case LESS_THEN:
					return Restrictions.lt(query.getProp(), value);
				case LESS_THEN_OR_EQUAL:
					return Restrictions.le(query.getProp(), value);
				case EQUAL:
					return Restrictions.eq(query.getProp(), value);
				case NOT_EQUAL:
					return Restrictions.ne(query.getProp(), value);
				default:
					return null;
			}
		} else {
			throw new IllegalQueryOperandException("Data query operand \"" + query.getOp() + "\" is illegal.");
		}
	}

}
