package com.tutorial.game.dao;

import com.tutorial.game.dao.country.ICountryDAO;
import com.tutorial.game.dao.developper.IDevelopperDAO;
import com.tutorial.game.dao.game.IGameDAO;
import com.tutorial.game.dao.game.IGameDevelopperCountryDAO;
import com.tutorial.game.dao.game.IReleasedGameDAO;

public class DAOFactory {
	
	private IGameDAO gameDAO;
	
	private IGameDevelopperCountryDAO gameDevelopperCountryDAO;
	
	private IReleasedGameDAO releasedGameDAO;
	
	private ICountryDAO countryDAO;
	
	private IDevelopperDAO developperDAO;

	public IGameDAO getGameDAO() {
		return gameDAO;
	}

	public void setGameDAO(IGameDAO gameDAO) {
		this.gameDAO = gameDAO;
	}

	public IGameDevelopperCountryDAO getGameDevelopperCountryDAO() {
		return gameDevelopperCountryDAO;
	}

	public void setGameDevelopperCountryDAO(IGameDevelopperCountryDAO gameDevelopperCountryDAO) {
		this.gameDevelopperCountryDAO = gameDevelopperCountryDAO;
	}

	public IReleasedGameDAO getReleasedGameDAO() {
		return releasedGameDAO;
	}

	public void setReleasedGameDAO(IReleasedGameDAO releasedGameDAO) {
		this.releasedGameDAO = releasedGameDAO;
	}

	public ICountryDAO getCountryDAO() {
		return countryDAO;
	}

	public void setCountryDAO(ICountryDAO countryDAO) {
		this.countryDAO = countryDAO;
	}

	public IDevelopperDAO getDevelopperDAO() {
		return developperDAO;
	}

	public void setDevelopperDAO(IDevelopperDAO developperDAO) {
		this.developperDAO = developperDAO;
	}
}
