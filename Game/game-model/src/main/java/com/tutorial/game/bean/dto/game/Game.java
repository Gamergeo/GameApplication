package com.tutorial.game.bean.dto.game;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.tutorial.game.bean.constant.BaseColumnName;
import com.tutorial.game.bean.constant.BaseTableName;
import com.tutorial.game.bean.dto.user.Manager;

@Entity(name=BaseTableName.TABLE_NAME_GAME)
@Table(name=BaseTableName.TABLE_NAME_GAME)
public class Game implements Serializable {

	private static final long serialVersionUID = -494900350388110375L;
	
	@Id
	@Column(name=BaseColumnName.COLUMN_NAME_ID)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	@NaturalId
	@Column(name=BaseColumnName.COLUMN_NAME_GAME_NAME)
	protected String name;
	
//	@ManyToOne
//	@JoinColumn(name=BaseColumnName.COLUMN_NAME_GAME_MANAGER_ID, referencedColumnName=BaseColumnName.COLUMN_NAME_ID)
//	private Manager manager;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Manager getManager() {
//		return manager;
//	}
//
//	public void setManager(Manager manager) {
//		this.manager = manager;
//	}
}
