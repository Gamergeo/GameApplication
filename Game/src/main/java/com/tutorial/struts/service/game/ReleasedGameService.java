package com.tutorial.struts.service.game;

import java.util.List;

import com.tutorial.struts.bean.dto.IGame;
import com.tutorial.struts.dao.game.GameDevelopperCountryDAO;
import com.tutorial.struts.exception.GameException;
import com.tutorial.struts.service.AbstractService;

public class ReleasedGameService extends AbstractService {
	
	private final GameDevelopperCountryDAO gameDevelopperCountryDAO  = new GameDevelopperCountryDAO();
	
	/**
	 * @return All the game in dev with developper and country (if exists)
	 */
	public List<IGame> getReleasedtWithDevelopperAndCountry() throws GameException {
		
		return gameDevelopperCountryDAO.getReleasedGamesInfo();
	}
}