package com.tutorial.game.bean.dto.user.impl;

import com.tutorial.game.bean.dto.user.IUser;
import com.tutorial.game.constants.GameConstants;

public class User implements IUser {
	
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
	public boolean isDevUser() {
		return getName().equals(GameConstants.USER_NAME_DEV);
	}
	
	@Override
	public boolean isManagerUser() {
		return getName().equals(GameConstants.USER_NAME_MANAGER);
	}
}
