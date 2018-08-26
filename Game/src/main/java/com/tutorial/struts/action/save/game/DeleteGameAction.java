package com.tutorial.struts.action.save.game;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tutorial.struts.bean.form.GameForm;
import com.tutorial.struts.exception.GameException;
import com.tutorial.struts.service.game.GameService;

public class DeleteGameAction extends Action {
	
	final GameService gameService = new GameService();
	
	public ActionForward execute(final ActionMapping mapping, ActionForm form, final HttpServletRequest request, 
			final HttpServletResponse response) {
		
		GameForm gameForm = (GameForm) form;
		
		try {
			gameService.deleteGame(gameForm.getGameId());
		} catch (GameException exception) {
			request.setAttribute("ERROR_MESSAGE", exception.getErrorMessage());
			return mapping.findForward("error");
		}
		
			
		// S'il n'y a pas d'erreurs, on retourne le forward "succes"
		return mapping.findForward("success");
	}

}
