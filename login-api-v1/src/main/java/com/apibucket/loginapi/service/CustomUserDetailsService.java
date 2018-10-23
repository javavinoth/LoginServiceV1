package com.apibucket.loginapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apibucket.loginapi.model.Users;
import com.apibucket.loginapi.repository.UsersJpaRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersJpaRepository usersRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Users> users = usersRepository.findByName(username);
		System.out.println("username :"+users.get().getName()+"\t"+"password: "+users.get().getPassword());
		users.orElseThrow(() -> new UsernameNotFoundException(username + "is not found"));
		return users.map(CustomUserDetails::new).get();
	}

}
