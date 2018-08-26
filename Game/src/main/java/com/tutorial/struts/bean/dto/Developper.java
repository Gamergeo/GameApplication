package com.tutorial.struts.bean.dto;

import java.io.Serializable;

public class Developper implements Serializable {

	private static final long serialVersionUID = 8976629745714380572L;
	
	private Integer id;
	private String name;
	private Country country;
	
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
