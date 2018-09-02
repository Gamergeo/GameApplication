package com.tutorial.game.service.contract.game;

import java.util.List;

import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.bean.dto.user.User;
import com.tutorial.game.exception.GameException;

public interface IGameService {

	/**
	 * 
	 * @param user (needed for rights test)
	 * @return the list of released games or all the game, depending the user rights
	 */
	List<Game> getDisplayedGames(User user) throws GameException;

	/**
	 * @return the game with dev & country for the id
	 */
	Game getGameWithDevelopperAndCountry(Integer id) throws GameException;

	Game createANewGame(Game game) throws GameException;

	/**
	 * Create a new game, developper, country if needed
	 */
	Game createANewGame(String gameName, String devName, String countryName) throws GameException;

	Game updateGame(Integer gameId, String gameName, String devName, String countryName) throws GameException;

	void deleteGame(Integer gameId) throws GameException;

	Game getGameByName(String name) throws GameException;

	Game addNewGame(Game game) throws GameException;

	Game updateGame(Game game) throws GameException;

}