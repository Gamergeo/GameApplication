package com.tutorial.game.bean.dto.developper;

import java.io.Serializable;

import com.tutorial.game.bean.dto.country.Country;

public class Developper implements Serializable {

	private static final long serialVersionUID = 8976629745714380572L;
	
	private int id;
	private String name;
	private Country country;
	
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
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
}
