package com.tutorial.game.dao.impl.game;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.dto.game.DevelopmentGame;
import com.tutorial.game.dao.contract.game.IDevelopmentGameDAO;
import com.tutorial.game.dao.impl.AbstractDAO;
import com.tutorial.game.dao.impl.rowmapper.game.DevelopmentGameRowMapper;
import com.tutorial.game.exception.GameException;

@Repository
public class DevelopmentGameDAO extends AbstractDAO implements IDevelopmentGameDAO {
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IReleasedGameDAO#addNewReleasedGame(com.tutorial.game.bean.dto.game.IGame)
	 */
	@Override
	public void insertDevelopmentGame(DevelopmentGame developmentGame) throws GameException {
		
		if (developmentGame.getDevelopper() == null || developmentGame.getDevelopper().getId() == 0) {
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
				  + "INNER JOIN GAME_DEVELOPMENT ON GAME_DEVELOPMENT.ID = GAME.ID AND GAME_DEVELOPMENT.PROGRESSRATE > ? "
				  + "INNER JOIN DEVELOPPER ON GAME.DEV_ID = DEVELOPPER.id "
				  + "LEFT OUTER JOIN COUNTRY ON DEVELOPPER.COU_ID = COUNTRY.id ORDER BY GAME.ID; ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		return jdbcTemplate.query(sql, new DevelopmentGameRowMapper(), minProgressRate);
	}
}
