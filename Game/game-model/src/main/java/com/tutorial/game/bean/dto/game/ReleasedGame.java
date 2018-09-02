package com.tutorial.game.bean.dto.game;

import java.util.Date;

public class ReleasedGame extends Game {

	private static final long serialVersionUID = 8287776973782974976L;

	private Date outDate;
	
	public ReleasedGame() {
		super();
	}
	
	public ReleasedGame(Game game) {
		this.id = game.id;
		this.name = game.name;
		this.developper = game.developper;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
}
