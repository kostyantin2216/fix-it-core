/**
 * 
 */
package com.fixit.core.dao.queries;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;

import com.fixit.core.exceptions.IllegalQueryValueException;

/**
 * @author 		Kostyantin
 * @createdAt 	2017/05/20 13:43:41 GMT+3
 */
public abstract class BaseDataResourceQueryProcessor<RESULT> 
	implements DataResourceQueryProcessor<RESULT> {

	protected Object convertValue(String value, String valueTypeClassName) {
		Object typedValue = null;
		switch(valueTypeClassName) {
			case "java.lang.String":
				return value;
			case "java.lang.Boolean":
				if(value.equalsIgnoreCase("true") || value.equals("1"))
					return Boolean.TRUE;
				else if(value.equalsIgnoreCase("false") || value.equals("0")) 
					return Boolean.FALSE;
				else
					throw new IllegalQueryValueException("Data query value \"" + value + "\" must be of type java.lang.Boolean");
			case "java.lang.Integer":
				if(value.matches("^(-?)\\d+$"))
					return Integer.parseInt(value);
				else
					throw new IllegalQueryValueException("Data query value \"" + value + "\" must be of type java.lang.Integer");
			case "java.util.Date": case "java.sql.Timestamp":
				if(value.matches("\\d+")) 
					return new Timestamp(Long.parseLong(value));
				else
					try {
						return new Timestamp(DateFormat.getInstance().parse(value).getTime());
					} catch (ParseException e) {
						throw new IllegalQueryValueException("Data query value \"" + value + "\" cannot be parsed into a date", e);
					}
		}
		return typedValue;
	}
	
}
