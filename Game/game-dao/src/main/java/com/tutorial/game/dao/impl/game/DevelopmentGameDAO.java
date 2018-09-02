package com.tutorial.game.dao.impl.game;

import java.sql.Types;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.dto.game.DevelopmentGame;
import com.tutorial.game.dao.contract.game.IDevelopmentGameDAO;
import com.tutorial.game.dao.impl.AbstractDAO;
import com.tutorial.game.dao.impl.rowmapper.game.DevelopmentGameRowMapper;
import com.tutorial.game.exception.GameException;

@Repository
public class DevelopmentGameDAO extends AbstractDAO implements IDevelopmentGameDAO {
	
	final private static Logger LOG = Logger.getLogger(DevelopmentGameDAO.class.getName());
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IReleasedGameDAO#addNewReleasedGame(com.tutorial.game.bean.dto.game.IGame)
	 */
	@Override
	public void insertDevelopmentGame(DevelopmentGame developmentGame) throws GameException {
		
		if (developmentGame.getDevelopper() == null || developmentGame.getDevelopper().getId() == 0) {
			LOG.severe("Developper is not set ! ");
			throw new GameException("Developper is not set !");
		}
		
		String sql = "INSERT INTO RELEASED_GAME VALUES (?, sysdate());";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		jdbcTemplate.update(sql, developmentGame.getId());
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IReleasedGameDAO#getAllDevelopmentGameWhitInfos(int)
	 */
	@Override
	public List<DevelopmentGame> getAllDevelopmentGameWhitInfos(int minProgressRate) throws GameException {
		String sql =
					"SELECT GAME.ID, GAME.NAME, GAME.DEV_ID, DEVELOPPER.NAME, COUNTRY.NAME " 
				  + "FROM GAME "
				  + "INNER JOIN GAME_DEVELOPMENT ON GAME_DEVELOPMENT.ID = GAME.ID AND GAME_DEVELOPMENT.PROGRESSRATE > :progressRate "
				  + "INNER JOIN DEVELOPPER ON GAME.DEV_ID = DEVELOPPER.id "
				  + "LEFT OUTER JOIN COUNTRY ON DEVELOPPER.COU_ID = COUNTRY.id ORDER BY GAME.ID; ";
		
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("progressRate", minProgressRate, Types.INTEGER);
		
		return jdbcTemplate.query(sql, params, new DevelopmentGameRowMapper());
	}
}
