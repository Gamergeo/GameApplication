package com.tutorial.game.dao.game;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.tutorial.game.bean.dto.IGame;
import com.tutorial.game.dao.AbstractDAO;
import com.tutorial.game.exception.GameException;

public class ReleasedGameDAO extends AbstractDAO {
	
	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	public void addNewReleasedGame(IGame game) throws GameException {
		
		if (game.getDevelopper() == null) {
			throw new GameException("Developper is not set !");
		}
		
		Connection connection = null;
		
		try {
			connection = getConnection();
			
			final Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO RELEASED_GAME VALUES (" + game.getId() + ", sysdate());");

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
