package com.tutorial.game.dao.impl.game;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.dto.game.ReleasedGame;
import com.tutorial.game.dao.contract.game.IReleasedGameDAO;
import com.tutorial.game.dao.impl.AbstractDAO;
import com.tutorial.game.dao.impl.rowmapper.game.ReleasedGameRowMapper;
import com.tutorial.game.exception.GameException;

@Repository
public class ReleasedGameDAO extends AbstractDAO implements IReleasedGameDAO {
	
	final private static Logger LOG = Logger.getLogger(ReleasedGameDAO.class.toString());
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IReleasedGameDAO#addNewReleasedGame(com.tutorial.game.bean.dto.game.IGame)
	 */
	@Override
	public void insertReleasedGame(ReleasedGame releasedGame) throws GameException {
		
		if (releasedGame.getDevelopper() == null || releasedGame.getDevelopper().getId() == 0) {
			LOG.severe("Developper is not set !");
			throw new GameException("Developper is not set !");
		}
		
		String sql = "INSERT INTO RELEASED_GAME VALUES (?, sysdate());";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		jdbcTemplate.update(sql, releasedGame.getId());
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IReleasedGameDAO#getGamesInDevelopementInfo(int)
	 */
	@Override
	public List<ReleasedGame> getAllReleasedGameWhitInfos() throws GameException {
		String sql =
					"SELECT GAME.ID, GAME.NAME, GAME.DEV_ID, DEVELOPPER.NAME, COUNTRY.NAME " 
				  + "FROM GAME "
				  + "INNER JOIN RELEASED_GAME ON RELEASED_GAME.ID = GAME.ID "
				  + "INNER JOIN DEVELOPPER ON GAME.DEV_ID = DEVELOPPER.id "
				  + "LEFT OUTER JOIN COUNTRY ON DEVELOPPER.COU_ID = COUNTRY.id ORDER BY GAME.ID; ";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		return jdbcTemplate.query(sql, new ReleasedGameRowMapper());
	}
}
