package com.tutorial.game.service.game.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.tutorial.game.bean.dto.country.ICountry;
import com.tutorial.game.bean.dto.country.impl.Country;
import com.tutorial.game.bean.dto.developper.impl.Developper;
import com.tutorial.game.bean.dto.game.IGame;
import com.tutorial.game.bean.dto.game.impl.Game;
import com.tutorial.game.bean.dto.user.IUser;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.AbstractService;
import com.tutorial.game.service.game.IGameService;

public class GameService extends AbstractService implements IGameService {
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#getDisplayedGames(com.tutorial.game.bean.dto.user.IUser)
	 */
	@Override
	public List<IGame> getDisplayedGames(IUser user) throws GameException {
		
		List<IGame> listGames = new ArrayList<IGame>();
		
		if (user == null) {
			throw new GameException("User is not setted !");
			
		} else if (StringUtils.isEmpty(user.getName())) {
			throw new GameException("User has no name !");
		}
		
		// Tous les utilisateurs peuvent voir les released game
		listGames = serviceFactory.getReleasedGameService().getReleasedtWithDevelopperAndCountry();
		
		// L'utilisateur est un developpeur : il doit voir les jeux en developpement à moitié terminé
		if (user.isDevUser()) {
			listGames.addAll(serviceFactory.getGameDevelopmentService().getGamesInDeveloppmentWithDevelopperAndCountry(50));
			
		} else if (user.isManagerUser()) { 
			listGames.addAll(serviceFactory.getGameDevelopmentService().getGamesInDeveloppmentWithDevelopperAndCountry());
		}
			
		return listGames;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#getGameWithDevelopperAndCountry(java.lang.Integer)
	 */
	@Override
	public IGame getGameWithDevelopperAndCountry(Integer id) throws GameException {
		IGame game = daoFactory.getGameDAO().getGameById(id);
		
		game.setDevelopper(daoFactory.getDevelopperDAO().getDevelopperById(game.getDevelopper().getId()));
		
		if (game.getDevelopper().getCountry() != null)
			game.getDevelopper().setCountry(daoFactory.getCountryDAO().getCountryById(game.getDevelopper().getCountry().getId()));
		
		return game;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#createANewGame(com.tutorial.game.bean.dto.game.IGame)
	 */
	@Override
	public IGame createANewGame(IGame game) throws GameException {
		return createANewGame(game.getName(), game.getDevelopper().getName(), game.getDevelopper().getCountry().getName());
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#createANewGame(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public IGame createANewGame(String gameName, String devName, String countryName) throws GameException {
		
		ICountry country = null;
		Developper developper = null;
		IGame game = null;
		
		boolean isDevAlreadyRegistered = true;
		boolean isCountryAlreadyRegistered = true;
		
		if (StringUtils.isBlank(gameName) || StringUtils.isBlank(devName)) {
			throw new GameException("Bah alors, on mets pas tous les champs fdp ?!?");
		}
		
		// On verifie si le jeu existe déja, si c'est le cas, on lance une exception
		game = getGameByName(gameName);
		
		if (game != null) {
			throw new GameException("Bah, le jeu existe déja pov con");
		}
		
		game = new Game();
		game.setName(gameName);
		
		// On verifie si le developper existe deja, si c'est le cas, on utilise le dev existant
		developper = getDevelopperByName(devName);
		
		// Sinon on l'ajoute
		if (developper == null) {
			developper = new Developper();
			developper.setName(devName);

			isDevAlreadyRegistered = false;
		}
		
		// Si le pays est renseigné, il faut verifier s'il existe déja, sinon on l'ajoute
		if (!StringUtils.isBlank(countryName)) {
			
			// L'utilisateur a saisi un jeu avec un developper existant mais pas le bon pays
			if (developper.getCountry() != null && !developper.getCountry().getName().equals(countryName)) {
				throw new GameException("Bah alors mon con, on essaie de gruger la matrice ?");
			}
			
			// On verifie s'il existe déja, si c'est le cas, on utilise le pays existant
			country = getCountryByName(countryName);
			
			// Sinon il faut le créer
			if (country == null) {
				country = new Country();
				country.setName(countryName);
				
				isCountryAlreadyRegistered = false;
			}
		}

		// Si le dev n'existe pas, il faut l'insérer en base
		if (!isCountryAlreadyRegistered) {
			country = addNewCountry(country);
		}
		
		developper.setCountry(country);

		// Si le dev n'existe pas, il faut l'insérer en base
		if (!isDevAlreadyRegistered) {
			developper = addNewDevelopper(developper);
		}
		
		game.setDevelopper(developper);

		return addNewGame(game);
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#updateGame(java.lang.Integer, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public IGame updateGame(Integer gameId, String gameName, String devName, String countryName) throws GameException {
		IGame game = new Game();
		
		game.setId(gameId);
		game.setName(gameName);
		
		daoFactory.getGameDAO().updateGame(game);
		
		return game;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#deleteGame(java.lang.Integer)
	 */
	@Override
	public void deleteGame(Integer gameId) throws GameException {
		daoFactory.getGameDAO().deleteGame(gameId);
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#getGameByName(java.lang.String)
	 */
	@Override
	public IGame getGameByName(String name) throws GameException {
		return daoFactory.getGameDAO().getGameByName(name);
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#getDevelopperByName(java.lang.String)
	 */
	@Override
	public Developper getDevelopperByName(String name) throws GameException {
		return daoFactory.getDevelopperDAO().getDevelopperByName(name);
	}	
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#getCountryByName(java.lang.String)
	 */
	@Override
	public ICountry getCountryByName(String name) throws GameException {
		return daoFactory.getCountryDAO().getCountryByName(name);
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#addNewGame(com.tutorial.game.bean.dto.game.IGame)
	 */
	@Override
	public IGame addNewGame(IGame game) throws GameException {
		game = daoFactory.getGameDAO().addNewGame(game);
		daoFactory.getReleasedGameDAO().addNewReleasedGame(game);
		return game;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#updateGame(com.tutorial.game.bean.dto.game.IGame)
	 */
	@Override
	public IGame updateGame(IGame game) throws GameException {
		return daoFactory.getGameDAO().updateGame(game);
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#addNewDevelopper(com.tutorial.game.bean.dto.developper.impl.Developper)
	 */
	@Override
	public Developper addNewDevelopper(Developper developper) throws GameException {
		return daoFactory.getDevelopperDAO().addNewDevelopper(developper);
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#addNewCountry(com.tutorial.game.bean.dto.country.ICountry)
	 */
	@Override
	public ICountry addNewCountry(ICountry country) throws GameException {
		return daoFactory.getCountryDAO().addNewCountry(country);
	}
}
 