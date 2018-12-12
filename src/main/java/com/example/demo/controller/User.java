package com.example.demo.controller;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private Integer id;
	private String username;
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User(Integer id, String username, Date date) {
		super();
		this.id = id;
		this.username = username;
		this.date = date;
	}

}
