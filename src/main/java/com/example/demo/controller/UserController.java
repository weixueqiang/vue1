package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.CallResult;
import com.example.demo.bean.User;

@RestController
@RequestMapping("/user")
public class UserController {

	static List<User> users = new ArrayList<User>();
	static {
		users.add(new User(0, "张三", 12, "男", new Date()));
		users.add(new User(1, "李四", 13, "男", new Date()));
		users.add(new User(2, "梅梅", 15, "女", new Date()));
	}

	@RequestMapping("list")
	public CallResult list() {

		// return CallResult.err("错误测试");
		return CallResult.ok(users);
	}

	@RequestMapping("save")
	public CallResult save(User user) {
		if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getSex()) || user.getAge() == null) {
			return CallResult.err("请正确填写数据");
		}
		if (user.getId() == null) {
			user.setId(users.size());
			user.setCreateTime(new Date());
			user.setPassword("123456");
			users.add(user);
		} else {
			for (int i = 0; i < users.size(); i++) {
				if (users.get(i).getId() == user.getId()) {
					users.remove(i);
					user.setCreateTime(new Date());
					users.add(i, user);
					break;
				}
			}
		}
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

	@RequestMapping("get")
	public CallResult save(Integer id) {
		if (id == null) {
			return CallResult.err("请正确填写数据");
		}
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				return CallResult.ok(users.get(i));
			}
		}
		return CallResult.ok();
	}

	@RequestMapping("login")
	public CallResult login(User user) {
		if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
			return CallResult.err("请正确填写数据");
		}
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(user.getUsername())
					&& users.get(i).getPassword().equals(user.getPassword())) {
				return CallResult.ok();
			}
		}
		return CallResult.err("用户名或密码错误");
	}

	@RequestMapping("register")
	public CallResult register(User user) {
		if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
			return CallResult.err("请正确填写数据");
		}
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUsername().equals(user.getUsername())
					&& users.get(i).getPassword().equals(user.getPassword())) {
				return CallResult.ok();
			}
		}
		return CallResult.err("用户名或密码错误");
	}

}
