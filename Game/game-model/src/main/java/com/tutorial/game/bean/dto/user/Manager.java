package com.tutorial.game.bean.dto.user;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.tutorial.game.bean.constant.BaseColumnName;
import com.tutorial.game.bean.constant.BaseTableName;
import com.tutorial.game.bean.dto.game.Game;

@Entity(name=BaseTableName.TABLE_NAME_MANAGER)
@Table(name=BaseTableName.TABLE_NAME_MANAGER)
@PrimaryKeyJoinColumn(name=BaseColumnName.COLUMN_NAME_ID)
public class Manager extends Employe implements Serializable {
	
	private static final long serialVersionUID = -254764988152152269L;
	
	@OneToMany(mappedBy="manager")
	private List<Game> managedGames;

	public List<Game> getManagedGames() {
		return managedGames;
	}

	public void setManagedGames(List<Game> managedGames) {
		this.managedGames = managedGames;
	}
	
}
