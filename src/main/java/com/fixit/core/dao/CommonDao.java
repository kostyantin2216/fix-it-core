package com.fixit.core.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.fixit.core.dao.queries.DataResourceQuery;
import com.fixit.core.data.DataModelObject;

public interface CommonDao<E extends DataModelObject<ID>, ID extends Serializable> {
	
	void save(E entity);
	void update(E entity);
	void delete(ID id);
	E findById(ID id);
	E findOneByProperty(String property, Object value);
	List<E> findByProperty(String property, Object value);
	List<E> findByMap(Map<String, Object> properties);
	List<E> findAll();
	List<E> processQueries(DataResourceQuery... queries);
	String getTableName();
	Class<E> getEntityClass();
	
}
