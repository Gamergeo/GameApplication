package com.tutorial.game.action.view.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.bean.dto.game.IGame;
import com.tutorial.game.bean.dto.user.IUser;
import com.tutorial.game.bean.dto.user.impl.User;
import com.tutorial.game.constants.GameConstants;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.game.IGameService;

@Namespace(value="/")
@Action("displayGameList")
@Result(name="success", location="/jsp/gameList.jsp")
public class DisplayGameListAction extends AbstractAction {

	private static final long serialVersionUID = -8898371186242307450L;
	
	private static IGameService gameService;
	
	private List<IGame> listGame;
	
	private List<IGame> listGameTest = new ArrayList<IGame>();

	public String execute() throws GameException {
		
		IUser user = new User();
		user.setName(GameConstants.USER_NAME_MANAGER);
		
		listGame = gameService.getDisplayedGames(user);
		
		if (user.isDevUser() || user.isManagerUser()) {
			List<IGame> listGameTemp = new ArrayList<IGame>(listGame);
			
			Stream<IGame> gameStream = listGame.stream();
			
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
	
	public static void setGameService(IGameService gameService) {
		DisplayGameListAction.gameService = gameService;
	}

	public List<IGame> getListGame() {
		return listGame;
	}
	
	
	public List<IGame> getListGameTest() {
		return listGameTest;
	}

}
