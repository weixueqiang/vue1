package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User(0, "张三", new Date()));
		users.add(new User(1, "李四", new Date()));
	}

	@RequestMapping("list")
	public CallResult list() {
		return CallResult.ok(users);
	}

	@RequestMapping("save")
	public CallResult save(User user) {
		user.setId(users.size());
		user.setDate(new Date());
		users.add(user);
		return CallResult.ok();
	}

	@RequestMapping("delete")
	public CallResult delete(Integer id) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				users.remove(i);
				break;
			}
		}
		return CallResult.ok();
	}

}
