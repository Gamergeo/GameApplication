package com.tutorial.struts.action.view.game;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
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
	
	private Set<IGame> listGame;
	
	private Set<IGame> listGameTest;

	private Set<IGame> listGameTemp = new HashSet<IGame>();
	
	public String execute() throws GameException {
		
		User user = new User();
		
		user.setName("Dev");
		
		DevUser devUser = null;
		ManagerUser managerUser = null;
		
		if (user.getName().equals("Dev")) {
			
			devUser = new DevUser(user);
			managerUser = new ManagerUser(user);
			
			listGameTest = new HashSet<IGame>();
			
			listGame = managerUser.getGames();
			listGameTemp = new HashSet<IGame>(listGame);
			
			Stream<IGame> gameStream = listGame.stream();
			
			gameStream = gameStream.filter( (game) -> game.getName().contains("test") );
			
			Consumer<IGame> consumeGame = new Consumer<IGame>() {
	
				@Override
				public void accept(IGame game) {
					listGameTest.add(game);
					listGameTemp.remove(game);
				}
			};
			
			gameStream.forEach(consumeGame);
			
			listGame = listGameTemp;
		} else {
			listGame = user.getGames();
		}
		
		// S'il n'y a pas d'erreurs, on retourne le forward "succes"
		return SUCCESS;
	}
	
	public Set<IGame> getListGame() {
		return listGame;
	}
	
	
	public Set<IGame> getListGameTest() {
		return listGameTest;
	}

}
