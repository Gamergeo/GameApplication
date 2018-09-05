package com.tutorial.game.service.contract.user;

import java.util.List;

import com.tutorial.game.bean.dto.user.User;
import com.tutorial.game.constants.RoleEnum;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.impl.user.UserRoleEnum;

public interface IUserService {
	
	public List<User> getAllUsers() throws GameException;
	
	public User getUserById(int id) throws GameException;

	public User addNewUser(User user);
	
	public User addNewUser(String firstName, String lastName, String email);
	
	public User addNewUser(String firstName, String lastName, String email, UserRoleEnum role);

	public User addNewUser(String firstName, String lastName, String email, String num, UserRoleEnum role);

	public User addOrUpdateUser(User user);

	public void delete(int id);

	public User updateUser(User user, RoleEnum role);

}