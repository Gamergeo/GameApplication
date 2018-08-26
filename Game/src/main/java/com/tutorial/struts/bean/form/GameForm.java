package com.tutorial.struts.bean.form;

import java.io.Serializable;

import org.apache.struts.action.ActionForm;

public class GameForm extends ActionForm implements Serializable {
	
	private static final long serialVersionUID = 6132151801393267607L;
	
	private String gameId;
	private String gameName;
	private String devName;
	private String countryName;
	
	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	
	public String getGameName() {
		return gameName;
	}
	
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	public String getDevName() {
		return devName;
	}
	
	public void setDevName(String devName) {
		this.devName = devName;
	}
	
	public String getCountryName() {
		return countryName;
	}
	
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
