package com.mezen.camion.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mezen.camion.entities.Marque;

public interface MarqueRepository extends JpaRepository<Marque, Long> {

}
