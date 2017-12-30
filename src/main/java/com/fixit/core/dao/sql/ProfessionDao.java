package com.fixit.core.dao.sql;

import java.util.List;

import com.fixit.core.data.sql.Profession;

public interface ProfessionDao extends UpdateDateSqlDao<Profession, Integer> {
	
	public final static String TABLE_NAME = "Profession";
	
	public final static String PROP_ID = "id";
	public final static String PROP_NAME = "name";
	public final static String PROP_NAME_PLURAL = "namePlural";
	public final static String PROP_DESCRIPTION = "description";
	public final static String PROP_IMAGE_URL = "imageUrl";
	public final static String PROP_IS_ACTIVE = "isActive";
	public final static String PROP_UPDATED_AT = "updatedAt";
	
	List<Profession> getActiveProfessions();
	Profession findByName(String profession);
	String getNameForProfession(Integer professionId);
	
}
