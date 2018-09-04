package com.tutorial.game.service.contract.factory;

import com.tutorial.game.service.contract.country.ICountryService;
import com.tutorial.game.service.contract.game.IGameService;
import com.tutorial.game.service.contract.user.IUserService;

public interface IServiceFactory {

	IGameService getGameService();

	ICountryService getCountryService();

	IUserService getUserService();
	
}