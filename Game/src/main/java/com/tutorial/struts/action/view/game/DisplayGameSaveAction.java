package com.tutorial.struts.action.view.game;

import org.apache.commons.lang.StringUtils;

import com.tutorial.struts.action.AbstractAction;
import com.tutorial.struts.bean.dto.Game;
import com.tutorial.struts.bean.form.GameForm;
import com.tutorial.struts.exception.GameException;
import com.tutorial.struts.service.game.GameService;

public class DisplayGameSaveAction extends AbstractAction {

	final GameService gameService = new GameService();
	
	private static final long serialVersionUID = 5257907639559001732L;
	
	private GameForm gameForm = new GameForm();

	public String execute() throws NumberFormatException, GameException {
		
		if (StringUtils.isNotBlank(gameForm.getGameId())) {
			Game game = gameService.getGameWithDevelopperAndCountry(Integer.parseInt(gameForm.getGameId()));	
		
			gameForm.setGameName(game.getName());
			gameForm.setDevName(game.getDevelopper().getName());
			gameForm.setCountryName(game.getDevelopper().getCountryNameIfExists());
		}
		
		// S'il n'y a pas d'erreurs, on retourne le forward "succes"
		return SUCCESS;
	}

	public GameForm getGameForm() {
		return gameForm;
	}

	public void setGameForm(GameForm gameForm) {
		this.gameForm = gameForm;
	}

}
