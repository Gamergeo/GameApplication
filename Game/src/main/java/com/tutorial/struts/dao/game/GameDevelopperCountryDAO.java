package com.tutorial.struts.dao.game;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import com.tutorial.struts.bean.dto.IGame;
import com.tutorial.struts.bean.dto.impl.Country;
import com.tutorial.struts.bean.dto.impl.Developper;
import com.tutorial.struts.bean.dto.impl.Game;
import com.tutorial.struts.dao.AbstractDAO;
import com.tutorial.struts.exception.GameException;

public class GameDevelopperCountryDAO extends AbstractDAO {
	
	/**
	 * @return liste des jeux avec developpeur et pays associé
	 * @throws GameException 
	 */
	public Set<IGame> getGamesInfo() throws GameException {
		
		Connection connection = null;
	
		try {
			connection = getConnection();
			
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(""
					+ "SELECT GAME.ID AS ID, GAME.NAME AS GAME_NAME, DEVELOPPER.NAME AS DEV_NAME, COUNTRY.NAME AS COUNTRY_NAME " 
					+ "FROM GAME "
					+ "INNER JOIN DEVELOPPER ON GAME.idDev = DEVELOPPER.id "
					+ "LEFT OUTER JOIN COUNTRY ON DEVELOPPER.idCountry = COUNTRY.id ORDER BY GAME.ID; ");
			
			return fecthResults(resultSet);
			
		}  catch (Exception exception) {
			
			throw new GameException(exception, getClass().toString() + ".getConnection() Message : " + exception.getMessage());
			
		} finally {
			
			try {
				connection.close();
				
			} catch (SQLException exception) {
				throw new GameException(exception, getClass().toString() + ".getConnection() Message : " + exception.getMessage());
			}
		}
	}
	
	/**
	 * @return liste des jeux avec developpeur et pays associé
	 * @throws GameException 
	 */
	public Set<IGame> getGamesInDevelopementInfo(int progressRate) throws GameException {
		
		Connection connection = null;
	
		try {
			connection = getConnection();
			
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(""
					+ "SELECT GAME.ID AS ID, GAME.NAME AS GAME_NAME, DEVELOPPER.NAME AS DEV_NAME, COUNTRY.NAME AS COUNTRY_NAME " 
					+ "FROM GAME "
					+ "INNER JOIN GAME_DEVELOPMENT ON GAME_DEVELOPMENT.ID = GAME.ID AND GAME_DEVELOPMENT.PROGRESSRATE > " + progressRate + " "
					+ "INNER JOIN DEVELOPPER ON GAME.idDev = DEVELOPPER.id "
					+ "LEFT OUTER JOIN COUNTRY ON DEVELOPPER.idCountry = COUNTRY.id ORDER BY GAME.ID; ");
			
			return fecthResults(resultSet);
			
		}  catch (Exception exception) {
			
			throw new GameException(exception, getClass().toString() + ".getConnection() Message : " + exception.getMessage());
			
		} finally {
			
			try {
				connection.close();
				
			} catch (SQLException exception) {
				throw new GameException(exception, getClass().toString() + ".getConnection() Message : " + exception.getMessage());
			}
		}
	}
	
	/**
	 * @return liste des jeux avec developpeur et pays associé
	 * @throws GameException 
	 */
	public Set<IGame> getReleasedGamesInfo() throws GameException {
		
		Connection connection = null;
	
		try {
			connection = getConnection();
			
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(""
					+ "SELECT GAME.ID AS ID, GAME.NAME AS GAME_NAME, DEVELOPPER.NAME AS DEV_NAME, COUNTRY.NAME AS COUNTRY_NAME " 
					+ "FROM GAME "
					+ "INNER JOIN RELEASED_GAME ON RELEASED_GAME.ID = GAME.ID "
					+ "INNER JOIN DEVELOPPER ON GAME.idDev = DEVELOPPER.id "
					+ "LEFT OUTER JOIN COUNTRY ON DEVELOPPER.idCountry = COUNTRY.id ORDER BY GAME.ID; ");
			
			return fecthResults(resultSet);
			
		}  catch (Exception exception) {
			
			throw new GameException(exception, getClass().toString() + ".getConnection() Message : " + exception.getMessage());
			
		} finally {
			
			try {
				connection.close();
				
			} catch (SQLException exception) {
				throw new GameException(exception, getClass().toString() + ".getConnection() Message : " + exception.getMessage());
			}
		}
	}
	
	private Set<IGame> fecthResults(ResultSet resultSet) throws SQLException {
		Set<IGame> results = new HashSet<IGame>();
		
		while (resultSet.next()) {
			final Game game = new Game();
			
			final Integer gameId = resultSet.getInt("ID");
			final String  gameName = resultSet.getString("GAME_NAME");
			final String devName = resultSet.getString("DEV_NAME");
			final String countryName = resultSet.getString("COUNTRY_NAME");
			
			final Country country = new Country();
			country.setName(countryName);
			
			final Developper developper = new Developper();
			developper.setCountry(country);
			developper.setName(devName);
			
			game.setId(gameId);
			game.setName(gameName);
			game.setDevelopper(developper);
			
			results.add(game);
		}		
		
		return results;
	}
}
