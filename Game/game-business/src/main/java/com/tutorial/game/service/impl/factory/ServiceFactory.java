package com.tutorial.game.service.impl.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutorial.game.service.contract.developper.IDevelopperService;
import com.tutorial.game.service.contract.factory.IServiceFactory;
import com.tutorial.game.service.contract.game.IGameDevelopmentService;
import com.tutorial.game.service.contract.game.IGameService;
import com.tutorial.game.service.contract.game.IReleasedGameService;
import com.tutorial.game.service.impl.country.ICountryService;

@Component
public final class ServiceFactory implements IServiceFactory {
	
	@Autowired
	private IGameService gameService;
	
	@Autowired
	private IReleasedGameService releasedGameService;
	
	@Autowired
	private IGameDevelopmentService gameDevelopmentService;
	
	@Autowired
	private ICountryService countryService;
	
	@Autowired
	private IDevelopperService developperService;

	/* (non-Javadoc)
	 * @see com.tutorial.game.service.IServiceFactory#getGameService()
	 */
	@Override
	public IGameService getGameService() {
		return gameService;
	}

	/* (non-Javadoc)
	 * @see com.tutorial.game.service.IServiceFactory#getReleasedGameService()
	 */
	@Override
	public IReleasedGameService getReleasedGameService() {
		return releasedGameService;
	}

	/* (non-Javadoc)
	 * @see com.tutorial.game.service.IServiceFactory#getGameDevelopmentService()
	 */
	@Override
	public IGameDevelopmentService getGameDevelopmentService() {
		return gameDevelopmentService;
	}

	/* (non-Javadoc)
	 * @see com.tutorial.game.service.IServiceFactory#getCountryService()
	 */
	@Override
	public ICountryService getCountryService() {
		return countryService;
	}

	/* (non-Javadoc)
	 * @see com.tutorial.game.service.IServiceFactory#getDevelopperService()
	 */
	@Override
	public IDevelopperService getDevelopperService() {
		return developperService;
	}
}
