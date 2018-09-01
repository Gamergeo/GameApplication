package com.tutorial.game.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class GameExceptionListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Application Game Start...");
		
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( "com.mysql.cj.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		    /* Gérer les  éventuelles erreurs ici. */
		}
		System.out.println("Application Game Started !");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Application Game Closing...");
		
		System.out.println("Application Game Closed !");
	}

}
