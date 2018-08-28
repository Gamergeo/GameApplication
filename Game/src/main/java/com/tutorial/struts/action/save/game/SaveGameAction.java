package com.tutorial.struts.action.save.game;

import org.apache.commons.lang3.StringUtils;

import com.tutorial.struts.action.AbstractAction;
import com.tutorial.struts.bean.form.GameForm;
import com.tutorial.struts.exception.GameException;
import com.tutorial.struts.service.game.GameService;

public class SaveGameAction extends AbstractAction {

	private static final long serialVersionUID = -6816837196571984771L;

	final GameService gameService = new GameService();
	
	private GameForm gameForm = new GameForm();

	public String execute() throws GameException {
		
		// update
		if (StringUtils.isNotBlank(gameForm.getGameId())) {
			gameService.updateGame(Integer.parseInt(gameForm.getGameId()), gameForm.getGameName(), gameForm.getDevName(), gameForm.getCountryName());
		} else { // create
			gameService.createANewGame(gameForm.getGameName(), gameForm.getDevName(), gameForm.getCountryName());
		}
		
		return SUCCESS;
	}
	
	public String delete() throws GameException {
		gameService.deleteGame(gameForm.getGameId());
		
		return SUCCESS;
	}
	
	public String update() throws GameException {
		return SUCCESS;
	}
	
	public GameForm getGameForm() {
		return gameForm;
	}

	public void setGameForm(GameForm gameForm) {
		this.gameForm = gameForm;
	}
}
