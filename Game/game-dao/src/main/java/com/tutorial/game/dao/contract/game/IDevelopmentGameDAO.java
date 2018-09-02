package com.tutorial.game.dao.contract.game;

import java.util.List;

import com.tutorial.game.bean.dto.game.DevelopmentGame;
import com.tutorial.game.exception.GameException;

public interface IDevelopmentGameDAO {

	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	void insertDevelopmentGame(DevelopmentGame developmentGame) throws GameException;

	/**
	 * Get all the game in development, with developper country 
	 * @param minProgressRate the progress rate minimal
	 * @throws GameException
	 */
	List<DevelopmentGame> getAllDevelopmentGameWhitInfos(int minProgressRate) throws GameException;

}