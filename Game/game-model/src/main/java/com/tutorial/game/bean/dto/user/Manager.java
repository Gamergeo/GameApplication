package com.tutorial.game.bean.dto.user;

import java.util.List;

import com.tutorial.game.bean.dto.game.Game;

//@Entity(name=BaseTableName.TABLE_NAME_MANAGER)
//@Table(name=BaseTableName.TABLE_NAME_MANAGER)
public class Manager extends Employe {
	
//	@OneToMany
	private List<Game> managedGames;

	public List<Game> getManagedGames() {
		return managedGames;
	}

	public void setManagedGames(List<Game> managedGames) {
		this.managedGames = managedGames;
	}
	
}
