package com.tutorial.game.bean.dto.user;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tutorial.game.bean.constant.BaseColumnName;
import com.tutorial.game.bean.constant.BaseTableName;
import com.tutorial.game.bean.dto.order.Order;

@Entity(name=BaseTableName.TABLE_NAME_CLIENT)
@Table(name=BaseTableName.TABLE_NAME_CLIENT)
public class Client extends User implements Serializable {
	
	private static final long serialVersionUID = 496156828554576383L;

	@Column(name=BaseColumnName.COLUMN_NAME_CLIENT_NUM_CLIENT, nullable=false, unique=true)
	private String num;
	
	@OneToMany(mappedBy="game")
	private Set<Order> orders;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
