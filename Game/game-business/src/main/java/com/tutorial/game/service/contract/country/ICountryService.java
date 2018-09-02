package com.tutorial.game.service.contract.country;

import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.exception.GameException;

public interface ICountryService {

	/**
	 *  Ajoute un nouveau pays dans la base
	 *  Renvoie une erreur si le pays n'est pas bien défini 
	 */
	void addNewCountry(Country country) throws GameException;

	/**
	 * Renvoie le country associé au nom donné
	 */
	Country getCountryByName(String name) throws GameException;
	
	public Country getCountryById(int id) throws GameException;

}