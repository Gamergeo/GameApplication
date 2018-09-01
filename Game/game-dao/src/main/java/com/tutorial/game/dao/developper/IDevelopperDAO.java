package com.tutorial.game.dao.developper;

import com.tutorial.game.bean.dto.developper.Developper;
import com.tutorial.game.exception.GameException;

public interface IDevelopperDAO {

	/**
	 * @return the country if exists, null in other case
	 * @throws GameException
	 */
	Developper getDevelopperById(Integer id) throws GameException;

	/**
	 * @return the country if exists, null in other case
	 * @throws GameException
	 */
	Developper getDevelopperByName(String name) throws GameException;

	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	Developper addNewDevelopper(Developper developper) throws GameException;

}