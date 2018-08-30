package com.tutorial.struts.action;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public abstract class AbstractAction extends ActionSupport {
	
	private String errorMessage;

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	protected HttpServletRequest getRequest() {

		return ServletActionContext.getRequest();
	}
	
	public LocalDateTime getLocalDate() {
		return LocalDateTime.now();
	}

}
