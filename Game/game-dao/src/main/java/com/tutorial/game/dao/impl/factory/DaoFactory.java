package com.tutorial.game.dao.impl.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.bean.dto.user.Client;
import com.tutorial.game.bean.dto.user.Employe;
import com.tutorial.game.bean.dto.user.Manager;
import com.tutorial.game.bean.dto.user.User;
import com.tutorial.game.dao.contract.IDao;
import com.tutorial.game.dao.contract.country.ICountryDAO;
import com.tutorial.game.dao.contract.factory.IDAOFactory;
import com.tutorial.game.dao.contract.game.IGameDAO;
import com.tutorial.game.dao.contract.user.IClientDao;
import com.tutorial.game.dao.contract.user.IEmployeDao;
import com.tutorial.game.dao.contract.user.IManagerDao;
import com.tutorial.game.dao.contract.user.IUserDao;
import com.tutorial.game.exception.DaoNotSetException;

@Component
public class DaoFactory implements IDAOFactory {
	
	@Autowired
	private IGameDAO gameDao;
	
	@Autowired
	private ICountryDAO countryDao;
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IManagerDao managerDao;
	
	@Autowired
	private IClientDao clientDao;

	@Autowired
	private IEmployeDao employeDao;
	
	@Override
	@SuppressWarnings("rawtypes")
	public IDao getDaoForModel(Class clazz) throws DaoNotSetException {
		
		if (clazz.equals(Game.class)) {
			return gameDao;
		}
		
		if (clazz.equals(Country.class)) {
			return countryDao;
		}
		
		if (clazz.equals(User.class)) {
			return userDao;
		}

		if (clazz.equals(Manager.class)) {
			return managerDao;
		}

		if (clazz.equals(Employe.class)) {
			return employeDao;
		}

		if (clazz.equals(Client.class)) {
			return clientDao;
		}

		throw new DaoNotSetException();
	}

	@Override
	public IGameDAO getGameDao() {
		return gameDao;
	}
	
	@Override
	public ICountryDAO getCountryDao() {
		return countryDao;
	}

	@Override
	public IUserDao getUserDao() {
		return userDao;
	}

	@Override
	public IManagerDao getManagerDao() {
		return managerDao;
	}

	@Override
	public IClientDao getClientDao() {
		return clientDao;
	}

	@Override
	public IEmployeDao getEmployeDao() {
		return employeDao;
	}
}
