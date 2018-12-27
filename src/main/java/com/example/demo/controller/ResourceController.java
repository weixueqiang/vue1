package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.CallResult;
import com.example.demo.bean.Resource;

@RestController
@RequestMapping("/user/resource")
public class ResourceController {

	@RequestMapping("/list")
	public CallResult list() {
		return CallResult.ok(Resource.getTree());
	}

}
