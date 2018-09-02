package com.tutorial.game.service.impl.game;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tutorial.game.bean.dto.game.DevelopmentGame;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.contract.game.IGameDevelopmentService;
import com.tutorial.game.service.impl.AbstractService;

@Service
public class GameDevelopmentService extends AbstractService implements IGameDevelopmentService {
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameDevelopmentService#getGamesInDeveloppmentWithDevelopperAndCountry()
	 */
	@Override
	public List<DevelopmentGame> getGamesInDeveloppmentWithDevelopperAndCountry() throws GameException {
		return serviceFactory.getGameDevelopmentService().getGamesInDeveloppmentWithDevelopperAndCountry(0);
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameDevelopmentService#getGamesInDeveloppmentWithDevelopperAndCountry(int)
	 */
	@Override
	public List<DevelopmentGame> getGamesInDeveloppmentWithDevelopperAndCountry(int progressRate) throws GameException {
		return daoFactory.getDevelopmentGameDAO().getAllDevelopmentGameWhitInfos(progressRate);
	}
}