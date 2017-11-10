package com.fixit.core.dao.sql;

import java.util.List;

import com.fixit.core.data.sql.Profession;

public interface ProfessionDao extends UpdateDateSqlDao<Profession, Integer> {
	List<Profession> getActiveProfessions();
	Profession findByName(String profession);
}
