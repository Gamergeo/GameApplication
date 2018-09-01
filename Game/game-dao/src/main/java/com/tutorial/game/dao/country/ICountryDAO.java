package com.tutorial.game.dao.country;

import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.exception.GameException;

public interface ICountryDAO {

	/**
	 * @return the country if exists, null in other case
	 * @throws GameException
	 */
	Country getCountryById(Integer id) throws GameException;

	/**
	 * @return the country if exists, null in other case
	 * @throws GameException
	 */
	Country getCountryByName(String name) throws GameException;

	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	Country addNewCountry(Country country) throws GameException;

}