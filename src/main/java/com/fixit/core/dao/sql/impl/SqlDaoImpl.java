package com.fixit.core.dao.sql.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.fixit.core.dao.sql.SqlDao;
import com.fixit.core.data.sql.SqlModelObject;

@Transactional
public abstract class SqlDaoImpl<E extends SqlModelObject<ID>, ID extends Serializable> 
		implements SqlDao<E, ID> {
	
	private final static String ALIAS = "_this";
	private final String entityClassName;
	
	public SqlDaoImpl() {
		entityClassName = getEntityClass().getSimpleName();
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void save(E entity) {
		entity.setId((ID) getSession().save(entity));
	}

	@Override
	public void update(E entity) {
		getSession().update(entity);
	}

	@Override
	public void delete(ID id) {
		Session session = getSession();
		session.delete(session.get(getEntityClass(), id));
	}

	@Override
	public E findById(ID id) {
		return getSession().find(getEntityClass(), id);
	}

	@Override
	public E findOneByProperty(String property, Object value) {
		Map<String, Object> props = new HashMap<>();
		props.put(property, value);
		List<E> l = findByMap(props);
		if(l != null && !l.isEmpty()) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public List<E> findByProperty(String property, Object value) {
		Map<String, Object> props = new HashMap<>();
		props.put(property, value);
		return findByMap(props);
	}

	@Override
	public List<E> findByMap(Map<String, Object> properties) {		
		String hqlQuery = createHqlQuery(properties);
		
		TypedQuery<E> query = getSession().createQuery(hqlQuery, getEntityClass());

		fillQuery(query, properties);

		return query.getResultList();
	}

	@Override
	public List<E> findAll() {
		return getSession()
				.createQuery("from " + entityClassName, getEntityClass())
				.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Integer getCount(Map<String, Object> properties) {
		String hqlQuery = "select count(1) ";
		if(properties != null && !properties.isEmpty()) {
			 hqlQuery += createHqlQuery(properties);
		} else {
			hqlQuery += entityClassName;
		}
		
		TypedQuery<Integer> query = getSession().createQuery(hqlQuery);

		fillQuery(query, properties);
		
		return query.getSingleResult();
	}
	
	private String createHqlQuery(Map<String, Object> properties) {
		String hqlQuery = "from " + entityClassName + " as " + ALIAS + " where ";

		Iterator<Map.Entry<String, Object>> iterator = properties.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Object> entry = iterator.next();
			hqlQuery += ALIAS + "." + entry.getKey() + " = :" + entry.getKey();
			if(iterator.hasNext()) {
				hqlQuery += " and ";
			}
		}
		
		return hqlQuery;
	}
	
	@SuppressWarnings("rawtypes")
	private void fillQuery(TypedQuery query, Map<String, Object> properties) {
		for(Map.Entry<String, Object> entry : properties.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
	}
	
}
