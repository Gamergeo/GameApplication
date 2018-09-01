package com.tutorial.game.service;

import com.tutorial.game.service.game.IGameDevelopmentService;
import com.tutorial.game.service.game.IGameService;
import com.tutorial.game.service.game.IReleasedGameService;

public interface IServiceFactory {

	IGameService getGameService();

	void setGameService(IGameService gameService);

	IReleasedGameService getReleasedGameService();

	void setReleasedGameService(IReleasedGameService releasedGameService);

	IGameDevelopmentService getGameDevelopmentService();

	void setGameDevelopmentService(IGameDevelopmentService gameDevelopmentService);

}