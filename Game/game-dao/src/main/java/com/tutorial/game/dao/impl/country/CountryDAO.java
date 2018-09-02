package com.tutorial.game.dao.impl.country;

import java.sql.Types;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.dao.contract.country.ICountryDAO;
import com.tutorial.game.dao.impl.AbstractDAO;
import com.tutorial.game.dao.impl.rowmapper.country.CountryRowMapper;
import com.tutorial.game.exception.GameException;

@Repository
public class CountryDAO extends AbstractDAO implements ICountryDAO {
	
	final private static Logger LOG = Logger.getLogger(CountryDAO.class.getName());
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.country.ICountryDAO#getCountryById(java.lang.int)
	 */
	@Override
	public Country getCountryById(int id) throws GameException {
		String sql = 
				"SELECT COUNTRY.ID, COUNTRY.NAME " 
				+ "FROM COUNTRY "
				+ "WHERE COUNTRY.ID = :id;";
		
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("id", id, Types.INTEGER);
		
		List<Country> listCountry = jdbcTemplate.query(sql, params, new CountryRowMapper());
		
		if (listCountry.isEmpty()) {
			LOG.severe("Cannot retrieve country");
			throw new GameException("Cannot retrieve country");
			
		} else if (listCountry.size() > 1) {
			LOG.severe("Multiple country found for this ID : Check database");
			throw new GameException("Multiple country found for this ID : Check database");
			
		} else {
			return listCountry.get(0);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.country.ICountryDAO#getCountryByName(java.lang.String)
	 */
	@Override
	public Country getCountryByName(String name) throws GameException {
		String sql = 
				"SELECT COUNTRY.ID, COUNTRY.NAME " 
				+ "FROM COUNTRY "
				+ "WHERE COUNTRY.NAME = ?;";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		List<Country> listCountry = jdbcTemplate.query(sql, new CountryRowMapper(), name);
		
		if (listCountry.isEmpty()) {
			return null;
			
		} else if (listCountry.size() > 1) {
			LOG.severe("Multiple country found for this ID : Check database");
			throw new GameException("Multiple country found for this ID : Check database");
			
		} else {
			return listCountry.get(0);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.country.ICountryDAO#addNewCountry(com.tutorial.game.bean.dto.country.ICountry)
	 */
	@Override
	public void insertCountry(Country country) throws GameException {
		String sql = "INSERT INTO COUNTRY(name) VALUES (?);";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		jdbcTemplate.update(sql, country.getName());
	}
}
