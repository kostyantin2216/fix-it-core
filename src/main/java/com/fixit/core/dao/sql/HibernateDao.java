package com.fixit.core.dao.sql;

import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.Type;

public interface HibernateDao {
	Session getSession();
	Type getPropertyType(String className, String name) throws ClassNotFoundException;
	Type getPropertyType(Class<?> clazz, String name);
	Type getPropertyType(ClassMetadata metaData, String name);
	ClassMetadata getClassMetadata(Class<?> clazz);
	ClassMetadata getClassMetadata(String className);
}
