package com.tutorial.game.service;

import com.tutorial.game.dao.IDAOFactory;
import com.tutorial.game.dao.country.impl.CountryDAO;
import com.tutorial.game.dao.developper.impl.DevelopperDAO;
import com.tutorial.game.dao.game.impl.GameDAO;
import com.tutorial.game.dao.game.impl.GameDevelopperCountryDAO;
import com.tutorial.game.dao.game.impl.ReleasedGameDAO;
import com.tutorial.game.dao.impl.DAOFactory;
import com.tutorial.game.service.game.IGameService;
import com.tutorial.game.service.game.impl.GameDevelopmentService;
import com.tutorial.game.service.game.impl.GameService;
import com.tutorial.game.service.game.impl.ReleasedGameService;
import com.tutorial.game.service.impl.AbstractService;
import com.tutorial.game.service.impl.ServiceFactory;

import junit.framework.TestCase;

public abstract class TestService extends TestCase {

	protected IGameService gameService = new GameService();
	
	public TestService() {		
		super();
		IServiceFactory serviceFactory = new ServiceFactory();
		
		serviceFactory.setGameService(new GameService());
		serviceFactory.setGameDevelopmentService(new GameDevelopmentService());
		serviceFactory.setReleasedGameService(new ReleasedGameService());

		AbstractService.setServiceFactory(serviceFactory);
		
		IDAOFactory daoFactory = new DAOFactory();
		
		daoFactory.setCountryDAO(new CountryDAO());
		daoFactory.setDevelopperDAO(new DevelopperDAO());
		daoFactory.setGameDAO(new GameDAO());
		daoFactory.setGameDevelopperCountryDAO(new GameDevelopperCountryDAO());
		daoFactory.setReleasedGameDAO(new ReleasedGameDAO());
		
		AbstractService.setDaoFactory(daoFactory);

	}
	
	public TestService(String method) {
		super(method);
		IServiceFactory serviceFactory = new ServiceFactory();
		
		serviceFactory.setGameService(new GameService());
		serviceFactory.setGameDevelopmentService(new GameDevelopmentService());
		serviceFactory.setReleasedGameService(new ReleasedGameService());

		AbstractService.setServiceFactory(serviceFactory);
		
		IDAOFactory daoFactory = new DAOFactory();
		
		daoFactory.setCountryDAO(new CountryDAO());
		daoFactory.setDevelopperDAO(new DevelopperDAO());
		daoFactory.setGameDAO(new GameDAO());
		daoFactory.setGameDevelopperCountryDAO(new GameDevelopperCountryDAO());
		daoFactory.setReleasedGameDAO(new ReleasedGameDAO());
		
		AbstractService.setDaoFactory(daoFactory);
	}
	
}
