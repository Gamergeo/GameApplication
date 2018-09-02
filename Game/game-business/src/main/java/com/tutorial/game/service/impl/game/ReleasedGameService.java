package com.tutorial.game.service.impl.game;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.bean.dto.game.ReleasedGame;
import com.tutorial.game.exception.GameException;
import com.tutorial.game.service.contract.game.IReleasedGameService;
import com.tutorial.game.service.impl.AbstractService;

@Service
@Transactional
public class ReleasedGameService extends AbstractService implements IReleasedGameService {

	@Override
	@Transactional(readOnly = true)
	public List<ReleasedGame> getReleasedtWithDevelopperAndCountry() throws GameException {
		
		return daoFactory.getReleasedGameDAO().getAllReleasedGameWhitInfos();
	}
	
	@Override
	public void insertReleasedGame(Game game) throws GameException {
		insertReleasedGame(new ReleasedGame(game));
	}
	
	@Override
	@Transactional
	public void insertReleasedGame(ReleasedGame releasedGame) throws GameException {
		daoFactory.getReleasedGameDAO().insertReleasedGame(releasedGame);
	}
}