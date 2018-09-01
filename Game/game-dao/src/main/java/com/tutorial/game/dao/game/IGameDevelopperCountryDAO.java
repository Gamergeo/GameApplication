package com.tutorial.game.dao.game;

import java.util.List;

import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.exception.GameException;

public interface IGameDevelopperCountryDAO {

	/**
	 * @return liste des jeux avec developpeur et pays associé
	 * @throws GameException 
	 */
	List<Game> getGamesInfo() throws GameException;

	/**
	 * @return liste des jeux avec developpeur et pays associé
	 * @throws GameException 
	 */
	List<Game> getGamesInDevelopementInfo(int progressRate) throws GameException;

	/**
	 * @return liste des jeux avec developpeur et pays associé
	 * @throws GameException 
	 */
	List<Game> getReleasedGamesInfo() throws GameException;

}