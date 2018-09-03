package com.tutorial.game.service.impl.game;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.tutorial.game.bean.dto.game.Game;
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
}
 