package com.tutorial.struts.dao.developper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tutorial.struts.bean.dto.Developper;
import com.tutorial.struts.dao.AbstractDAO;
import com.tutorial.struts.exception.GameException;

public class DevelopperDAO extends AbstractDAO {
	
	/**
	 * @return the country if exists, null in other case
	 * @throws GameException
	 */
	public Developper getDevelopperByName(String name) throws GameException {
		Connection connection = null;
		Developper developper = null;
		
		try {
			connection = getConnection();
			
			final Statement statement = connection.createStatement();
			final ResultSet resultSet = statement.executeQuery(""
					+ "SELECT DEVELOPPER.ID AS ID, DEVELOPPER.NAME AS NAME " 
					+ "FROM DEVELOPPER "
					+ "WHERE DEVELOPPER.name = '" + name + "';");
			
			if (resultSet.next()) {
				developper = new Developper();
				
				developper.setId(resultSet.getInt("ID"));
				developper.setName(resultSet.getString("NAME"));
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
		
		return developper;
	}
	
	/**
	 * Add a new country without no check
	 * @throws GameException 
	 */
	public Integer addNewDevelopper(Developper developper) throws GameException {
		Connection connection = null;
		
		try {
			connection = getConnection();
			
			final boolean isCountrySet = developper.getCountry() != null && developper.getCountry().getId() != null;
			
			final Statement statement = connection.createStatement();
			
			String sqlQuery = "INSERT INTO DEVELOPPER(name";
			
			if (isCountrySet) {
				sqlQuery += ",idCountry)";
			} else {
				sqlQuery += ")";
			}
			
			sqlQuery +=" VALUES ('" + developper.getName() + "'";
			
			if (isCountrySet) {
				sqlQuery += "," + developper.getCountry().getId() + ");";
			} else {
				sqlQuery += ");";
			}
			
			statement.executeUpdate(sqlQuery);
			
			final ResultSet resultSet = statement.executeQuery("SELECT ID FROM DEVELOPPER WHERE name = '" + developper.getName() + "';");
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
