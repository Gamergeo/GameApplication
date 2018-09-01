package com.tutorial.game.bean.dto.country.impl;

import java.io.Serializable;

import com.tutorial.game.bean.dto.country.ICountry;

public class Country implements Serializable, ICountry {

	private static final long serialVersionUID = -5192754055952114665L;
	
	private Integer id;
	private String name;
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.country.impl.ICountry#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.country.impl.ICountry#setId(java.lang.Integer)
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.country.impl.ICountry#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.country.impl.ICountry#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
}
