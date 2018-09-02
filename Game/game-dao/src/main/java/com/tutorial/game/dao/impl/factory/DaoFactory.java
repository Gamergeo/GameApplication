package com.tutorial.game.dao.impl.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tutorial.game.dao.contract.country.ICountryDAO;
import com.tutorial.game.dao.contract.developper.IDevelopperDAO;
import com.tutorial.game.dao.contract.factory.IDAOFactory;
import com.tutorial.game.dao.contract.game.IDevelopmentGameDAO;
import com.tutorial.game.dao.contract.game.IGameDAO;
import com.tutorial.game.dao.contract.game.IReleasedGameDAO;

@Component
public class DaoFactory implements IDAOFactory {
	
	@Autowired
	private IGameDAO gameDAO;
	
	@Autowired
	private IDevelopmentGameDAO developmentGameDAO;
	
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
	public IDevelopmentGameDAO getDevelopmentGameDAO() {
		return developmentGameDAO;
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
