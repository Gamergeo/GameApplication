package com.tutorial.game.service.impl.game;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.bean.dto.developper.Developper;
import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.bean.dto.user.User;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.contract.game.IGameService;
import com.tutorial.game.service.impl.AbstractService;

@Service
public class GameService extends AbstractService implements IGameService {
	
	final private static Logger LOG = Logger.getLogger(GameService.class.getName());
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#getDisplayedGames(com.tutorial.game.bean.dto.user.IUser)
	 */
	@Override
	public List<Game> getDisplayedGames(User user) throws GameException {
		
		List<Game> listGames = new ArrayList<Game>();
		
		if (user == null) {
			LOG.severe("User is not setted !");
			throw new GameException("User is not setted !");
			
		} else if (StringUtils.isEmpty(user.getName())) {
			LOG.severe("User has no name !");
			throw new GameException("User has no name !");
		}
		
		// Tous les utilisateurs peuvent voir les released game
		listGames.addAll(serviceFactory.getReleasedGameService().getReleasedtWithDevelopperAndCountry());
		
		// L'utilisateur est un developpeur : il doit voir les jeux en developpement à moitié terminé
		if (user.isDevUser()) {
			listGames.addAll(serviceFactory.getGameDevelopmentService().getGamesInDeveloppmentWithDevelopperAndCountry(50));
			
		} else if (user.isManagerUser()) { 
			listGames.addAll(serviceFactory.getGameDevelopmentService().getGamesInDeveloppmentWithDevelopperAndCountry());
		}
			
		return listGames;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#getGameWithDevelopperAndCountry(java.lang.int)
	 */
	@Override
	public Game getGameWithDevelopperAndCountry(int id) throws GameException {
		Game game = daoFactory.getGameDAO().getGameById(id);
		
		game.setDevelopper(daoFactory.getDevelopperDAO().getDevelopperById(game.getDevelopper().getId()));
		
		if (game.getDevelopper().getCountry() != null && game.getDevelopper().getCountry().getId() > 0)
			game.getDevelopper().setCountry(daoFactory.getCountryDAO().getCountryById(game.getDevelopper().getCountry().getId()));
		
		return game;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#createANewGame(com.tutorial.game.bean.dto.game.IGame)
	 */
	@Override
	public Game createANewGame(Game game) throws GameException {
		return serviceFactory.getGameService().createANewGame(game.getName(), game.getDevelopper().getName(), game.getDevelopper().getCountry().getName());
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#createANewGame(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Game createANewGame(String gameName, String devName, String countryName) throws GameException {
		
		Country country = null;
		Developper developper = null;
		Game game = null;
		
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
		developper = serviceFactory.getDevelopperService().getDevelopperByName(devName);
		
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
			country = serviceFactory.getCountryService().getCountryByName(countryName);
			
			// Sinon il faut le créer
			if (country == null) {
				country = new Country();
				country.setName(countryName);
				
				isCountryAlreadyRegistered = false;
			}
		}

		// Si le dev n'existe pas, il faut l'insérer en base
		if (!isCountryAlreadyRegistered) {
			serviceFactory.getCountryService().addNewCountry(country);
		}
		
		developper.setCountry(country);

		// Si le dev n'existe pas, il faut l'insérer en base
		if (!isDevAlreadyRegistered) {
			serviceFactory.getDevelopperService().addNewDevelopper(developper);
			
			throw new GameException("");
		}
		
		game.setDevelopper(developper);

		insertGame(game);
		
		return game;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#updateGame(java.lang.int, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Game updateGame(int gameId, String gameName, String devName, String countryName) throws GameException {
		Game game = new Game();
		
		game.setId(gameId);
		game.setName(gameName);
		
		daoFactory.getGameDAO().updateGame(game);
		
		return game;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#deleteGame(java.lang.int)
	 */
	@Override
	public void deleteGame(int gameId) throws GameException {
		daoFactory.getGameDAO().deleteGame(gameId);
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#getGameByName(java.lang.String)
	 */
	@Override
	public Game getGameByName(String name) throws GameException {
		return daoFactory.getGameDAO().getGameByName(name);
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#addNewGame(com.tutorial.game.bean.dto.game.IGame)
	 */
	@Override
	public void insertGame(Game game) throws GameException {
		daoFactory.getGameDAO().insertGame(game);
		
		// On informe l'identifiant
		game.setId(getGameByName(game.getName()).getId());
		
		// On oublie pas d'insérer un released game
		serviceFactory.getReleasedGameService().insertReleasedGame(game);
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.service.game.IGameService#updateGame(com.tutorial.game.bean.dto.game.IGame)
	 */
	@Override
	public void updateGame(Game game) throws GameException {
		daoFactory.getGameDAO().updateGame(game);
	}
}
 