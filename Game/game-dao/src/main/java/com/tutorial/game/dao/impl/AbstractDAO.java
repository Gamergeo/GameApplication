package com.tutorial.game.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tutorial.game.dao.contract.IDao;
import com.tutorial.game.exception.GameException;

public abstract class AbstractDAO<T> implements IDao<T>{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Class<T> typeParameterClass;
	
	public AbstractDAO() {
		setTypeParameterClass();
	}
	
    // Mandatory to set with T.class for proper initialisation of abstract lethod
    protected abstract void setTypeParameterClass();
	
	protected Connection getConnection() throws NamingException, SQLException {		
		
		return dataSource.getConnection();
	}
	
	protected DataSource getDataSource() throws GameException {
		
		if (dataSource == null) {
			throw new GameException("dataSource is not correctly setted");
		}
		
		return dataSource;
	}
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
    public void persist(T type) {
        getCurrentSession().save(type);
    }
    
	@Override
    public void update(T type) {
        getCurrentSession().update(type);
    }

	@Override
    public T findById(int id) {
    	return getCurrentSession().get(typeParameterClass, id);
    }
 
	@Override
    public void delete(T type) {
        getCurrentSession().delete(type);
    }
    
	@Override
    public void delete(int id) {
        T type = (T) getCurrentSession().load(typeParameterClass, id);
        
        getCurrentSession().delete(type);
    }
    
    @SuppressWarnings("unchecked")
	protected List<T> findAll(String tableName) {
    	Query query = getCurrentSession().createQuery("FROM " + tableName);
    	
    	return query.getResultList();
    }
    
	public abstract List<T> findAll();
}
