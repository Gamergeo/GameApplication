package com.tutorial.game.service;

import com.tutorial.game.dao.DAOFactory;

public abstract class AbstractService {
	
	protected static ServiceFactory serviceFactory;
	
	protected static DAOFactory daoFactory;
	
	public static void setServiceFactory(ServiceFactory nServiceFactory) {
		serviceFactory = nServiceFactory;
	}

	public static void setDaoFactory(DAOFactory nDaoFactory) {
		daoFactory = nDaoFactory;
	}
 
}