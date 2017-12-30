package com.fixit.core.dao.sql.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fixit.core.dao.sql.ProfessionDao;
import com.fixit.core.data.sql.Profession;

@Repository("professionDao")
public class ProfessionDaoImpl extends UpdateDateSqlDaoImpl<Profession, Integer> 
		implements ProfessionDao {

	@Override
	public List<Profession> getActiveProfessions() {
		return findByProperty(PROP_IS_ACTIVE, true);
	}	
	
	@Override
	public Profession findByName(String name) {
		return findOneByProperty(PROP_NAME, name);
	}
	
	@Override
	public String getNameForProfession(Integer professionId) {
		Profession profession = findById(professionId);
		if(profession != null) {
			return profession.getName();
		}
		return "";
	}
	
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
