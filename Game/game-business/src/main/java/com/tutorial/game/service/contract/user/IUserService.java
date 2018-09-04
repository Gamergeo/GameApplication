package com.tutorial.game.service.contract.user;

import java.util.List;

import com.tutorial.game.bean.dto.user.User;
import com.tutorial.game.exception.GameException;

public interface IUserService {
	
	public List<User> getAllUsers() throws GameException;
	
	public User getUserById(int id) throws GameException;

}