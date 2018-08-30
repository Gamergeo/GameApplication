package com.tutorial.game.bean.dto.impl;

import java.util.List;

import com.tutorial.game.bean.dto.IDevUser;
import com.tutorial.game.bean.dto.IGame;
import com.tutorial.game.bean.dto.IUser;
import com.tutorial.game.constants.GameConstants;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.game.GameDevelopmentService;

public class DevUser extends User implements IDevUser {
	
	final protected GameDevelopmentService gameDevelopmentService = new GameDevelopmentService();
	
	private IUser user;
	
	public DevUser(IUser user) {
		this.user = user;
	}

	@Override
	public IUser geUser() {
		return user;
	}
	
	@Override
	public List<IGame> getGames() throws GameException {
		List<IGame> listGames = user.getGames();
		listGames.addAll(gameDevelopmentService.getGamesInDeveloppmentWithDevelopperAndCountry(GameConstants.DEVELOPPMENT_MIN_PROGRESS_RATE));
		
		return listGames;
	}
}
