package com.tutorial.game.dao.game.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.dto.developper.Developper;
import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.dao.game.IGameDAO;
import com.tutorial.game.dao.impl.AbstractDAO;
import com.tutorial.game.exception.GameException;

@Repository
public class GameDAO extends AbstractDAO implements IGameDAO {
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IGameDAO#getGameById(java.lang.Integer)
	 */
	@Override
	public Game getGameById(Integer id) throws GameException {
		Connection connection = null;
		Game game = null;
		
		try {
			connection = getConnection();
			
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(""
					+ "SELECT GAME.ID AS ID, GAME.NAME AS NAME, GAME.IDDEV AS ID_DEV " 
					+ "FROM GAME "
					+ "WHERE GAME.ID = '" + id.toString() + "';");
			
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
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IGameDAO#getGameByName(java.lang.String)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IGameDAO#addNewGame(com.tutorial.game.bean.dto.game.IGame)
	 */
	@Override
	public Game addNewGame(Game game) throws GameException {
		
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
			
			game.setId(resultSet.getInt("ID"));
			
			return game;

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
	 * @see com.tutorial.game.dao.game.IGameDAO#updateGame(com.tutorial.game.bean.dto.game.IGame)
	 */
	@Override
	public Game updateGame(Game game) throws GameException {
		
		Connection connection = null;
		
		try {
			connection = getConnection();
			
			String query = "SELECT id, name FROM GAME WHERE id = ?";
			
			final PreparedStatement prepareStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			prepareStatement.setString(1, game.getId().toString());
			final ResultSet resultSet = prepareStatement.executeQuery();
			
			resultSet.first();
			resultSet.updateString("name", game.getName());
			
			resultSet.updateRow();
			
			return game;

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
	 * @see com.tutorial.game.dao.game.IGameDAO#deleteGame(java.lang.Integer)
	 */
	@Override
	public void deleteGame(Integer gameId) throws GameException {
		
		Connection connection = null;
		
		try {
			connection = getConnection();
			
			final Statement statement = connection.createStatement();
			statement.executeUpdate("DELETE FROM RELEASED_GAME WHERE ID = " + gameId + ";");
			statement.executeUpdate("DELETE FROM GAME_DEVELOPMENT WHERE ID = " + gameId + ";");
			statement.executeUpdate("DELETE FROM GAME WHERE ID = " + gameId + ";");

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
