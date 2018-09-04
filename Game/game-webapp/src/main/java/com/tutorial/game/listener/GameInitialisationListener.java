package com.tutorial.game.listener;

import java.util.logging.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;

@WebListener
public class GameInitialisationListener implements ServletContextListener {
	
	final private static Logger LOG = Logger.getLogger(GameInitialisationListener.class.getName());

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		LOG.info("Application Game Start...");

		((LoggerContext) LogManager.getContext(false)).reconfigure();

		LOG.info("Application Game Started !");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		LOG.info("Application Game Closing...");

		LOG.info("Application Game Closed !");
	}

}
