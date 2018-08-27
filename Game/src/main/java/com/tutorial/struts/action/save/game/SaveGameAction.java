package com.tutorial.struts.action.save.game;

import com.tutorial.struts.action.AbstractAction;
import com.tutorial.struts.bean.form.GameForm;
import com.tutorial.struts.exception.GameException;
import com.tutorial.struts.service.game.GameService;

public class SaveGameAction extends AbstractAction {
	
	final GameService gameService = new GameService();
	
	public String execute() {
		
		GameForm gameForm = (GameForm) null;
		
		try {
			gameService.createANewGame(gameForm.getGameName(), gameForm.getDevName(), gameForm.getCountryName());
			
		} catch (GameException exception) {
			//request.setAttribute("ERROR_MESSAGE", exception.getErrorMessage());
			//return mapping.findForward("error");
		}
			
		// S'il n'y a pas d'erreurs, on retourne le forward "succes"
		//return mapping.findForward("success");
		return SUCCESS;
	}

}
