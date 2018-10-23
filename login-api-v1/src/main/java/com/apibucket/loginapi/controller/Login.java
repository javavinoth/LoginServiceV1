package com.apibucket.loginapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apibucket.loginapi.model.Roles;
import com.apibucket.loginapi.model.Users;
import com.apibucket.loginapi.repository.RolesJpaRepository;
import com.apibucket.loginapi.repository.UsersJpaRepository;
import com.apibucket.loginapi.service.UsersService;

@RestController
@RequestMapping("/login")
public class Login {

	@Autowired
	private UsersJpaRepository userJpaRepository;
	@Autowired
	private UsersService usersService;
	
	@Autowired
	private RolesJpaRepository roleJpaRepository;
	
	
	@PostMapping("/get")
	public Optional<Users> get(@RequestParam(value="user")String name)
	{
		System.out.println("COntroller /get");
		return usersService.findByName(name);
	}
	public Optional<Roles> getRole(@RequestParam(value="role")String role)
	{
		Optional<Roles> roles=roleJpaRepository.findByRole(role);
//		System.out.println("getRole: "+role.get().getUsers().getName());
		/*if(role.isPresent())
		{System.out.println(role.get().getUsers().size());
			com.vinoth.login.model.mappings.Roles roles=role.get();
			roles.setUsers(role.get().getUsers());
		}*/
		return roles;
	}
	
	
	
}
