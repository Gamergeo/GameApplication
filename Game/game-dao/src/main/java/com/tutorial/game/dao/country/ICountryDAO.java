package com.tutorial.game.dao.country;

import com.tutorial.game.bean.dto.country.ICountry;
import com.tutorial.game.exception.GameException;

public interface ICountryDAO {

	/**
	 * @return the country if exists, null in other case
	 * @throws GameException
	 */
	ICountry getCountryById(Integer id) throws GameException;

	/**
	 * @return the country if exists, null in other case
	 * @throws GameException
	 */
	ICountry getCountryByName(String name) throws GameException;

	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	ICountry addNewCountry(ICountry country) throws GameException;

}