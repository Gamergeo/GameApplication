package com.tutorial.game.service.impl.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tutorial.game.bean.dto.user.User;
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
}
 