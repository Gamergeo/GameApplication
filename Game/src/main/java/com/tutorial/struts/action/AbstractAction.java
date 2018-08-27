package com.tutorial.struts.action;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction extends ActionSupport {
	
	protected String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

}
