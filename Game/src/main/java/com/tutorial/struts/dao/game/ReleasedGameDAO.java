package com.tutorial.struts.dao.game;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.tutorial.struts.bean.dto.IGame;
import com.tutorial.struts.dao.AbstractDAO;
import com.tutorial.struts.exception.GameException;

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
