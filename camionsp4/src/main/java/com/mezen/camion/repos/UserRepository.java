package com.mezen.camion.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mezen.camion.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername (String username);
}
