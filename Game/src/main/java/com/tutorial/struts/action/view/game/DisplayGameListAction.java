package com.tutorial.struts.action.view.game;

import java.util.List;

import com.tutorial.struts.action.AbstractAction;
import com.tutorial.struts.bean.dto.Game;
import com.tutorial.struts.exception.GameException;
import com.tutorial.struts.service.game.GameService;

public class DisplayGameListAction extends AbstractAction {

	private static final long serialVersionUID = -8898371186242307450L;

	final GameService gameService = new GameService();
	
	private List<Game> listGame;
	
	public String execute() {
		
		try {
			listGame = gameService.getGamesWithDevelopperAndCountry();
			
		} catch (GameException exception) {
			return ERROR;
		}
			
		// S'il n'y a pas d'erreurs, on retourne le forward "succes"
		return SUCCESS;
	}
	
	public List<Game> getListGame() {
		return listGame;
	}

}
