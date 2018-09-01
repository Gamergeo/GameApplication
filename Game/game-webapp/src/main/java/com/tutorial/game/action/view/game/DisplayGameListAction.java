package com.tutorial.game.action.view.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.bean.dto.user.User;
import com.tutorial.game.constants.GameConstants;
import com.tutorial.game.exception.GameException;

@Namespace(value="/")
@Action("displayGameList")
@Result(name="success", location="/jsp/gameList.jsp")
@Controller
public class DisplayGameListAction extends AbstractAction {

	private static final long serialVersionUID = -8898371186242307450L;
	
	private List<Game> listGame;
	
	private List<Game> listGameTest = new ArrayList<Game>();

	public String execute() throws GameException {
		
		User user = new User();
		user.setName(GameConstants.USER_NAME_MANAGER);
		
		listGame = serviceFactory.getGameService().getDisplayedGames(user);
		
		if (user.isDevUser() || user.isManagerUser()) {
			List<Game> listGameTemp = new ArrayList<Game>(listGame);
			
			Stream<Game> gameStream = listGame.stream();
			
			gameStream = gameStream.filter( (game) -> game.getName().contains("test") );
			
			gameStream.forEach((game) -> {
											listGameTest.add(game);
											listGameTemp.remove(game);
										 });
			
			listGame = listGameTemp;
		}
		
		// S'il n'y a pas d'erreurs, on retourne le forward "succes"
		return SUCCESS;
	}

	public List<Game> getListGame() {
		return listGame;
	}
	
	
	public List<Game> getListGameTest() {
		return listGameTest;
	}

}
