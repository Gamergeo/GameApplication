package com.tutorial.game.dao.country.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.dto.country.Country;
import com.tutorial.game.dao.country.ICountryDAO;
import com.tutorial.game.dao.impl.AbstractDAO;
import com.tutorial.game.exception.GameException;

@Repository
public class CountryDAO extends AbstractDAO implements ICountryDAO {
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.country.ICountryDAO#getCountryById(java.lang.Integer)
	 */
	@Override
	public Country getCountryById(Integer id) throws GameException {
		Connection connection = null;
		Country country = null;
		
		try {
			connection = getConnection();
			
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(""
					+ "SELECT COUNTRY.ID AS ID, COUNTRY.NAME AS NAME " 
					+ "FROM COUNTRY "
					+ "WHERE COUNTRY.ID = '" + id.toString() + "';");
			
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
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.country.ICountryDAO#getCountryByName(java.lang.String)
	 */
	@Override
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
	
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.country.ICountryDAO#addNewCountry(com.tutorial.game.bean.dto.country.ICountry)
	 */
	@Override
	public Country addNewCountry(Country country) throws GameException {
		Connection connection = null;
		
		try {
			connection = getConnection();
			
			final Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO COUNTRY(name) VALUES ('" + country.getName() + "');");
			
			final ResultSet resultSet = statement.executeQuery("SELECT ID FROM COUNTRY WHERE name = '" + country.getName() + "';");
			
			resultSet.next();
			
			country.setId(resultSet.getInt("ID"));
			
			return country;

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
