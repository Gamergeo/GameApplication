package com.tutorial.game.service;

import com.tutorial.game.service.game.IGameDevelopmentService;
import com.tutorial.game.service.game.IGameService;
import com.tutorial.game.service.game.IReleasedGameService;

public interface IServiceFactory {

	IGameService getGameService();

	IReleasedGameService getReleasedGameService();

	IGameDevelopmentService getGameDevelopmentService();

}