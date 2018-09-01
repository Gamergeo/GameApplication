package com.tutorial.game.service.game.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.game.IGameDevelopmentService;
import com.tutorial.game.service.impl.AbstractService;

@Service
public class GameDevelopmentService extends AbstractService implements IGameDevelopmentService {
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameDevelopmentService#getGamesInDeveloppmentWithDevelopperAndCountry()
	 */
	@Override
	public List<Game> getGamesInDeveloppmentWithDevelopperAndCountry() throws GameException {
		return getGamesInDeveloppmentWithDevelopperAndCountry(0);
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameDevelopmentService#getGamesInDeveloppmentWithDevelopperAndCountry(int)
	 */
	@Override
	public List<Game> getGamesInDeveloppmentWithDevelopperAndCountry(int progressRate) throws GameException {
		return daoFactory.getGameDevelopperCountryDAO().getGamesInDevelopementInfo(progressRate);
	}
}