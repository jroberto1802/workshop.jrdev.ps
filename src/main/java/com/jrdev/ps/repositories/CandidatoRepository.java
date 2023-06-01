package com.jrdev.ps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrdev.ps.entities.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Long>{
	
}
