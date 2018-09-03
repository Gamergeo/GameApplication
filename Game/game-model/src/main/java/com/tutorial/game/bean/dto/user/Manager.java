package com.tutorial.game.bean.dto.user;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tutorial.game.bean.constant.BaseTableName;
import com.tutorial.game.bean.dto.game.Game;

@Entity
@Table(name=BaseTableName.TABLE_NAME_MANAGER)
public class Manager extends Employe {
	
//	@OneToMany()
//	private List<Game> managedGames;
//
//	public List<Game> getManagedGames() {
//		return managedGames;
//	}
//
//	public void setManagedGames(List<Game> managedGames) {
//		this.managedGames = managedGames;
//	}
	
}
