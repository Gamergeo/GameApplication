package com.tutorial.game.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.mysql.cj.jdbc.MysqlDataSource;

public abstract class AbstractDAO {
	
	@Autowired
	private DataSource dataSource;
	
	protected Connection getConnection() throws NamingException, SQLException {		
		
		return dataSource.getConnection();
	}
}
