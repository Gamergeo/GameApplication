package com.tutorial.game.action.view.game;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.bean.dto.game.IGame;
import com.tutorial.game.bean.dto.game.impl.Game;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.game.GameService;

@Namespace(value="/")
@Action("displayGameSave")
@Result(name="success", location="/jsp/gameAdd.jsp")
public class DisplayGameSaveAction extends AbstractAction {

	final GameService gameService = new GameService();
	
	private static final long serialVersionUID = 5257907639559001732L;
	
	private IGame game = new Game();

	public String execute() throws NumberFormatException, GameException {
		if (game.getId() != null) {
			game = gameService.getGameWithDevelopperAndCountry(game.getId());	
		}
		
		// S'il n'y a pas d'erreurs, on retourne le forward "succes"
		return SUCCESS;
	}

	public IGame getGame() {
		return game;
	}

	public void setGame(IGame game) {
		this.game = game;
	}

}
