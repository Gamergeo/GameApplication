package com.tutorial.struts.action.view.game;

import com.tutorial.struts.action.AbstractAction;

public class DisplayGameSaveAction extends AbstractAction {
	
	public String execute() {
		
		// S'il n'y a pas d'erreurs, on retourne le forward "succes"
		//return mapping.findForward("success");
		return SUCCESS;
	}

}
