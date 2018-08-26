package com.tutorial.struts.action.view.game;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class DisplayGameSaveAction extends Action {
	
	public ActionForward execute(final ActionMapping mapping, ActionForm form, final HttpServletRequest request, 
			final HttpServletResponse response) {
		
		// S'il n'y a pas d'erreurs, on retourne le forward "succes"
		return mapping.findForward("success");
	}

}
