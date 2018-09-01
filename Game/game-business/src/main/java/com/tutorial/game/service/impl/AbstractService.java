package com.tutorial.game.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tutorial.game.dao.IDAOFactory;
import com.tutorial.game.service.IServiceFactory;

public abstract class AbstractService {
	
	@Autowired
	protected static IServiceFactory serviceFactory;
	
	@Autowired
	protected static IDAOFactory daoFactory;
	
	public static void setServiceFactory(IServiceFactory nServiceFactory) {
		serviceFactory = nServiceFactory;
	}

	public static void setDaoFactory(IDAOFactory nDaoFactory) {
		daoFactory = nDaoFactory;
	}
 
}