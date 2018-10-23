package com.apibucket.loginapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apibucket.loginapi.model.Roles;

public interface RolesJpaRepository extends JpaRepository<Roles, Long> {

	public Optional<Roles> findByRole(String role);
}
