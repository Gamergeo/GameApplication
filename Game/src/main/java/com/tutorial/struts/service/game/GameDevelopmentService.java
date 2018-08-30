package com.tutorial.struts.service.game;

import java.util.Set;

import com.tutorial.struts.bean.dto.IGame;
import com.tutorial.struts.dao.game.GameDevelopperCountryDAO;
import com.tutorial.struts.exception.GameException;
import com.tutorial.struts.service.AbstractService;

public class GameDevelopmentService extends AbstractService {
	
	private final GameDevelopperCountryDAO gameDevelopperCountryDAO  = new GameDevelopperCountryDAO();
	
	/**
	 * @return All the game in dev with developper and country (if exists)
	 */
	public Set<IGame> getGamesInDeveloppmentWithDevelopperAndCountry() throws GameException {
		
		return getGamesInDeveloppmentWithDevelopperAndCountry(0);
	}
	
	/**
	 * @return All the game in dev with developper and country (if exists)
	 */
	public Set<IGame> getGamesInDeveloppmentWithDevelopperAndCountry(int progressRate) throws GameException {
		return gameDevelopperCountryDAO.getGamesInDevelopementInfo(progressRate);
	}
}