package com.tutorial.game.dao.game;

import com.tutorial.game.bean.dto.game.IGame;
import com.tutorial.game.exception.GameException;

public interface IReleasedGameDAO {

	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	void addNewReleasedGame(IGame game) throws GameException;

}