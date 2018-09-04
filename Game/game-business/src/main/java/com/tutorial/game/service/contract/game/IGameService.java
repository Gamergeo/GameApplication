package com.tutorial.game.service.contract.game;

import java.util.List;

import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.exception.GameException;

public interface IGameService {
	
	public List<Game> getAllGames() throws GameException;
	
	public Game getGameById(int id) throws GameException;

}