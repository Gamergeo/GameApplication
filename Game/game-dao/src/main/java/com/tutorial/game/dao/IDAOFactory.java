package com.tutorial.game.dao;

import com.tutorial.game.dao.country.ICountryDAO;
import com.tutorial.game.dao.developper.IDevelopperDAO;
import com.tutorial.game.dao.game.IGameDAO;
import com.tutorial.game.dao.game.IGameDevelopperCountryDAO;
import com.tutorial.game.dao.game.IReleasedGameDAO;

public interface IDAOFactory {

	IGameDAO getGameDAO();

	void setGameDAO(IGameDAO gameDAO);

	IGameDevelopperCountryDAO getGameDevelopperCountryDAO();

	void setGameDevelopperCountryDAO(IGameDevelopperCountryDAO gameDevelopperCountryDAO);

	IReleasedGameDAO getReleasedGameDAO();

	void setReleasedGameDAO(IReleasedGameDAO releasedGameDAO);

	ICountryDAO getCountryDAO();

	void setCountryDAO(ICountryDAO countryDAO);

	IDevelopperDAO getDevelopperDAO();

	void setDevelopperDAO(IDevelopperDAO developperDAO);

}