package com.tutorial.game.service.impl;

import com.tutorial.game.dao.IDAOFactory;
import com.tutorial.game.service.IServiceFactory;

public abstract class AbstractService {
	
	protected static IServiceFactory serviceFactory;
	
	protected static IDAOFactory daoFactory;
	
	public static void setServiceFactory(IServiceFactory nServiceFactory) {
		serviceFactory = nServiceFactory;
	}

	public static void setDaoFactory(IDAOFactory nDaoFactory) {
		daoFactory = nDaoFactory;
	}
 
}