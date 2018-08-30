package com.tutorial.game.action.view.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.tutorial.game.action.AbstractAction;
import com.tutorial.game.bean.dto.IGame;
import com.tutorial.game.bean.dto.impl.DevUser;
import com.tutorial.game.bean.dto.impl.ManagerUser;
import com.tutorial.game.bean.dto.impl.User;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.game.GameService;

@Namespace(value="/")
@Action("displayGameList")
@Result(name="success", location="/jsp/gameList.jsp")
public class DisplayGameListAction extends AbstractAction {

	private static final long serialVersionUID = -8898371186242307450L;

	final GameService gameService = new GameService();
	
	private List<IGame> listGame;
	
	private List<IGame> listGameTest;

	private List<IGame> listGameTemp = new ArrayList<IGame>();

	public String execute() throws GameException {
		
		User user = new User();
		
		user.setName("Dev");
		
		DevUser devUser = null;
		ManagerUser managerUser = null;
		
		if (user.getName().equals("Dev")) {
			
			devUser = new DevUser(user);
			managerUser = new ManagerUser(user);
			
			listGameTest = new ArrayList<IGame>();
			
			listGame = managerUser.getGames();
			listGameTemp = new ArrayList<IGame>(listGame);
			
			Stream<IGame> gameStream = listGame.stream();
			
			gameStream = gameStream.filter( (game) -> game.getName().contains("test") );
			
			gameStream.forEach((game) -> {
											listGameTest.add(game);
											listGameTemp.remove(game);
										 });
			
			listGame = listGameTemp;
		} else {
			listGame = user.getGames();
		}
		
		// S'il n'y a pas d'erreurs, on retourne le forward "succes"
		return SUCCESS;
	}
	
	public List<IGame> getListGame() {
		return listGame;
	}
	
	
	public List<IGame> getListGameTest() {
		return listGameTest;
	}

}
