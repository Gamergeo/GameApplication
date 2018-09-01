package com.tutorial.game.bean.dto.user;

public class ManagerUser extends User {
	
	private User user;
	
	public ManagerUser(User user) {
		this.user = user;
	}

	public User geUser() {
		return user;
	}
}
