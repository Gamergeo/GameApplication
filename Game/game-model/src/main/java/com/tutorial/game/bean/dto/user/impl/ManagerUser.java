package com.tutorial.game.bean.dto.user.impl;

import com.tutorial.game.bean.dto.user.IDevUser;
import com.tutorial.game.bean.dto.user.IUser;

public class ManagerUser extends User implements IDevUser {
	
//	final protected GameDevelopmentService gameDevelopmentService = new GameDevelopmentService();
	
	private IUser user;
	
	public ManagerUser(IUser user) {
		this.user = user;
	}

	@Override
	public IUser geUser() {
		return user;
	}
}
