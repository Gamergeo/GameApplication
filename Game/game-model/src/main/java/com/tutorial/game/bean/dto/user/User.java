package com.tutorial.game.bean.dto.user;

import com.tutorial.game.constants.GameConstants;

public class User {
	
	private String name;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isDevUser() {
		return getName().equals(GameConstants.USER_NAME_DEV);
	}
	
	public boolean isManagerUser() {
		return getName().equals(GameConstants.USER_NAME_MANAGER);
	}
}
