package com.tutorial.game.bean.dto.impl;

import java.util.List;

import com.tutorial.game.bean.dto.IGame;
import com.tutorial.game.bean.dto.IUser;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.game.ReleasedGameService;

public class User implements IUser {
	
	final private ReleasedGameService releasedGameService = new ReleasedGameService();
	
	private String name;

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public List<IGame> getGames() throws GameException {
		return releasedGameService.getReleasedtWithDevelopperAndCountry();
	}
}
