package com.tutorial.game.dao.impl.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.constant.BaseTableName;
import com.tutorial.game.bean.dto.user.Manager;
import com.tutorial.game.dao.contract.user.IManagerDao;
import com.tutorial.game.dao.impl.AbstractDAO;

@Repository
public class ManagerDao extends AbstractDAO<Manager> implements IManagerDao {
	
	@Override
	protected void setTypeParameterClass() {
		typeParameterClass = Manager.class;
	}

	@Override
	public List<Manager> findAll() {
		return findAll(BaseTableName.TABLE_NAME_MANAGER);
	}
}
