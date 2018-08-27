package com.tutorial.struts.action.save.game;

import com.tutorial.struts.action.AbstractAction;
import com.tutorial.struts.exception.GameException;
import com.tutorial.struts.service.game.GameService;

public class DeleteGameAction extends AbstractAction {

	private static final long serialVersionUID = -6551243955341776431L;

	final GameService gameService = new GameService();
	
	private String gameId;

	public String execute() throws GameException {
		
		gameService.deleteGame(gameId);
		
		return SUCCESS;
	}
	
	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

}
