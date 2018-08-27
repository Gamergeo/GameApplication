package com.tutorial.struts.action.save.game;

import com.tutorial.struts.action.AbstractAction;
import com.tutorial.struts.exception.GameException;
import com.tutorial.struts.service.game.GameService;

public class SaveGameAction extends AbstractAction {

	private static final long serialVersionUID = -6816837196571984771L;

	final GameService gameService = new GameService();
	
	private String gameId;

	private String gameName;
	
	private String devName;
	
	private String countryName;
	
	public String execute() throws GameException {
		
		gameService.createANewGame(gameName, devName, countryName);
		
		return SUCCESS;
	}
	
	public String delete() throws GameException {
		gameId = getRequest().getParameter("gameId");
		
		gameService.deleteGame(gameId);
		
		return SUCCESS;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
	
	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getDevName() {
		return devName;
	}

	public void setDevName(String devName) {
		this.devName = devName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
