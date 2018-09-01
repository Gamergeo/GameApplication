package com.tutorial.game.dao.game.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.dto.game.IGame;
import com.tutorial.game.dao.game.IReleasedGameDAO;
import com.tutorial.game.dao.impl.AbstractDAO;
import com.tutorial.game.exception.GameException;

@Repository
public class ReleasedGameDAO extends AbstractDAO implements IReleasedGameDAO {
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IReleasedGameDAO#addNewReleasedGame(com.tutorial.game.bean.dto.game.IGame)
	 */
	@Override
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
