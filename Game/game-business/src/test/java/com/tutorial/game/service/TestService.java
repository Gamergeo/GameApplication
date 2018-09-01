package com.tutorial.game.service;

import com.tutorial.game.dao.IDAOFactory;
import com.tutorial.game.dao.country.impl.CountryDAO;
import com.tutorial.game.dao.developper.impl.DevelopperDAO;
import com.tutorial.game.dao.game.impl.GameDAO;
import com.tutorial.game.dao.game.impl.GameDevelopperCountryDAO;
import com.tutorial.game.dao.game.impl.ReleasedGameDAO;
import com.tutorial.game.dao.impl.DaoFactory;
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

	}
	
	public TestService(String method) {
		super(method);
	}
	
}
