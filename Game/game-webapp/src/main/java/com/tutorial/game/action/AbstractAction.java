package com.tutorial.game.action;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.tutorial.game.service.IServiceFactory;

@ParentPackage("default")
public abstract class AbstractAction extends ActionSupport {
	
	private static final long serialVersionUID = -4083758616182790868L;
	
	@Autowired
	protected IServiceFactory serviceFactory;

	private String errorMessage;
	
	final private DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
	
	final private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	private LocalDateTime getDate() {
		return LocalDateTime.now();
	}
	
	public String getLocalDate() {
		return getDate().format(dateFormatter);
	}

	public String getLocalTime() {
		return getDate().format(timeFormatter);
	}
	
	public String getUSADate() {
		ZoneId usaZoneId = TimeZone.getTimeZone("PST").toZoneId();
		ZoneId parisZoneId = TimeZone.getTimeZone("ECT").toZoneId();
		
		ZonedDateTime zonedDateTime = ZonedDateTime.of(getDate(),parisZoneId);
		
		return ZonedDateTime.ofInstant(zonedDateTime.toInstant(), usaZoneId).format(dateFormatter);
//		return ZonedDateTime.now(usaZoneId).format(dateFormatter);
	}

	public String getUSATime() {
		ZoneId usaZoneId = TimeZone.getTimeZone("PST").toZoneId();
		ZoneId parisZoneId = TimeZone.getTimeZone("ECT").toZoneId();
		
		ZonedDateTime zonedDateTime = ZonedDateTime.of(getDate(),parisZoneId);
		
		return ZonedDateTime.ofInstant(zonedDateTime.toInstant(), usaZoneId).format(timeFormatter);
	}

}
