package com.tutorial.game.action.save.game;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.bean.form.GameForm;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.game.GameService;

@Namespace(value="/")
public class SaveGameAction extends AbstractAction {

	private static final long serialVersionUID = -6816837196571984771L;

	final GameService gameService = new GameService();
	
	private GameForm gameForm = new GameForm();
	
	private String method;

	@Action(value="saveGame", results = {
			@Result(name="success", 
					location="displayGameList", 
			        type = "redirect"),
			@Result(name="successAdd", 
					location="displayGameSave", 
					type = "redirect")
	})
	public String execute() throws GameException {
		
		// update
		if (StringUtils.isNotBlank(gameForm.getGameId())) {
			gameService.updateGame(Integer.parseInt(gameForm.getGameId()), gameForm.getGameName(), gameForm.getDevName(), gameForm.getCountryName());
		} else { // create
			gameService.createANewGame(gameForm.getGameName(), gameForm.getDevName(), gameForm.getCountryName());
		}
		
		if (method.equals("saveAndAdd")) {
			return "successAdd";
		}
		return SUCCESS;
	}
	
	@Action(value="delete", results = {
			@Result(name="success",
					location="displayGameList", 
			        type = "redirect")
	})
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

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
