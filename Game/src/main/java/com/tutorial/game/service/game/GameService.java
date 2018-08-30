package com.tutorial.game.service.game;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.tutorial.game.bean.dto.IGame;
import com.tutorial.game.bean.dto.impl.Country;
import com.tutorial.game.bean.dto.impl.Developper;
import com.tutorial.game.bean.dto.impl.Game;
import com.tutorial.game.dao.country.CountryDAO;
import com.tutorial.game.dao.developper.DevelopperDAO;
import com.tutorial.game.dao.game.GameDAO;
import com.tutorial.game.dao.game.GameDevelopperCountryDAO;
import com.tutorial.game.dao.game.ReleasedGameDAO;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.AbstractService;

public class GameService extends AbstractService {
	
	private final GameDevelopperCountryDAO gameDevelopperCountryDAO  = new GameDevelopperCountryDAO();
	
	private final GameDAO gameDAO  = new GameDAO();
	private final ReleasedGameDAO releasedGameDAO  = new ReleasedGameDAO();
	private final DevelopperDAO developperDAO  = new DevelopperDAO();
	private final CountryDAO countryDAO  = new CountryDAO();
	
	/**
	 * @return All the game with developper and country (if exists)
	 */
	public List<IGame> getGamesWithDevelopperAndCountry() throws GameException {
		
		return gameDevelopperCountryDAO.getGamesInfo();
	}
	
	/**
	 * @return the game with dev & country for the id
	 */
	public IGame getGameWithDevelopperAndCountry(Integer id) throws GameException {
		IGame game = gameDAO.getGameById(id);
		
		game.setDevelopper(developperDAO.getDevelopperById(game.getDevelopper().getId()));
		
		if (game.getDevelopper().getCountry() != null)
			game.getDevelopper().setCountry(countryDAO.getCountryById(game.getDevelopper().getCountry().getId()));
		
		return game;
	}
	
	/**
	 * Create a new game, developper, country if needed
	 */
	public IGame createANewGame(String gameName, String devName, String countryName) throws GameException {
		
		Country country = null;
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
	
	public IGame updateGame(Integer gameId, String gameName, String devName, String countryName) throws GameException {
		IGame game = new Game();
		
		game.setId(gameId);
		game.setName(gameName);
		
		gameDAO.updateGame(game);
		
		return game;
	}
	
	public void deleteGame(String gameId) throws GameException {
		gameDAO.deleteGame(gameId);
	}
	
	public IGame getGameByName(String name) throws GameException {
		return gameDAO.getGameByName(name);
	}
	
	public Developper getDevelopperByName(String name) throws GameException {
		return developperDAO.getDevelopperByName(name);
	}	
	
	public Country getCountryByName(String name) throws GameException {
		return countryDAO.getCountryByName(name);
	}
	
	public IGame addNewGame(IGame game) throws GameException {
		game = gameDAO.addNewGame(game);
		releasedGameDAO.addNewReleasedGame(game);
		return game;
	}
	
	public IGame updateGame(IGame game) throws GameException {
		return gameDAO.updateGame(game);
	}
	
	public Developper addNewDevelopper(Developper developper) throws GameException {
		return developperDAO.addNewDevelopper(developper);
	}
	
	public Country addNewCountry(Country country) throws GameException {
		return countryDAO.addNewCountry(country);
	}
}
 