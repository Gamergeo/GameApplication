package com.tutorial.struts.dao.game;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tutorial.struts.bean.dto.Developper;
import com.tutorial.struts.bean.dto.Game;
import com.tutorial.struts.dao.AbstractDAO;
import com.tutorial.struts.exception.GameException;

public class GameDAO extends AbstractDAO {
	
	/**
	 * @return the country if exists, null in other case
	 * @throws GameException
	 */
	public Game getGameByName(String name) throws GameException {
		Connection connection = null;
		Game game = null;
		
		try {
			connection = getConnection();
			
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(""
					+ "SELECT GAME.ID AS ID, GAME.NAME AS NAME, GAME.IDDEV AS ID_DEV " 
					+ "FROM GAME "
					+ "WHERE GAME.NAME = '" + name + "';");
			
			if (resultSet.next()) {
				game = new Game();
				
				game.setId(resultSet.getInt("ID"));
				game.setName(resultSet.getString("NAME"));
				
				Developper developper = new Developper();
				developper.setId(resultSet.getInt("ID_DEV"));
				
				game.setDevelopper(developper);
			}
			
		}  catch (Exception exception) {
			
			throw new GameException(exception, getClass().toString() + ".getConnection() Message : " + exception.getMessage());
			
		} finally {
			
			try {
				connection.close();
				
			} catch (SQLException exception) {
				throw new GameException(exception, getClass().toString() + ".getConnection() Message : " + exception.getMessage());
			}
		}
		
		return game;
	}
	
	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	public Integer addNewGame(Game game) throws GameException {
		
		if (game.getDevelopper() == null) {
			throw new GameException("Developper is not set !");
		}
		
		Connection connection = null;
		
		try {
			connection = getConnection();
			
			final Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO Game(name, idDev) VALUES ('" + game.getName() + "'," + game.getDevelopper().getId() + ");");

			final ResultSet resultSet = statement.executeQuery("SELECT ID FROM GAME WHERE name = '" + game.getName() + "';");
			resultSet.next();
			
			return resultSet.getInt("ID");

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
	 * Delete a game 
	 * @throws GameException 
	 */
	public void deleteGame(String gameId) throws GameException {
		
		Connection connection = null;
		
		try {
			connection = getConnection();
			
			final Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM GAME WHERE ID = " + gameId);

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
}
