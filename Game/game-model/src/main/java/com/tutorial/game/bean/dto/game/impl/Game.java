package com.tutorial.game.bean.dto.game.impl;

import java.io.Serializable;

import com.tutorial.game.bean.dto.developper.impl.Developper;
import com.tutorial.game.bean.dto.game.IGame;

public class Game implements Serializable, IGame {

	private static final long serialVersionUID = -494900350388110375L;
	
	private Integer id;
	private String name;
	private Developper developper = new Developper();
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.impl.IGame#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.impl.IGame#getIdNumber()
	 */
	@Override
	public String getIdNumber() {
		return id.toString();
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.impl.IGame#setId(java.lang.Integer)
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.impl.IGame#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.impl.IGame#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.impl.IGame#getDevelopper()
	 */
	@Override
	public Developper getDevelopper() {
		return developper;
	}
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.bean.dto.impl.IGame#setDevelopper(com.tutorial.game.bean.dto.impl.Developper)
	 */
	@Override
	public void setDevelopper(Developper developper) {
		this.developper = developper;
	}
}
