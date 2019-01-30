package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ServletComponentScan
@MapperScan("com.example.demo.mapper")
public class VueApplication {

	public static void main(String[] args) {
		SpringApplication.run(VueApplication.class, args);
	}

}
