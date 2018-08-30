package com.tutorial.struts.bean.dto;

import java.util.List;

import com.tutorial.struts.exception.GameException;

public interface IUser {

	public String getName();
	
	public List<IGame> getGames() throws GameException;

	void setName(String name);
}
