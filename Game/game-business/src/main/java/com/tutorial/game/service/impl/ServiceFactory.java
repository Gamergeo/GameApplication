package com.tutorial.game.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutorial.game.service.IServiceFactory;
import com.tutorial.game.service.game.IGameDevelopmentService;
import com.tutorial.game.service.game.IGameService;
import com.tutorial.game.service.game.IReleasedGameService;

@Component
public final class ServiceFactory implements IServiceFactory {
	
	@Autowired
	private IGameService gameService;
	
	@Autowired
	private IReleasedGameService releasedGameService;
	
	@Autowired
	private IGameDevelopmentService gameDevelopmentService;

	/* (non-Javadoc)
	 * @see com.tutorial.game.service.IServiceFactory#getGameService()
	 */
	@Override
	public IGameService getGameService() {
		return gameService;
	}

	/* (non-Javadoc)
	 * @see com.tutorial.game.service.IServiceFactory#setGameService(com.tutorial.game.service.game.IGameService)
	 */
	@Override
	public void setGameService(IGameService gameService) {
		this.gameService = gameService;
	}

	/* (non-Javadoc)
	 * @see com.tutorial.game.service.IServiceFactory#getReleasedGameService()
	 */
	@Override
	public IReleasedGameService getReleasedGameService() {
		return releasedGameService;
	}

	/* (non-Javadoc)
	 * @see com.tutorial.game.service.IServiceFactory#setReleasedGameService(com.tutorial.game.service.game.IReleasedGameService)
	 */
	@Override
	public void setReleasedGameService(IReleasedGameService releasedGameService) {
		this.releasedGameService = releasedGameService;
	}

	/* (non-Javadoc)
	 * @see com.tutorial.game.service.IServiceFactory#getGameDevelopmentService()
	 */
	@Override
	public IGameDevelopmentService getGameDevelopmentService() {
		return gameDevelopmentService;
	}

	/* (non-Javadoc)
	 * @see com.tutorial.game.service.IServiceFactory#setGameDevelopmentService(com.tutorial.game.service.game.IGameDevelopmentService)
	 */
	@Override
	public void setGameDevelopmentService(IGameDevelopmentService gameDevelopmentService) {
		this.gameDevelopmentService = gameDevelopmentService;
	}
}
