package com.fixit.core.dao.sql.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.Type;
import org.springframework.transaction.annotation.Transactional;

import com.fixit.core.dao.queries.DataResourceQuery;
import com.fixit.core.dao.queries.SqlDataResourceQueryProcessor;
import com.fixit.core.dao.sql.SqlDao;
import com.fixit.core.data.sql.SqlModelObject;
import com.fixit.core.exceptions.IllegalQueryPropertyException;

@Transactional
public abstract class SqlDaoImpl<E extends SqlModelObject<ID>, ID extends Serializable> 
		extends HibernateDaoImpl implements SqlDao<E, ID>  {
	
	private final static String ALIAS = "_this";
	private final String entityClassName;
	private final SqlDataResourceQueryProcessor queryProcessor;
	
	public SqlDaoImpl() {
		entityClassName = getEntityClass().getSimpleName();
		queryProcessor = new SqlDataResourceQueryProcessor();
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
	public boolean contains(E entity) {
		return getSession().createCriteria(getEntityClass())
	            .add(Restrictions.idEq(entity.getId()))
	            .setProjection(Projections.id())
	            .uniqueResult() != null;
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
	public List<E> processQueries(DataResourceQuery... queries) {		
		Criteria crit = getSession().createCriteria(getEntityClass());
		for(DataResourceQuery query : queries) {
			ClassMetadata meta = getClassMetadata(getEntityClass());
			if(meta != null) {
				Type type = getPropertyType(meta, query.getProp());
				if(type != null) {
					Criterion criterion = queryProcessor.process(query, type.getReturnedClass().getName());
					if(criterion != null) {
						crit.add(criterion);		
					}
				} else {
					throw new IllegalQueryPropertyException("Data query property \"" + query.getProp() + "\" does not exist");
				}
			}
		}
		return crit.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Long getCount(Map<String, Object> properties) {
		String hqlQuery = "select count(1) ";
		if(properties != null && !properties.isEmpty()) {
			 hqlQuery += createHqlQuery(properties);
		} else {
			hqlQuery += entityClassName;
		}
		
		TypedQuery<Long> query = getSession().createQuery(hqlQuery);

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
