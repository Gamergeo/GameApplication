package com.tutorial.game.bean.dto.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.tutorial.game.bean.constant.BaseColumnName;
import com.tutorial.game.bean.constant.BaseTableName;

@Entity
@Table(name=BaseTableName.TABLE_NAME_EMPLOYE)
public class Employe extends User {
	
	@NaturalId
	@Column(name=BaseColumnName.COLUMN_NAME_EMPLOYE_NUM_EMPLOYE, nullable=false)
	private String num;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}
}
