package com.tutorial.game.dao.contract;

import java.util.List;

public interface IDao<T> {

	public void persist(T type);
    
    public void update(T type);

    public T findById(int id);
 
    public void delete(T type);

	public List<T> findAll();
}
