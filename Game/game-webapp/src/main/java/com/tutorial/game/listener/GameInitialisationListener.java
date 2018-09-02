package com.tutorial.game.listener;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class GameInitialisationListener implements ServletContextListener {
	
	final private static Logger LOG = Logger.getLogger(GameInitialisationListener.class.getName());

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOG.info("Application Game Start...");

		LOG.info("Application Game Started !");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LOG.info("Application Game Closing...");

		LOG.info("Application Game Closed !");
	}

}
