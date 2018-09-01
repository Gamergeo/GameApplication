package com.tutorial.game.service.game.impl;

import java.util.List;

import com.tutorial.game.bean.dto.game.IGame;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.AbstractService;
import com.tutorial.game.service.game.IReleasedGameService;

public class ReleasedGameService extends AbstractService implements IReleasedGameService {
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IReleasedGameService#getReleasedtWithDevelopperAndCountry()
	 */
	@Override
	public List<IGame> getReleasedtWithDevelopperAndCountry() throws GameException {
		
		return daoFactory.getGameDevelopperCountryDAO().getReleasedGamesInfo();
	}
}