package com.tutorial.game.dao.impl.rowmapper.game;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.bean.dto.developper.Developper;
import com.tutorial.game.bean.dto.game.ReleasedGame;


/**
 * Mapper Row to Country 
 */
public class ReleasedGameRowMapper implements RowMapper<ReleasedGame> {

	@Override
	public ReleasedGame mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		ReleasedGame releasedGame = new ReleasedGame();
		
		releasedGame.setId(resultSet.getInt("GAME.ID"));
		releasedGame.setName(resultSet.getString("GAME.NAME"));
		
		int devId = resultSet.getInt("DEV_ID");
		
		if (devId != 0) {
			releasedGame.setDevelopper(new Developper());
			releasedGame.getDevelopper().setId(devId);
		}
		
		if (resultSet.findColumn("DEVELOPPER.NAME") > 0) {
			releasedGame.getDevelopper().setName(resultSet.getString("DEVELOPPER.NAME"));
		}
		
		if (resultSet.findColumn("COUNTRY.NAME") > 0) {
			releasedGame.getDevelopper().setCountry(new Country());
			
			releasedGame.getDevelopper().getCountry().setName(resultSet.getString("COUNTRY.NAME"));
		}
		
		return releasedGame;
	}

}
