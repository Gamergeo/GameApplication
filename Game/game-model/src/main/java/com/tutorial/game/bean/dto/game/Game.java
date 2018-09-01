package com.tutorial.game.bean.dto.game;

import java.io.Serializable;

import com.tutorial.game.bean.dto.developper.Developper;

public class Game implements Serializable {

	private static final long serialVersionUID = -494900350388110375L;
	
	private Integer id;
	private String name;
	private Developper developper = new Developper();
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Developper getDevelopper() {
		return developper;
	}

	public void setDevelopper(Developper developper) {
		this.developper = developper;
	}
}
