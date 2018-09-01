package com.tutorial.game.dao.game;

import com.tutorial.game.bean.dto.game.IGame;
import com.tutorial.game.exception.GameException;

public interface IGameDAO {

	IGame getGameById(Integer id) throws GameException;

	/**
	 * @return the country if exists, null in other case
	 * @throws GameException
	 */
	IGame getGameByName(String name) throws GameException;

	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	IGame addNewGame(IGame game) throws GameException;

	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	IGame updateGame(IGame game) throws GameException;

	/**
	 * Delete a game 
	 * @throws GameException 
	 */
	void deleteGame(Integer gameId) throws GameException;

}