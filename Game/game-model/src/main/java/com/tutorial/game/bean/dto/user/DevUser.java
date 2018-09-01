package com.tutorial.game.bean.dto.user;

;

public class DevUser extends User {
	
	private User user;
	
	public DevUser(User user) {
		this.user = user;
	}

	public User geUser() {
		return user;
	}
}
