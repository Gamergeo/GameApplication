package com.tutorial.game.bean.dto.user.impl;

import com.tutorial.game.bean.dto.user.IDevUser;
import com.tutorial.game.bean.dto.user.IUser;;

public class DevUser extends User implements IDevUser {
	
	private IUser user;
	
	public DevUser(IUser user) {
		this.user = user;
	}

	@Override
	public IUser geUser() {
		return user;
	}
}
