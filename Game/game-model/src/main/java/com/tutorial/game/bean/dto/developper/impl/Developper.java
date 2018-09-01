package com.tutorial.game.bean.dto.developper.impl;

import java.io.Serializable;

import com.tutorial.game.bean.dto.country.ICountry;
import com.tutorial.game.bean.dto.country.impl.Country;
import com.tutorial.game.bean.dto.developper.IDevelopper;

public class Developper implements Serializable, IDevelopper {

	private static final long serialVersionUID = 8976629745714380572L;
	
	private Integer id;
	private String name;
	private ICountry country = new Country();
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.developper.impl.IDevelopper#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.developper.impl.IDevelopper#setId(java.lang.Integer)
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.developper.impl.IDevelopper#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.developper.impl.IDevelopper#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public ICountry getCountry() {
		return country;
	}

	@Override
	public void setCountry(ICountry country) {
		this.country = country;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.developper.impl.IDevelopper#getCountryNameIfExists()
	 */
	@Override
	public String getCountryNameIfExists() {
		return country == null ? "" : country.getName(); 
	}
}
