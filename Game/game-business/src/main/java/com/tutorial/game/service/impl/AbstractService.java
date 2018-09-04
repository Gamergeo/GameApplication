package com.tutorial.game.service.impl;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

import com.tutorial.game.dao.contract.factory.IDAOFactory;
import com.tutorial.game.service.contract.factory.IServiceFactory;

public abstract class AbstractService {
	
	@Autowired
	protected IServiceFactory serviceFactory;
	
	@Autowired
	protected IDAOFactory daoFactory;
	
	@Autowired
    protected PlatformTransactionManager transactionManager;
	
	protected void load(Object proxy) {
		Hibernate.initialize(proxy);
	}
}