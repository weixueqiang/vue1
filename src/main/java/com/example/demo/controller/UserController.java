package com.example.demo.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.CallResult;
import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;

@RestController
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserMapper userMapper;

	@RequestMapping("list")
	public CallResult list() {

		// return CallResult.err("错误测试");
		System.out.println("ok...");
		return CallResult.ok();
	}

	@RequestMapping("save")
	public CallResult save(User user) {

		return CallResult.ok();
	}

	@RequestMapping("delete")
	public CallResult delete(Integer id) {

		return CallResult.ok();
	}

	@RequestMapping("get")
	public CallResult save(Integer id) {
		if (id == null) {
			return CallResult.err("请正确填写数据");
		}

		return CallResult.ok();
	}

	@RequestMapping("login")
	public CallResult login(String username, String password) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password, false);
		if (!subject.isAuthenticated()) {
			try {
				subject.login(token);
			} catch (Exception e) {
				return CallResult.err("用户名或密码错误");
			}
		}
		return CallResult.ok();
	}

	@RequestMapping("register")
	public CallResult register(User user) {
		if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())) {
			return CallResult.err("请正确填写数据");
		}

		return CallResult.err("用户名或密码错误");
	}

}
