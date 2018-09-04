package com.tutorial.game.service.impl.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutorial.game.service.contract.country.ICountryService;
import com.tutorial.game.service.contract.factory.IServiceFactory;
import com.tutorial.game.service.contract.game.IGameService;
import com.tutorial.game.service.contract.user.IUserService;

@Component
public final class ServiceFactory implements IServiceFactory {
	
	@Autowired
	private IGameService gameService;
	
	@Autowired
	private ICountryService countryService;
	
	@Autowired
	private IUserService userService;
	
	@Override
	public IGameService getGameService() {
		return gameService;
	}

	@Override
	public ICountryService getCountryService() {
		return countryService;
	}

	@Override
	public IUserService getUserService() {
		return userService;
	}
}
