package com.tutorial.struts.action.view.game;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tutorial.struts.exception.GameException;
import com.tutorial.struts.service.game.GameService;

public class DisplayGameListAction extends Action {
	
	final GameService gameService = new GameService();
	
	public ActionForward execute(final ActionMapping mapping, ActionForm form, final HttpServletRequest request, 
			final HttpServletResponse response) {
		
		try {
			// Stocke les informations dans la requête
			request.setAttribute("GAME_LIST", gameService.getGamesWithDevelopperAndCountry());
			
		} catch (GameException exception) {
			request.setAttribute("ERROR_MESSAGE", exception.getErrorMessage());
			return mapping.findForward("error");
		}
			
		// S'il n'y a pas d'erreurs, on retourne le forward "succes"
		return mapping.findForward("success");
	}

}
