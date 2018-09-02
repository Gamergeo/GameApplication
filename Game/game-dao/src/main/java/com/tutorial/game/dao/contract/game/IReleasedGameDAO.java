package com.tutorial.game.dao.contract.game;

import java.util.List;

import com.tutorial.game.bean.dto.game.ReleasedGame;
import com.tutorial.game.exception.GameException;

public interface IReleasedGameDAO {

	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	void insertReleasedGame(ReleasedGame releasedGame) throws GameException;

	/**
	 * Get all the game in development, with developper country 
	 * @param minProgressRate the progress rate minimal
	 * @throws GameException
	 */
	List<ReleasedGame> getAllReleasedGameWhitInfos() throws GameException;

}