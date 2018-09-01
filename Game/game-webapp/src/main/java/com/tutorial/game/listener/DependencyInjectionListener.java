package com.tutorial.game.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.service.ServiceFactory;
import com.tutorial.game.service.game.GameDevelopmentService;
import com.tutorial.game.service.game.GameService;
import com.tutorial.game.service.game.ReleasedGameService;

@WebListener
public class DependencyInjectionListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Injection start...");
		
		ServiceFactory serviceFactory = new ServiceFactory();
		
		serviceFactory.setGameService(new GameService());
		serviceFactory.setGameDevelopmentService(new GameDevelopmentService());
		serviceFactory.setReleasedGameService(new ReleasedGameService());

		AbstractAction.setServiceFactory(serviceFactory);		
		
		System.out.println("Injection started !");
	}
}
