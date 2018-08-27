package com.tutorial.struts.action.view.game;

import com.tutorial.struts.action.AbstractAction;

public class DisplayGameSaveAction extends AbstractAction {
	
	private static final long serialVersionUID = 5257907639559001732L;

	public String execute() {
		
		// S'il n'y a pas d'erreurs, on retourne le forward "succes"
		return SUCCESS;
	}

}
