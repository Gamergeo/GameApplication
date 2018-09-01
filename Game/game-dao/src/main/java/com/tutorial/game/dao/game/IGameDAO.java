package com.tutorial.game.dao.game;

import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.exception.GameException;

public interface IGameDAO {

	Game getGameById(Integer id) throws GameException;

	/**
	 * @return the country if exists, null in other case
	 * @throws GameException
	 */
	Game getGameByName(String name) throws GameException;

	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	Game addNewGame(Game game) throws GameException;

	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	Game updateGame(Game game) throws GameException;

	/**
	 * Delete a game 
	 * @throws GameException 
	 */
	void deleteGame(Integer gameId) throws GameException;

}