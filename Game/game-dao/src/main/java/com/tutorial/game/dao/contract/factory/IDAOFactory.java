package com.tutorial.game.dao.contract.factory;

import com.tutorial.game.dao.contract.country.ICountryDAO;
import com.tutorial.game.dao.contract.developper.IDevelopperDAO;
import com.tutorial.game.dao.contract.game.IGameDAO;
import com.tutorial.game.dao.contract.game.IGameDevelopperCountryDAO;
import com.tutorial.game.dao.contract.game.IReleasedGameDAO;

public interface IDAOFactory {

	IGameDAO getGameDAO();

	IGameDevelopperCountryDAO getGameDevelopperCountryDAO();

	IReleasedGameDAO getReleasedGameDAO();

	ICountryDAO getCountryDAO();

	IDevelopperDAO getDevelopperDAO();

}