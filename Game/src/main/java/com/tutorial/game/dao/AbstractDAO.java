package com.tutorial.game.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.NamingException;

public abstract class AbstractDAO {

	final static String URL = "jdbc:mysql://localhost:3306/videogame?serverTimezone=UTC";
	final static String USER = "root";
	final static String PASSWORD = "gemar020688";
	Connection connexion = null;

	protected Connection getConnection() throws NamingException, SQLException {
		connexion = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return connexion;
	}
}
