package com.jrdev.ps.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrdev.ps.entities.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long>{
	
}
