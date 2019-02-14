package com.example.demo.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.CallResult;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@RequestMapping("/authz")
	public CallResult authz(HttpServletResponse response) {
		CallResult result = new CallResult();
		Subject subject = SecurityUtils.getSubject();
		if (!subject.isAuthenticated()) {
			result.fail("未认证");
			result.setCode(401);
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return result;
		}
		return result;
	}

}
