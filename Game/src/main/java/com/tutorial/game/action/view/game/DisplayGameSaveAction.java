package com.tutorial.game.action.view.game;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.bean.dto.IGame;
import com.tutorial.game.bean.form.GameForm;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.game.GameService;

@Namespace(value="/")
@Action("displayGameSave")
@Result(name="success", location="/jsp/gameAdd.jsp")
public class DisplayGameSaveAction extends AbstractAction {

	final GameService gameService = new GameService();
	
	private static final long serialVersionUID = 5257907639559001732L;
	
	private GameForm gameForm = new GameForm();

	public String execute() throws NumberFormatException, GameException {
		
		if (StringUtils.isNotBlank(gameForm.getGameId())) {
			IGame game = gameService.getGameWithDevelopperAndCountry(Integer.parseInt(gameForm.getGameId()));	
		
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
