package com.tutorial.game.service.game.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.game.IReleasedGameService;
import com.tutorial.game.service.impl.AbstractService;

@Service
public class ReleasedGameService extends AbstractService implements IReleasedGameService {
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IReleasedGameService#getReleasedtWithDevelopperAndCountry()
	 */
	@Override
	public List<Game> getReleasedtWithDevelopperAndCountry() throws GameException {
		
		return daoFactory.getGameDevelopperCountryDAO().getReleasedGamesInfo();
	}
}