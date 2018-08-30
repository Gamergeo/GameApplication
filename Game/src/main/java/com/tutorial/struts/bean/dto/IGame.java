package com.tutorial.struts.bean.dto;

import com.tutorial.struts.bean.dto.impl.Developper;

public interface IGame {

	Integer getId();

	String getIdNumber();

	void setId(Integer id);

	String getName();

	void setName(String name);

	Developper getDevelopper();

	void setDevelopper(Developper developper);

}