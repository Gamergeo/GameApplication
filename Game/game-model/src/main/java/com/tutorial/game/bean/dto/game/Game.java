package com.tutorial.game.bean.dto.game;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import com.tutorial.game.bean.constant.BaseColumnName;
import com.tutorial.game.bean.constant.BaseTableName;
import com.tutorial.game.bean.dto.order.Order;
import com.tutorial.game.bean.dto.user.Client;
import com.tutorial.game.bean.dto.user.Employe;
import com.tutorial.game.bean.dto.user.Manager;

@Entity(name=BaseTableName.TABLE_NAME_GAME)
@Table(name=BaseTableName.TABLE_NAME_GAME)
public class Game implements Serializable {

	private static final long serialVersionUID = -494900350388110375L;
	
	@Id
	@Column(name=BaseColumnName.COLUMN_NAME_ID)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	@NaturalId
	@Column(name=BaseColumnName.COLUMN_NAME_GAME_NAME)
	protected String name;
	
	@ManyToOne
	@JoinColumn(name=BaseColumnName.COLUMN_NAME_GAME_MANAGER_ID, referencedColumnName=BaseColumnName.COLUMN_NAME_ID)
	private Manager manager;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name=BaseTableName.TABLE_NAME_DEV_GAME,
	        joinColumns = @JoinColumn(name = BaseColumnName.COLUMN_NAME_DEV_GAME_EMPLOYE_ID),
	        inverseJoinColumns = @JoinColumn(name = BaseColumnName.COLUMN_NAME_DEV_GAME_GAME_ID))
	private Set<Employe> developpers;
	
	@OneToMany(mappedBy="game")
	private Set<Order> orders;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name=BaseTableName.TABLE_NAME_ORDER_GAME,
	        joinColumns = @JoinColumn(name = BaseColumnName.COLUMN_NAME_ORDER_GAME_CLIENT_ID),
	        inverseJoinColumns = @JoinColumn(name = BaseColumnName.COLUMN_NAME_ORDER_GAME_GAME_ID))
	private Set<Client> clients;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Set<Employe> getDeveloppers() {
		return developpers;
	}

	public void setDeveloppers(Set<Employe> developpers) {
		this.developpers = developpers;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
}
