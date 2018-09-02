package com.tutorial.game.dao.impl.country;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.dao.contract.country.ICountryDAO;
import com.tutorial.game.dao.impl.AbstractDAO;
import com.tutorial.game.dao.impl.rowmapper.country.CountryRowMapper;
import com.tutorial.game.exception.GameException;

@Repository
public class CountryDAO extends AbstractDAO implements ICountryDAO {
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.country.ICountryDAO#getCountryById(java.lang.int)
	 */
	@Override
	public Country getCountryById(int id) throws GameException {
		String sql = 
				"SELECT COUNTRY.ID, COUNTRY.NAME " 
				+ "FROM COUNTRY "
				+ "WHERE COUNTRY.ID = ?;";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		
		List<Country> listCountry = jdbcTemplate.query(sql, new CountryRowMapper(), id);
		
		if (listCountry.isEmpty()) {
			throw new GameException("Cannot retrieve country");
			
		} else if (listCountry.size() > 1) {
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
			throw new GameException("Multiple developper found for this ID : Check database");
			
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
