package com.jrdev.ps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrdev.ps.entities.Questionario;

public interface QuestionarioRepository extends JpaRepository<Questionario, Long>{
	
}
