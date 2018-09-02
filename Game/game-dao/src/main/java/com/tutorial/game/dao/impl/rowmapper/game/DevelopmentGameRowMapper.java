package com.tutorial.game.dao.impl.rowmapper.game;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.bean.dto.developper.Developper;
import com.tutorial.game.bean.dto.game.DevelopmentGame;


/**
 * Mapper Row to Country 
 */
public class DevelopmentGameRowMapper implements RowMapper<DevelopmentGame> {

	@Override
	public DevelopmentGame mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		DevelopmentGame develomentGame = new DevelopmentGame();
		
		develomentGame.setId(resultSet.getInt("GAME.ID"));
		develomentGame.setName(resultSet.getString("GAME.NAME"));
		
		int devId = resultSet.getInt("DEV_ID");
		
		develomentGame.setDevelopper(new Developper());
		develomentGame.getDevelopper().setId(devId);
		
		if (resultSet.findColumn("DEVELOPPER.NAME") > 0) {
			develomentGame.getDevelopper().setName(resultSet.getString("DEVELOPPER.NAME"));
		}
		
		if (resultSet.findColumn("COUNTRY.NAME") > 0) {
			develomentGame.getDevelopper().setCountry(new Country());
			
			develomentGame.getDevelopper().getCountry().setName(resultSet.getString("COUNTRY.NAME"));
		}
		
		return develomentGame;
	}

}
