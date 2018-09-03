package com.tutorial.game.dao.impl.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tutorial.game.bean.constant.BaseTableName;
import com.tutorial.game.bean.dto.user.Employe;
import com.tutorial.game.dao.contract.user.IEmployeDao;
import com.tutorial.game.dao.impl.AbstractDAO;

@Repository
public class EmployeDao extends AbstractDAO<Employe> implements IEmployeDao {
	
	@Override
	protected void setTypeParameterClass() {
		typeParameterClass = Employe.class;
	}

	@Override
	public List<Employe> findAll() {
		return findAll(BaseTableName.TABLE_NAME_EMPLOYE);
	}
}
