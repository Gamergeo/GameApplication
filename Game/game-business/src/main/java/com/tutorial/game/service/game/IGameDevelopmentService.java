package com.tutorial.game.service.game;

import java.util.List;

import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.exception.GameException;

public interface IGameDevelopmentService {

	/**
	 * @return All the game in dev with developper and country (if exists)
	 */
	List<Game> getGamesInDeveloppmentWithDevelopperAndCountry() throws GameException;

	/**
	 * @return All the game in dev with developper and country (if exists)
	 */
	List<Game> getGamesInDeveloppmentWithDevelopperAndCountry(int progressRate) throws GameException;

}