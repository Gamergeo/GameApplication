package com.tutorial.game.dao.impl.rowmapper.developper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.bean.dto.developper.Developper;


/**
 * Mapper Row to Country 
 */
public class DevelopperRowMapper implements RowMapper<Developper> {

	@Override
	public Developper mapRow(ResultSet rs, int rowNum) throws SQLException {
		Developper developper = new Developper();
		
		developper.setId(rs.getInt("DEVELOPPER.ID"));
		developper.setName(rs.getString("DEVELOPPER.NAME"));
		
		int countryId = rs.getInt("DEVELOPPER.COUNTRY_ID");
		
		// On insert le country
		Country country = new Country();
		
		country.setId(countryId);
		developper.setCountry(country);
		
		return developper;
	}

}
