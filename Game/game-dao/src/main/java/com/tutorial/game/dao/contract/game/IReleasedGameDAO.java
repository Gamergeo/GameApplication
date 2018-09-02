package com.tutorial.game.dao.contract.game;

import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.exception.GameException;

public interface IReleasedGameDAO {

	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	void addNewReleasedGame(Game game) throws GameException;

}