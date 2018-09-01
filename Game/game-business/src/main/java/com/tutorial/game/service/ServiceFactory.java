package com.tutorial.game.service;

import com.tutorial.game.service.game.IGameDevelopmentService;
import com.tutorial.game.service.game.IGameService;
import com.tutorial.game.service.game.IReleasedGameService;

public final class ServiceFactory {
	
	private IGameService gameService;
	
	private IReleasedGameService releasedGameService;
	
	private IGameDevelopmentService gameDevelopmentService;

	public IGameService getGameService() {
		return gameService;
	}

	public void setGameService(IGameService gameService) {
		this.gameService = gameService;
	}

	public IReleasedGameService getReleasedGameService() {
		return releasedGameService;
	}

	public void setReleasedGameService(IReleasedGameService releasedGameService) {
		this.releasedGameService = releasedGameService;
	}

	public IGameDevelopmentService getGameDevelopmentService() {
		return gameDevelopmentService;
	}

	public void setGameDevelopmentService(IGameDevelopmentService gameDevelopmentService) {
		this.gameDevelopmentService = gameDevelopmentService;
	}
}
