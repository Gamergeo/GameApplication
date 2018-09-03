package com.tutorial.game.dao.contract.game;

import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.dao.contract.IDao;
import com.tutorial.game.exception.GameException;

public interface IGameDAO extends IDao<Game> {

	/**
	 * @return the country if exists, null in other case
	 * @throws GameException
	 */
	Game getGameByName(String name) throws GameException;
}