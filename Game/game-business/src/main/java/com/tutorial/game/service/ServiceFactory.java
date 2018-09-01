package com.tutorial.game.service;

import com.tutorial.game.service.game.GameDevelopmentService;
import com.tutorial.game.service.game.GameService;
import com.tutorial.game.service.game.ReleasedGameService;

public final class ServiceFactory {
	
	private GameService gameService;
	
	private ReleasedGameService releasedGameService;
	
	private GameDevelopmentService gameDevelopmentService;

	public GameService getGameService() {
		return gameService;
	}

	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}

	public ReleasedGameService getReleasedGameService() {
		return releasedGameService;
	}

	public void setReleasedGameService(ReleasedGameService releasedGameService) {
		this.releasedGameService = releasedGameService;
	}

	public GameDevelopmentService getGameDevelopmentService() {
		return gameDevelopmentService;
	}

	public void setGameDevelopmentService(GameDevelopmentService gameDevelopmentService) {
		this.gameDevelopmentService = gameDevelopmentService;
	}
}
