package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.Questao;
import com.jrdev.ps.repositories.QuestaoRepository;

@Service
public class QuestaoService {
	
	@Autowired
	private QuestaoRepository repository;
	
	public List<Questao> findAll() {
		return repository.findAll();
	}
	
	public Questao findById(Long id) {
		Optional<Questao> obj = repository.findById(id);
		return obj.get();
	}
	
}
