package com.tutorial.game.service.game;

import java.util.List;

import com.tutorial.game.bean.dto.game.IGame;
import com.tutorial.game.dao.game.GameDevelopperCountryDAO;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.AbstractService;

public class ReleasedGameService extends AbstractService {
	
	private final GameDevelopperCountryDAO gameDevelopperCountryDAO  = new GameDevelopperCountryDAO();
	
	/**
	 * @return All the game in dev with developper and country (if exists)
	 */
	public List<IGame> getReleasedtWithDevelopperAndCountry() throws GameException {
		
		return gameDevelopperCountryDAO.getReleasedGamesInfo();
	}
}