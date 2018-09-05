package com.tutorial.game.service.impl.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tutorial.game.bean.dto.user.Client;
import com.tutorial.game.bean.dto.user.User;
import com.tutorial.game.constants.RoleEnum;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.contract.user.IUserService;
import com.tutorial.game.service.impl.AbstractService;

@Service
public class UserService extends AbstractService implements IUserService {
	
//	final private static Logger LOG = Logger.getLogger(UserService.class.getName());
	
	@Override
	public List<User> getAllUsers() throws GameException {
		return daoFactory.getUserDao().findAll();
	}

	@Override
	public User getUserById(int id) throws GameException {
		if (id <= 0) {
			throw new GameException("id is incorrect :" + id + " in getGameById()");
		}
		
		User user = daoFactory.getUserDao().findById(id);
		
		return user;
	}
	
	@Override
	public User addOrUpdateUser(User user) {
		
		if (user.getId() > 0) {
			
			return serviceFactory.getUserService().updateUser(user, RoleEnum.ROLE_CLIENT);
		
		} else {
			return serviceFactory.getUserService().addNewUser(user);
		}
	}
	
	@Override
	public User updateUser(User user, RoleEnum role) {
		
		if (RoleEnum.ROLE_CLIENT.equals(role)) {
			Client client = daoFactory.getClientDao().findById(user.getId());
			
			client.setFirstName(user.getFirstName());
			client.setLastName(user.getLastName());
			client.setEmail(user.getEmail());
			
			daoFactory.getClientDao().update(client);
			
			return client;
		}
		
		return null;
	}
	
	@Override
	public User addNewUser(User user) {
		return serviceFactory.getUserService().addNewUser(user.getFirstName(), user.getLastName(), user.getEmail());
	}
	
	@Override
	public User addNewUser(String firstName, String lastName, String email) {
		return serviceFactory.getUserService().addNewUser(firstName, lastName, email, UserRoleEnum.CLIENT);
	}
	
	@Override
	public User addNewUser(String firstName, String lastName, String email, UserRoleEnum role) {
		String num = "TODO";
		return  serviceFactory.getUserService().addNewUser(firstName, lastName, email, num, role);
	}

	@Override
	public User addNewUser(String firstName, String lastName, String email, String num, UserRoleEnum role) {
		if (role.equals(UserRoleEnum.CLIENT)) {
			Client client = new Client();
			
			client.setFirstName(firstName);
			client.setLastName(lastName);
			client.setEmail(email);
			client.setNum(num);
			
			daoFactory.getClientDao().persist(client);
			
			return client;
		}
		
		return null;
//		throw new GameException("Not implemented yet");
	}
	
	@Override
	public void delete(int id) {		
		daoFactory.getUserDao().delete(id);
	}
}
 