package com.tutorial.game.bean.dto.order;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tutorial.game.bean.constant.BaseColumnName;
import com.tutorial.game.bean.constant.BaseTableName;
import com.tutorial.game.bean.dto.game.Game;
import com.tutorial.game.bean.dto.user.Client;

@Entity(name=BaseTableName.TABLE_NAME_ORDER_GAME)
@Table(name=BaseTableName.TABLE_NAME_ORDER_GAME)
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1468441419357566887L;

	@Id
	@Column(name=BaseColumnName.COLUMN_NAME_ORDER_GAME_GAME_ID)
	private int gameId;
	
	@Id
	@Column(name=BaseColumnName.COLUMN_NAME_ORDER_GAME_CLIENT_ID)
	private int clientId;
	
	@Column(name=BaseColumnName.COLUMN_NAME_ORDER_GAME_ORDER_DATE)
	private LocalDate orderDate;
	
	@ManyToOne
	@JoinColumn(name=BaseColumnName.COLUMN_NAME_ORDER_GAME_GAME_ID, referencedColumnName=BaseColumnName.COLUMN_NAME_ID)
	private Game game;

	@ManyToOne
	@JoinColumn(name=BaseColumnName.COLUMN_NAME_ORDER_GAME_CLIENT_ID, referencedColumnName=BaseColumnName.COLUMN_NAME_ID)
	private Client client;

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
