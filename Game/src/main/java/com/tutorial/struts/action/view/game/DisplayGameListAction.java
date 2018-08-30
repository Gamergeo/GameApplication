package com.tutorial.struts.action.view.game;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.tutorial.struts.action.AbstractAction;
import com.tutorial.struts.bean.dto.IGame;
import com.tutorial.struts.bean.dto.impl.DevUser;
import com.tutorial.struts.bean.dto.impl.ManagerUser;
import com.tutorial.struts.bean.dto.impl.User;
import com.tutorial.struts.exception.GameException;
import com.tutorial.struts.service.game.GameService;

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
