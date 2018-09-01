package com.tutorial.game.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.dao.IDAOFactory;
import com.tutorial.game.dao.country.impl.CountryDAO;
import com.tutorial.game.dao.developper.impl.DevelopperDAO;
import com.tutorial.game.dao.game.impl.GameDAO;
import com.tutorial.game.dao.game.impl.GameDevelopperCountryDAO;
import com.tutorial.game.dao.game.impl.ReleasedGameDAO;
import com.tutorial.game.dao.impl.DAOFactory;
import com.tutorial.game.service.IServiceFactory;
import com.tutorial.game.service.game.impl.GameDevelopmentService;
import com.tutorial.game.service.game.impl.GameService;
import com.tutorial.game.service.game.impl.ReleasedGameService;
import com.tutorial.game.service.impl.AbstractService;
import com.tutorial.game.service.impl.ServiceFactory;

@WebListener
public class DependencyInjectionListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Injection start...");
		
		IServiceFactory serviceFactory = new ServiceFactory();
		
		serviceFactory.setGameService(new GameService());
		serviceFactory.setGameDevelopmentService(new GameDevelopmentService());
		serviceFactory.setReleasedGameService(new ReleasedGameService());

		AbstractAction.setServiceFactory(serviceFactory);		
		AbstractService.setServiceFactory(serviceFactory);
		
		IDAOFactory daoFactory = new DAOFactory();
		
		daoFactory.setCountryDAO(new CountryDAO());
		daoFactory.setDevelopperDAO(new DevelopperDAO());
		daoFactory.setGameDAO(new GameDAO());
		daoFactory.setGameDevelopperCountryDAO(new GameDevelopperCountryDAO());
		daoFactory.setReleasedGameDAO(new ReleasedGameDAO());
		
		AbstractService.setDaoFactory(daoFactory);
		
		System.out.println("Injection started !");
	}
}
