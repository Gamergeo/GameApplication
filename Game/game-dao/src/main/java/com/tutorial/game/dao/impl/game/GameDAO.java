package com.tutorial.game.dao.impl.game;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.constant.BaseTableName;
import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.dao.contract.game.IGameDAO;
import com.tutorial.game.dao.impl.AbstractDAO;
import com.tutorial.game.exception.GameException;

@Repository
public class GameDAO extends AbstractDAO<Game> implements IGameDAO {

	@Override
	protected void setTypeParameterClass() {
		this.typeParameterClass = Game.class;
	}
		
	/* (non-Javadoc)
	 * @see com.tutorial.game.dao.game.IGameDAO#getGameByName(java.lang.String)
	 */
	@Override
	public Game getGameByName(String name) throws GameException {
		return getCurrentSession().byNaturalId(Game.class).using("name", name).load();
	}

	@Override
	public List<Game> findAll() {
		return findAll(BaseTableName.TABLE_NAME_GAME);
	}
}
