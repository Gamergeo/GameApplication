package com.tutorial.game.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.tutorial.game.exception.GameException;

public abstract class AbstractDAO {
	
	@Autowired
	private DataSource dataSource;
	
	protected Connection getConnection() throws NamingException, SQLException {		
		
		return dataSource.getConnection();
	}
	
	protected DataSource getDataSource() throws GameException {
		
		if (dataSource == null) {
			throw new GameException("dataSource is not correctly setted");
		}
		
		return dataSource;
	}
}
