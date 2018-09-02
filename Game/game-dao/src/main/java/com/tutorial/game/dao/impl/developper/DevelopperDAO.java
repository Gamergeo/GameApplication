package com.tutorial.game.dao.impl.developper;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.dto.developper.Developper;
import com.tutorial.game.dao.contract.developper.IDevelopperDAO;
import com.tutorial.game.dao.impl.AbstractDAO;
import com.tutorial.game.dao.impl.rowmapper.developper.DevelopperRowMapper;
import com.tutorial.game.exception.GameException;

@Repository
public class DevelopperDAO extends AbstractDAO implements IDevelopperDAO {
	
	final private static Logger LOG = Logger.getLogger(DevelopperDAO.class.getName());
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.developper.IDevelopperDAO#getDevelopperById(java.lang.int)
	 */
	@Override
	public Developper getDevelopperById(int id) throws GameException {
		if (id == 0) {
			throw new GameException("Cannot retrieve developper :  Id is not correctly set");
		}
		
		String sql = "SELECT DEVELOPPER.ID, DEVELOPPER.NAME, DEVELOPPER.COU_ID " 
				+ "FROM DEVELOPPER "
				+ "WHERE DEVELOPPER.ID = ?";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		List<Developper> listDev = jdbcTemplate.query(sql, new DevelopperRowMapper(), id);
		
		if (listDev.isEmpty()) {
			LOG.severe("Cannot retrieve developper");
			throw new GameException("Cannot retrieve developper");
			
		} else if (listDev.size() > 1) {
			LOG.severe("Multiple developper found for this ID : Check database");
			throw new GameException("Multiple developper found for this ID : Check database");
			
		} else {
			return listDev.get(0);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.developper.IDevelopperDAO#getDevelopperByName(java.lang.String)
	 */
	@Override
	public Developper getDevelopperByName(String name) throws GameException {
		String sql = "SELECT DEVELOPPER.ID, DEVELOPPER.NAME, DEVELOPPER.COU_ID " 
				+ "FROM DEVELOPPER "
				+ "WHERE DEVELOPPER.NAME = ?";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

		List<Developper> listDev = jdbcTemplate.query(sql, new DevelopperRowMapper(), name);
		
		if (listDev.isEmpty()) {
			return null;
			
		} else if (listDev.size() > 1) {
			LOG.severe("Multiple developper found for this ID : Check database");
			throw new GameException("Multiple developper found for this ID : Check database");
			
		} else {
			return listDev.get(0);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.developper.IDevelopperDAO#addNewDevelopper(com.tutorial.game.bean.dto.developper.impl.Developper)
	 */
	@Override
	public void insertDevelopper(Developper developper) throws GameException {
		String sql = "INSERT INTO DEVELOPPER(name) VALUES (?);";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		jdbcTemplate.update(sql, developper.getName());
	}
}
