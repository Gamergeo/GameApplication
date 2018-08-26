package com.tutorial.struts.dao.country;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tutorial.struts.bean.dto.Country;
import com.tutorial.struts.dao.AbstractDAO;
import com.tutorial.struts.exception.GameException;

public class CountryDAO extends AbstractDAO {
	
	/**
	 * @return the country if exists, null in other case
	 * @throws GameException
	 */
	public Country getCountryByName(String name) throws GameException {
		Connection connection = null;
		Country country = null;
		
		try {
			connection = getConnection();
			
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(""
					+ "SELECT COUNTRY.ID AS ID, COUNTRY.NAME AS NAME " 
					+ "FROM COUNTRY "
					+ "WHERE COUNTRY.name = '" + name + "';");
			
			if (resultSet.next()) {
				country = new Country();
				
				country.setId(resultSet.getInt("ID"));
				country.setName(resultSet.getString("NAME"));
			}
			
		}  catch (Exception exception) {
			
			throw new GameException(exception, getClass().toString() + ".getConnection() Message : " + exception.getMessage());
			
		} finally {
			
			try {
				connection.close();
				
			} catch (SQLException exception) {
				throw new GameException(exception, getClass().toString() + ".getConnection() Message : " + exception.getMessage());
			}
		}
		
		return country;
	}
	
	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	public Integer addNewCountry(Country country) throws GameException {
		Connection connection = null;
		
		try {
			connection = getConnection();
			
			final Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO COUNTRY(name) VALUES ('" + country.getName() + "');");
			
			final ResultSet resultSet = statement.executeQuery("SELECT ID FROM COUNTRY WHERE name = '" + country.getName() + "';");
			
			resultSet.next();
			
			return resultSet.getInt("ID");

		}  catch (Exception exception) {
			
			throw new GameException(exception, getClass().toString() + ".getConnection() Message : " + exception.getMessage());
			
		} finally {
			
			try {
				connection.close();
				
			} catch (SQLException exception) {
				throw new GameException(exception, getClass().toString() + ".getConnection() Message : " + exception.getMessage());
			}
		}	
	}
}
