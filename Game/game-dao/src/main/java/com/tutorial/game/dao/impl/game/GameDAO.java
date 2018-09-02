package com.tutorial.game.dao.impl.game;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.dao.contract.game.IGameDAO;
import com.tutorial.game.dao.impl.AbstractDAO;
import com.tutorial.game.dao.impl.rowmapper.game.GameRowMapper;
import com.tutorial.game.exception.GameException;

@Repository
public class GameDAO extends AbstractDAO implements IGameDAO {
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IGameDAO#getGameById(java.lang.int)
	 */
	@Override
	public Game getGameById(int id) throws GameException {
		String sql = 
				"SELECT GAME.ID, GAME.NAME, GAME.DEV_ID " 
						+ "FROM GAME "
						+ "WHERE GAME.ID = ?;";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		List<Game> listGame = jdbcTemplate.query(sql, new GameRowMapper(), id);
		
		if (listGame.isEmpty()) {
			throw new GameException("Cannot retrieve country");
			
		} else if (listGame.size() > 1) {
			throw new GameException("Multiple country found for this ID : Check database");
			
		} else {
			return listGame.get(0);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IGameDAO#getGameByName(java.lang.String)
	 */
	@Override
	public Game getGameByName(String name) throws GameException {
		String sql = 
				"SELECT GAME.ID, GAME.NAME, GAME.DEV_ID "  
						+ "FROM GAME "
						+ "WHERE GAME.NAME = ?;";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		List<Game> listGame = jdbcTemplate.query(sql, new GameRowMapper(), name);
		
		if (listGame.isEmpty()) {
			return null;
			
		} else if (listGame.size() > 1) {
			throw new GameException("Multiple country found for this ID : Check database");
			
		} else {
			return listGame.get(0);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IGameDAO#addNewGame(com.tutorial.game.bean.dto.game.IGame)
	 */
	@Override
	public void insertGame(Game game) throws GameException {
		
		if (game.getDevelopper() == null || game.getDevelopper().getId() <= 0) {
			throw new GameException("Developper is not set !");
		}
		
		String sql = "INSERT INTO GAME(NAME, DEV_ID) VALUES (:name, :devId);";
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", game.getName());
		params.addValue("devId", game.getDevelopper().getId());
		
		namedParameterJdbcTemplate.update(sql, params);
	}
	
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IGameDAO#updateGame(com.tutorial.game.bean.dto.game.IGame)
	 */
	@Override
	public void updateGame(Game game) throws GameException {
		
//		if (game.getDevelopper() == null || game.getDevelopper().getId() == null || game.getDevelopper().getId() <= 0) {
//			throw new GameException("Developper is not set !");
//		}
		
		String sql = "UPDATE GAME SET NAME = :name WHERE id = :id;";
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", game.getId());
		params.addValue("name", game.getName());
//		params.addValue("devId", game.getDevelopper().getId());
		
		namedParameterJdbcTemplate.update(sql, params);
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IGameDAO#deleteGame(java.lang.int)
	 */
	@Override
	public void deleteGame(int gameId) throws GameException {
		String sql = "DELETE FROM GAME WHERE ID = :id";
		String releasedSql = "DELETE FROM RELEASED_GAME WHERE ID = :id";
		String developmentSql = "DELETE FROM GAME_DEVELOPMENT WHERE ID = :id";
		
		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("id", gameId);
		
		namedParameterJdbcTemplate.update(developmentSql, params);
		namedParameterJdbcTemplate.update(releasedSql, params);
		namedParameterJdbcTemplate.update(sql, params);
	}
}
