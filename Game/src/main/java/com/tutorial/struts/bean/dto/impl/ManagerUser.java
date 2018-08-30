package com.tutorial.struts.bean.dto.impl;

import java.util.List;

import com.tutorial.struts.bean.dto.IDevUser;
import com.tutorial.struts.bean.dto.IGame;
import com.tutorial.struts.bean.dto.IUser;
import com.tutorial.struts.exception.GameException;
import com.tutorial.struts.service.game.GameDevelopmentService;

public class ManagerUser extends User implements IDevUser {
	
	final protected GameDevelopmentService gameDevelopmentService = new GameDevelopmentService();
	
	private IUser user;
	
	public ManagerUser(IUser user) {
		this.user = user;
	}

	@Override
	public IUser geUser() {
		return user;
	}
	
	@Override
	public List<IGame> getGames() throws GameException {
		List<IGame> listGames = user.getGames();
		listGames.addAll(gameDevelopmentService.getGamesInDeveloppmentWithDevelopperAndCountry());
		
		return listGames;
	}
}
