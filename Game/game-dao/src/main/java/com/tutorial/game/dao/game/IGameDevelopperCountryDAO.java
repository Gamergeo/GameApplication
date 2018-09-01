package com.tutorial.game.dao.game;

import java.util.List;

import com.tutorial.game.bean.dto.game.IGame;
import com.tutorial.game.exception.GameException;

public interface IGameDevelopperCountryDAO {

	/**
	 * @return liste des jeux avec developpeur et pays associé
	 * @throws GameException 
	 */
	List<IGame> getGamesInfo() throws GameException;

	/**
	 * @return liste des jeux avec developpeur et pays associé
	 * @throws GameException 
	 */
	List<IGame> getGamesInDevelopementInfo(int progressRate) throws GameException;

	/**
	 * @return liste des jeux avec developpeur et pays associé
	 * @throws GameException 
	 */
	List<IGame> getReleasedGamesInfo() throws GameException;

}