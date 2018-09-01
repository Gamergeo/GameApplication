package com.tutorial.game.dao.game.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.bean.dto.developper.Developper;
import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.dao.game.IGameDevelopperCountryDAO;
import com.tutorial.game.dao.impl.AbstractDAO;
import com.tutorial.game.exception.GameException;

@Repository
public class GameDevelopperCountryDAO extends AbstractDAO implements IGameDevelopperCountryDAO {
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IGameDevelopperCountryDAO#getGamesInfo()
	 */
	@Override
	public List<Game> getGamesInfo() throws GameException {
		
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
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IGameDevelopperCountryDAO#getGamesInDevelopementInfo(int)
	 */
	@Override
	public List<Game> getGamesInDevelopementInfo(int progressRate) throws GameException {
		
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
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IGameDevelopperCountryDAO#getReleasedGamesInfo()
	 */
	@Override
	public List<Game> getReleasedGamesInfo() throws GameException {
		
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
	
	private List<Game> fecthResults(ResultSet resultSet) throws SQLException {
		List<Game> results = new ArrayList<Game>();
		
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
