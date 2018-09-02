package com.tutorial.game.service.contract.game;

import java.util.List;

import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.bean.dto.game.ReleasedGame;
import com.tutorial.game.exception.GameException;

public interface IReleasedGameService {

	/**
	 * @return All the game in dev with developper and country (if exists)
	 */
	List<ReleasedGame> getReleasedtWithDevelopperAndCountry() throws GameException;

	void insertReleasedGame(Game releasedGame) throws GameException;
	
	void insertReleasedGame(ReleasedGame releasedGame) throws GameException;

}