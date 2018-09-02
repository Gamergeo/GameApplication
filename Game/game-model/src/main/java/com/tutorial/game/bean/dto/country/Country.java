package com.tutorial.game.bean.dto.country;

import java.io.Serializable;

public class Country implements Serializable {

	private static final long serialVersionUID = -5192754055952114665L;
	
	private int id;
	private String name;
	
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
	
	
}
