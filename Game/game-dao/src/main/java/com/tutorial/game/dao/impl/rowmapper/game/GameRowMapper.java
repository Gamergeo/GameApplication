package com.tutorial.game.dao.impl.rowmapper.game;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tutorial.game.bean.dto.developper.Developper;
import com.tutorial.game.bean.dto.game.Game;


/**
 * Mapper Row to Country 
 */
public class GameRowMapper implements RowMapper<Game> {

	@Override
	public Game mapRow(ResultSet rs, int rowNum) throws SQLException {
		Game game = new Game();
		
		game.setId(rs.getInt("GAME.ID"));
		game.setName(rs.getString("GAME.NAME"));
		
		int devId = rs.getInt("DEV_ID");
		
		if (devId != 0) {
			
			game.setDevelopper(new Developper());
			game.getDevelopper().setId(devId);
		}
			
		return game;
	}

}
