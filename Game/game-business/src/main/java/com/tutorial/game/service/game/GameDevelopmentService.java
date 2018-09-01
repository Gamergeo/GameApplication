package com.tutorial.game.service.game;

import java.util.List;

import com.tutorial.game.bean.dto.game.IGame;
import com.tutorial.game.dao.game.GameDevelopperCountryDAO;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.AbstractService;

public class GameDevelopmentService extends AbstractService {
	
	private final GameDevelopperCountryDAO gameDevelopperCountryDAO  = new GameDevelopperCountryDAO();
	
	/**
	 * @return All the game in dev with developper and country (if exists)
	 */
	public List<IGame> getGamesInDeveloppmentWithDevelopperAndCountry() throws GameException {
		return getGamesInDeveloppmentWithDevelopperAndCountry(0);
	}
	
	/**
	 * @return All the game in dev with developper and country (if exists)
	 */
	public List<IGame> getGamesInDeveloppmentWithDevelopperAndCountry(int progressRate) throws GameException {
		return gameDevelopperCountryDAO.getGamesInDevelopementInfo(progressRate);
	}
}