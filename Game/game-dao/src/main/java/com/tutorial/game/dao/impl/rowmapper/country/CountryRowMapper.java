package com.tutorial.game.dao.impl.rowmapper.country;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tutorial.game.bean.dto.country.Country;


/**
 * Mapper Row to Country 
 */
public class CountryRowMapper implements RowMapper<Country> {

	@Override
	public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
		Country country = new Country();
		
		country.setId(rs.getInt("COUNTRY.ID"));
		country.setName(rs.getString("COUNTRY.NAME"));
		
		return country;
	}

}
