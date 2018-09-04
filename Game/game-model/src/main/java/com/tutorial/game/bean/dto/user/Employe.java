package com.tutorial.game.bean.dto.user;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.tutorial.game.bean.constant.BaseColumnName;
import com.tutorial.game.bean.constant.BaseTableName;
import com.tutorial.game.bean.dto.game.Game;

@Entity(name=BaseTableName.TABLE_NAME_EMPLOYE)
@Table(name=BaseTableName.TABLE_NAME_EMPLOYE)
@PrimaryKeyJoinColumn(name=BaseColumnName.COLUMN_NAME_ID)
public class Employe extends User implements Serializable {

	private static final long serialVersionUID = 3938559497498961733L;

	@Column(name=BaseColumnName.COLUMN_NAME_EMPLOYE_NUM_EMPLOYE, nullable=false, unique=true)
	private String num;
	
	@ManyToMany(mappedBy="developpers")
	private Set<Game> developpedGames;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Set<Game> getDeveloppedGames() {
		return developpedGames;
	}

	public void setDeveloppedGames(Set<Game> developpedGames) {
		this.developpedGames = developpedGames;
	}
}
