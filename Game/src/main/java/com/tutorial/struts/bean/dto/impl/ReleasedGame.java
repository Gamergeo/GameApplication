package com.tutorial.struts.bean.dto.impl;

import java.util.Date;

public class ReleasedGame extends Game {

	private static final long serialVersionUID = 8287776973782974976L;

	private Date outDate;

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
}
