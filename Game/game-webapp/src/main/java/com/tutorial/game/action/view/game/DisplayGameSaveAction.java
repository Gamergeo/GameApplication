package com.tutorial.game.action.view.game;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.exception.GameException;

@Namespace(value="/")
@Action("displayGameSave")
@Result(name="success", location="/jsp/gameAdd.jsp")
@Controller
public class DisplayGameSaveAction extends AbstractAction {
	
	private static final long serialVersionUID = 5257907639559001732L;
	
	private Game game = new Game();

	public String execute() throws NumberFormatException, GameException {
		if (game.getId() != null) {
			game = serviceFactory.getGameService().getGameWithDevelopperAndCountry(game.getId());	
		}
		
		// S'il n'y a pas d'erreurs, on retourne le forward "succes"
		return SUCCESS;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
