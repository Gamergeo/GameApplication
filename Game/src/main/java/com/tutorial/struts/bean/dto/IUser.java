package com.tutorial.struts.bean.dto;

import java.util.Set;

import com.tutorial.struts.exception.GameException;

public interface IUser {

	public String getName();
	
	public Set<IGame> getGames() throws GameException;

	void setName(String name);
}
