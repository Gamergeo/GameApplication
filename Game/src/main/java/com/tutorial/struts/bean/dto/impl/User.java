package com.tutorial.struts.bean.dto.impl;

import java.util.List;

import com.tutorial.struts.bean.dto.IGame;
import com.tutorial.struts.bean.dto.IUser;
import com.tutorial.struts.exception.GameException;
import com.tutorial.struts.service.game.ReleasedGameService;

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
