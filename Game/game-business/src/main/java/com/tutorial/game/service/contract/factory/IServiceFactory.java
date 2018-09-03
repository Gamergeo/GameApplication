package com.tutorial.game.service.contract.factory;

import com.tutorial.game.service.contract.country.ICountryService;
import com.tutorial.game.service.contract.game.IGameService;

public interface IServiceFactory {

	IGameService getGameService();

	ICountryService getCountryService();
	
}