package com.tutorial.struts.service.game;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.tutorial.struts.bean.dto.Country;
import com.tutorial.struts.bean.dto.Developper;
import com.tutorial.struts.bean.dto.Game;
import com.tutorial.struts.dao.country.CountryDAO;
import com.tutorial.struts.dao.developper.DevelopperDAO;
import com.tutorial.struts.dao.game.GameDAO;
import com.tutorial.struts.dao.game.GameDevelopperCountryDAO;
import com.tutorial.struts.exception.GameException;
import com.tutorial.struts.service.AbstractService;

public class GameService extends AbstractService {
	
	private final GameDevelopperCountryDAO gameDevelopperCountryDAO  = new GameDevelopperCountryDAO();
	
	private final GameDAO gameDAO  = new GameDAO();
	private final DevelopperDAO developperDAO  = new DevelopperDAO();
	private final CountryDAO countryDAO  = new CountryDAO();
	
	/**
	 * @return All the game with developper and country (if exists)
	 */
	public List<Game> getGamesWithDevelopperAndCountry() throws GameException {
		
		return gameDevelopperCountryDAO.getResults();
	}
	
	/**
	 * @return the game with dev & country for the id
	 */
	public Game getGameWithDevelopperAndCountry(Integer id) throws GameException {
		Game game = gameDAO.getGameById(id);
		
		game.setDevelopper(developperDAO.getDevelopperById(game.getDevelopper().getId()));
		
		if (game.getDevelopper().getCountry() != null)
			game.getDevelopper().setCountry(countryDAO.getCountryById(game.getDevelopper().getCountry().getId()));
		
		return game;
	}
	
	/**
	 * Create a new game, developper, country if needed
	 */
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
	
	public Game updateGame(Integer gameId, String gameName, String devName, String countryName) throws GameException {
		Game game = new Game();
		
		game.setId(gameId);
		game.setName(gameName);
		
		gameDAO.updateGame(game);
		
		return game;
	}
	
	public void deleteGame(String gameId) throws GameException {
		gameDAO.deleteGame(gameId);
	}
	
	public Game getGameByName(String name) throws GameException {
		return gameDAO.getGameByName(name);
	}
	
	public Developper getDevelopperByName(String name) throws GameException {
		return developperDAO.getDevelopperByName(name);
	}	
	
	public Country getCountryByName(String name) throws GameException {
		return countryDAO.getCountryByName(name);
	}
	
	public Game addNewGame(Game game) throws GameException {
		return gameDAO.addNewGame(game);
	}
	
	public Game updateGame(Game game) throws GameException {
		return gameDAO.updateGame(game);
	}
	
	public Developper addNewDevelopper(Developper developper) throws GameException {
		return developperDAO.addNewDevelopper(developper);
	}
	
	public Country addNewCountry(Country country) throws GameException {
		return countryDAO.addNewCountry(country);
	}
}
 