package com.tutorial.game.service.impl.game;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.bean.dto.user.User;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.contract.game.IGameService;
import com.tutorial.game.service.impl.AbstractService;

@Service
public class GameService extends AbstractService implements IGameService {
	
	final private static Logger LOG = Logger.getLogger(GameService.class.getName());
	
	@Override
	public List<Game> getAllGames() throws GameException {
		return daoFactory.getGameDao().findAll();
	}

	@Override
	public Game getGameById(int id) throws GameException {
		if (id <= 0) {
			throw new GameException("id is incorrect :" + id + " in getGameById()");
		}
		
		Game game = daoFactory.getGameDao().findById(id);
		
		load(game.getManager().getManagedGames());
		
		return game;
	}
}
 