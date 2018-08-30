package com.tutorial.struts.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class GameAppListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Application Game Start...");
		
		/* Chargement du driver JDBC pour MySQL */
		try {
		    Class.forName( "com.mysql.cj.jdbc.Driver" );
		} catch ( ClassNotFoundException e ) {
		    /* G�rer les �ventuelles erreurs ici. */
		}
		System.out.println("Application Game Started !");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Application Game Closing...");
		
		System.out.println("Application Game Closed !");
	}

}
