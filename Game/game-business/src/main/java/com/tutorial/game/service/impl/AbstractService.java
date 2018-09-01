package com.tutorial.game.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tutorial.game.dao.IDAOFactory;
import com.tutorial.game.service.IServiceFactory;

public abstract class AbstractService {
	
	@Autowired
	protected IServiceFactory serviceFactory;
	
	@Autowired
	protected IDAOFactory daoFactory;
 
}