package com.mezen.camion.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mezen.camion.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
Role findByRole(String role);
}