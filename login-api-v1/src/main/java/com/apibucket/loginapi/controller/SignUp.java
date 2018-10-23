package com.apibucket.loginapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apibucket.loginapi.service.UsersService;

@RestController
@RequestMapping("/login/signup")
public class SignUp {

	@Autowired
	private UsersService usersService;
	
	@PostMapping("/create")
	public void createUser(@RequestParam(value="user")String name,@RequestParam(value="pwd")String pwd,@RequestParam(value="role")String role)
	{
		System.out.println("/create");
		usersService.create(name, pwd, role);
	}
}
