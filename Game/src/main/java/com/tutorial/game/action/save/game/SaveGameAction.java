package com.tutorial.game.action.save.game;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.bean.dto.IGame;
import com.tutorial.game.bean.dto.impl.Game;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.game.GameService;

@Namespace(value="/")
public class SaveGameAction extends AbstractAction {

	private static final long serialVersionUID = -6816837196571984771L;

	final GameService gameService = new GameService();
	
	private IGame game = new Game();
	
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
		if (game.getId() != null) {
			gameService.updateGame(game);
		} else { // create
			gameService.createANewGame(game);
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
		gameService.deleteGame(game.getId());
		
		return SUCCESS;
	}
	
	public String update() throws GameException {
		return SUCCESS;
	}

	public IGame getGame() {
		return game;
	}

	public void setGame(IGame game) {
		this.game = game;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
