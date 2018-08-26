package com.tutorial.struts.bean.dto;

import java.io.Serializable;

public class Country implements Serializable {

	private static final long serialVersionUID = -5192754055952114665L;
	
	private Integer id;
	private String name;
	
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
}
