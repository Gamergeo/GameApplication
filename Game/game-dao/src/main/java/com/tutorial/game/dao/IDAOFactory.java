package com.tutorial.game.dao;

import com.tutorial.game.dao.country.ICountryDAO;
import com.tutorial.game.dao.developper.IDevelopperDAO;
import com.tutorial.game.dao.game.IGameDAO;
import com.tutorial.game.dao.game.IGameDevelopperCountryDAO;
import com.tutorial.game.dao.game.IReleasedGameDAO;

public interface IDAOFactory {

	IGameDAO getGameDAO();

	IGameDevelopperCountryDAO getGameDevelopperCountryDAO();

	IReleasedGameDAO getReleasedGameDAO();

	ICountryDAO getCountryDAO();

	IDevelopperDAO getDevelopperDAO();

}