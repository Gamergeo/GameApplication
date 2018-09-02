package com.tutorial.game.service.contract.factory;

import com.tutorial.game.service.contract.country.ICountryService;
import com.tutorial.game.service.contract.developper.IDevelopperService;
import com.tutorial.game.service.contract.game.IGameDevelopmentService;
import com.tutorial.game.service.contract.game.IGameService;
import com.tutorial.game.service.contract.game.IReleasedGameService;

public interface IServiceFactory {

	IGameService getGameService();

	IReleasedGameService getReleasedGameService();

	IGameDevelopmentService getGameDevelopmentService();
	
	ICountryService getCountryService();
	
	IDevelopperService getDevelopperService();

}