package com.tutorial.game.dao.contract.developper;

import com.tutorial.game.bean.dto.developper.Developper;
import com.tutorial.game.exception.GameException;

public interface IDevelopperDAO {

	/**
	 * @return the developper if exists, ERROR in other case
	 * @throws GameException
	 */
	Developper getDevelopperById(Integer id) throws GameException;

	/**
	 * @return the developper if exists, null in other case
	 * @throws GameException
	 */
	Developper getDevelopperByName(String name) throws GameException;

	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	void insertDevelopper(Developper developper) throws GameException;

}