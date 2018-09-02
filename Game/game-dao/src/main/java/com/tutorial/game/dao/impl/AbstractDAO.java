package com.tutorial.game.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO {
	
	@Autowired
	private DataSource dataSource;
	
	protected Connection getConnection() throws NamingException, SQLException {		
		
		return dataSource.getConnection();
	}
	
	protected DataSource getDataSource() {
		return dataSource;
	}
}
