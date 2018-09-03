package com.tutorial.game.dao.impl.country;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.constant.BaseTableName;
import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.dao.contract.country.ICountryDAO;
import com.tutorial.game.dao.impl.AbstractDAO;
import com.tutorial.game.exception.GameException;

@Repository
public class CountryDAO extends AbstractDAO<Country> implements ICountryDAO {
	
	@Override
	protected void setTypeParameterClass() {
		typeParameterClass = Country.class;
	}

	@Override
	public List<Country> findAll() {
		return findAll(BaseTableName.TABLE_NAME_COUNTRY);
	}
	
	@Override
	public Country findCountryByName(String name) throws GameException {
		return getCurrentSession().byNaturalId(Country.class).using("name", name).load();
	}
}
