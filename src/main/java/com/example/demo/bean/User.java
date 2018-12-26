package com.example.demo.bean;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class User implements Serializable {

	private Integer id;
	private String username;
	private Integer age;
	private String sex;
	private String password;
	private Date createTime;

	public User(Integer id, String username, Integer age, String sex, Date createTime) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.sex = sex;
		this.createTime = createTime;
		this.password = "123456";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
