package com.apibucket.loginapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apibucket.loginapi.model.Users;

public interface UsersJpaRepository extends JpaRepository<Users, Long> {

	public Optional<Users> findByName(String userName);
}
