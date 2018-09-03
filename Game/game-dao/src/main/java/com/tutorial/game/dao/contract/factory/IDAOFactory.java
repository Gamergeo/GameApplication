package com.tutorial.game.dao.contract.factory;

import com.tutorial.game.dao.contract.IDao;
import com.tutorial.game.dao.contract.country.ICountryDAO;
import com.tutorial.game.dao.contract.game.IGameDAO;
import com.tutorial.game.dao.contract.user.IClientDao;
import com.tutorial.game.dao.contract.user.IEmployeDao;
import com.tutorial.game.dao.contract.user.IManagerDao;
import com.tutorial.game.dao.contract.user.IUserDao;
import com.tutorial.game.exception.DaoNotSetException;

public interface IDAOFactory {

	public IGameDAO getGameDao();

	public ICountryDAO getCountryDao();
	
	public IUserDao getUserDao();

	public IManagerDao getManagerDao();

	public IClientDao getClientDao();

	public IEmployeDao getEmployeDao();

	@SuppressWarnings("rawtypes")
	IDao getDaoForModel(Class clazz) throws DaoNotSetException;
}