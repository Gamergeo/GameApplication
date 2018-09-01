package com.tutorial.game.bean.dto.developper;

import com.tutorial.game.bean.dto.country.ICountry;

public interface IDevelopper {

	Integer getId();

	void setId(Integer id);

	String getName();

	void setName(String name);

	ICountry getCountry();

	void setCountry(ICountry country);

	String getCountryNameIfExists();

}