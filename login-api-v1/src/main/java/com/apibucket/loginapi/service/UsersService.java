package com.apibucket.loginapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apibucket.loginapi.model.Roles;
import com.apibucket.loginapi.model.Users;
import com.apibucket.loginapi.repository.UsersJpaRepository;

@Service
public class UsersService {

	@Autowired
	private UsersJpaRepository usersJpaRepository;
	
	public void create(String name,String pwd,String role)
	{
		Users entity=new Users();
		entity.setName(name);
		entity.setPassword(getBCryptPasswordEncoder().encode(pwd));
		Roles roles=new Roles();
		roles.setRole(role);
		entity.addRoles(roles);
		usersJpaRepository.save(entity);
	}
	
//	@IsUser
//	@PreAuthorize("hasRole('ADMIN')")
	public Optional<Users> findByName(String userName)
	{
		return usersJpaRepository.findByName(userName);
		
	}
	
	@Bean
	public BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
