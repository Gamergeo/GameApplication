package com.tutorial.game.action.view.game;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.exception.GameException;

@Namespace(value="/game")
@Controller
public class DisplayGameAction extends AbstractAction {
	
	private static final long serialVersionUID = 5257907639559001732L;
	
	private Game game;
	
	@Action(value="view", results= {
			@Result(name="success", location="/jsp/game/gameView.jsp")})
	public String displayView() throws GameException {
		if (game.getId() <= 0) {
			throw new GameException("Incorrect id " + game.getId());
			
		}
		game = serviceFactory.getGameService().getGameById(game.getId());
		
		// On recupère les autres jeux managés
		game.getManager().getManagedGames();
		
		return SUCCESS;
	}

	public String displayEdit() throws GameException {
		if (game.getId() != 0) {
			game = serviceFactory.getGameService().getGameById(game.getId());
//			game = serviceFactory.getGameService().getGameWithDevelopperAndCountry(game.getId());	
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
