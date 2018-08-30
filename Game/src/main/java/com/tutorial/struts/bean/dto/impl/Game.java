package com.tutorial.struts.bean.dto.impl;

import java.io.Serializable;

import com.tutorial.struts.bean.dto.IGame;

public class Game implements Serializable, IGame {

	private static final long serialVersionUID = -494900350388110375L;
	
	private Integer id;
	private String name;
	private Developper developper;
	
	/* (non-Javadoc)
	 * @see com.tutorial.struts.bean.dto.impl.IGame#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.struts.bean.dto.impl.IGame#getIdNumber()
	 */
	@Override
	public String getIdNumber() {
		return id.toString();
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.struts.bean.dto.impl.IGame#setId(java.lang.Integer)
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.struts.bean.dto.impl.IGame#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.struts.bean.dto.impl.IGame#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.struts.bean.dto.impl.IGame#getDevelopper()
	 */
	@Override
	public Developper getDevelopper() {
		return developper;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.struts.bean.dto.impl.IGame#setDevelopper(com.tutorial.struts.bean.dto.impl.Developper)
	 */
	@Override
	public void setDevelopper(Developper developper) {
		this.developper = developper;
	}
}
