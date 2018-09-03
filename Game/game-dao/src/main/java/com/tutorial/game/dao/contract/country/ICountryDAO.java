package com.tutorial.game.dao.contract.country;

import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.dao.contract.IDao;
import com.tutorial.game.exception.GameException;

public interface ICountryDAO extends IDao<Country> {

	public Country findCountryByName(String name) throws GameException;

}