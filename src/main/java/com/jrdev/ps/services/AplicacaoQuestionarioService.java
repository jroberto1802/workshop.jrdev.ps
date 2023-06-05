package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.AplicacaoQuestionario;
import com.jrdev.ps.repositories.AplicacaoQuestionarioRepository;

@Service
public class AplicacaoQuestionarioService {
	
	@Autowired
	private AplicacaoQuestionarioRepository repository;
	
	public List<AplicacaoQuestionario> findAll() {
		return repository.findAll();
	}
	
	public AplicacaoQuestionario findById(Long id) {
		Optional<AplicacaoQuestionario> obj = repository.findById(id);
		return obj.get();
	}
	
}