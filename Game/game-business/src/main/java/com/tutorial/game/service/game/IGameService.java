package com.tutorial.game.service.game;

import java.util.List;

import com.tutorial.game.bean.dto.country.ICountry;
import com.tutorial.game.bean.dto.developper.impl.Developper;
import com.tutorial.game.bean.dto.game.IGame;
import com.tutorial.game.bean.dto.user.IUser;
import com.tutorial.game.exception.GameException;

public interface IGameService {

	/**
	 * 
	 * @param user (needed for rights test)
	 * @return the list of released games or all the game, depending the user rights
	 */
	List<IGame> getDisplayedGames(IUser user) throws GameException;

	/**
	 * @return the game with dev & country for the id
	 */
	IGame getGameWithDevelopperAndCountry(Integer id) throws GameException;

	IGame createANewGame(IGame game) throws GameException;

	/**
	 * Create a new game, developper, country if needed
	 */
	IGame createANewGame(String gameName, String devName, String countryName) throws GameException;

	IGame updateGame(Integer gameId, String gameName, String devName, String countryName) throws GameException;

	void deleteGame(Integer gameId) throws GameException;

	IGame getGameByName(String name) throws GameException;

	Developper getDevelopperByName(String name) throws GameException;

	ICountry getCountryByName(String name) throws GameException;

	IGame addNewGame(IGame game) throws GameException;

	IGame updateGame(IGame game) throws GameException;

	Developper addNewDevelopper(Developper developper) throws GameException;

	ICountry addNewCountry(ICountry country) throws GameException;

}