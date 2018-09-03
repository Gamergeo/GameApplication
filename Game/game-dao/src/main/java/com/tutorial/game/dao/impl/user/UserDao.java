package com.tutorial.game.dao.impl.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.constant.BaseTableName;
import com.tutorial.game.bean.dto.user.User;
import com.tutorial.game.dao.contract.user.IUserDao;
import com.tutorial.game.dao.impl.AbstractDAO;

@Repository
public class UserDao extends AbstractDAO<User> implements IUserDao {
	
	@Override
	protected void setTypeParameterClass() {
		typeParameterClass = User.class;
	}

	@Override
	public List<User> findAll() {
		return findAll(BaseTableName.TABLE_NAME_USER);
	}
}
