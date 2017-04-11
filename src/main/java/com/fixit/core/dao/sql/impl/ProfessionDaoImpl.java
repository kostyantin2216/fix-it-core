package com.fixit.core.dao.sql.impl;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.sql.ProfessionDao;
import com.fixit.core.data.sql.Profession;

@Repository("professionDao")
public class ProfessionDaoImpl extends UpdateDateSqlDaoImpl<Profession, Integer> 
		implements ProfessionDao {
	
	public final static String TABLE_NAME = "Profession";
	
	public final static String PROP_ID = "id";
	public final static String PROP_NAME = "name";
	public final static String PROP_DESCRIPTION = "description";
	public final static String PROP_IMAGE_URL = "imageUrl";
	public final static String PROP_IS_ACTIVE = "isActive";
	public final static String PROP_UPDATED_AT = "updatedAt";

	@Override
	public String getTableName() {
		return TABLE_NAME;
	}
	
	@Override
	public String getUpdatePropertyName() {
		return PROP_UPDATED_AT;
	}

	@Override
	public Class<Profession> getEntityClass() {
		return Profession.class;
	}

}
