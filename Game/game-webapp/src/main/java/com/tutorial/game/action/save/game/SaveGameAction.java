package com.tutorial.game.action.save.game;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.exception.GameException;

@Namespace(value="/")
@Controller
public class SaveGameAction extends AbstractAction {

	private static final long serialVersionUID = -6816837196571984771L;

	private Game game = new Game();
	
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
		if (game.getId() != 0) {
			serviceFactory.getGameService().updateGame(game);
		} else { // create
			serviceFactory.getGameService().createANewGame(game);
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
		serviceFactory.getGameService().deleteGame(game.getId());
		
		return SUCCESS;
	}
	
	public String update() throws GameException {
		return SUCCESS;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}
