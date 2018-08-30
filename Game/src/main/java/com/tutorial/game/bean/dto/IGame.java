package com.tutorial.game.bean.dto;

import com.tutorial.game.bean.dto.impl.Developper;

public interface IGame {

	Integer getId();

	String getIdNumber();

	void setId(Integer id);

	String getName();

	void setName(String name);

	Developper getDevelopper();

	void setDevelopper(Developper developper);

}