package com.tutorial.game.dao.impl.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.constant.BaseTableName;
import com.tutorial.game.bean.dto.user.Client;
import com.tutorial.game.dao.contract.user.IClientDao;
import com.tutorial.game.dao.impl.AbstractDAO;

@Repository
public class ClientDao extends AbstractDAO<Client> implements IClientDao {
	
	@Override
	protected void setTypeParameterClass() {
		typeParameterClass = Client.class;
	}

	@Override
	public List<Client> findAll() {
		return findAll(BaseTableName.TABLE_NAME_CLIENT);
	}
}
