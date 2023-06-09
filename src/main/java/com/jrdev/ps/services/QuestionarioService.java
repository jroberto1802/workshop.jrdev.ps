package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.Questionario;
import com.jrdev.ps.repositories.QuestionarioRepository;

@Service
public class QuestionarioService {
	
	@Autowired
	private QuestionarioRepository repository;
	
	public List<Questionario> findAll() {
		return repository.findAll();
	}
	
	public Questionario findById(Long id) {
		Optional<Questionario> obj = repository.findById(id);
		return obj.get();
	}
	
}