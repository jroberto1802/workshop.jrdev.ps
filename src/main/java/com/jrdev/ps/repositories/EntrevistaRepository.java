package com.jrdev.ps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrdev.ps.entities.Entrevista;

public interface EntrevistaRepository extends JpaRepository<Entrevista, Long>{
	
}
