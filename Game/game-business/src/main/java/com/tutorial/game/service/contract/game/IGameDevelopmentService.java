package com.tutorial.game.service.contract.game;

import java.util.List;

import com.tutorial.game.bean.dto.game.DevelopmentGame;
import com.tutorial.game.exception.GameException;

public interface IGameDevelopmentService {

	/**
	 * @return All the game in dev with developper and country (if exists)
	 */
	List<DevelopmentGame> getGamesInDeveloppmentWithDevelopperAndCountry() throws GameException;

	/**
	 * @return All the game in dev with developper and country (if exists)
	 */
	List<DevelopmentGame> getGamesInDeveloppmentWithDevelopperAndCountry(int progressRate) throws GameException;

}