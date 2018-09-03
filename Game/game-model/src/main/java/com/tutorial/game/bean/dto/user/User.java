package com.tutorial.game.bean.dto.user;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import com.tutorial.game.bean.constant.BaseColumnName;
import com.tutorial.game.bean.constant.BaseTableName;

@Table(name=BaseTableName.TABLE_NAME_USER)
@MappedSuperclass
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name=BaseColumnName.COLUMN_NAME_ID)
	private int id;
	
	@Column(name=BaseColumnName.COLUMN_NAME_USER_FIRST_NAME, nullable=false)
	private String firstName;
	
	@Column(name=BaseColumnName.COLUMN_NAME_USER_LAST_NAME, nullable=false)
	private String lastName;
	
	@Column(name=BaseColumnName.COLUMN_NAME_USER_EMAIL, nullable=false)
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
