package com.tutorial.game.dao.contract.game;

import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.exception.GameException;

public interface IGameDAO {

	Game getGameById(int id) throws GameException;

	/**
	 * @return the country if exists, null in other case
	 * @throws GameException
	 */
	Game getGameByName(String name) throws GameException;

	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	void insertGame(Game game) throws GameException;

	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	void updateGame(Game game) throws GameException;

	/**
	 * Delete a game 
	 * @throws GameException 
	 */
	void deleteGame(int gameId) throws GameException;

}