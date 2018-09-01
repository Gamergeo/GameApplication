package com.tutorial.game.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutorial.game.dao.IDAOFactory;
import com.tutorial.game.dao.country.ICountryDAO;
import com.tutorial.game.dao.developper.IDevelopperDAO;
import com.tutorial.game.dao.game.IGameDAO;
import com.tutorial.game.dao.game.IGameDevelopperCountryDAO;
import com.tutorial.game.dao.game.IReleasedGameDAO;

@Component
public class DaoFactory implements IDAOFactory {
	
	@Autowired
	private IGameDAO gameDAO;
	
	@Autowired
	private IGameDevelopperCountryDAO gameDevelopperCountryDAO;
	
	@Autowired
	private IReleasedGameDAO releasedGameDAO;
	
	@Autowired
	private ICountryDAO countryDAO;
	
	@Autowired
	private IDevelopperDAO developperDAO;

	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.IDAOFactory#getGameDAO()
	 */
	@Override
	public IGameDAO getGameDAO() {
		return gameDAO;
	}

	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.IDAOFactory#getGameDevelopperCountryDAO()
	 */
	@Override
	public IGameDevelopperCountryDAO getGameDevelopperCountryDAO() {
		return gameDevelopperCountryDAO;
	}

	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.IDAOFactory#getReleasedGameDAO()
	 */
	@Override
	public IReleasedGameDAO getReleasedGameDAO() {
		return releasedGameDAO;
	}

	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.IDAOFactory#getCountryDAO()
	 */
	@Override
	public ICountryDAO getCountryDAO() {
		return countryDAO;
	}

	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.IDAOFactory#getDevelopperDAO()
	 */
	@Override
	public IDevelopperDAO getDevelopperDAO() {
		return developperDAO;
	}
}
