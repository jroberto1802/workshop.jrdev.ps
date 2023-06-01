package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.Entrevista;
import com.jrdev.ps.repositories.EntrevistaRepository;

@Service
public class EntrevistaService {
	
	@Autowired
	private EntrevistaRepository repository;
	
	public List<Entrevista> findAll() {
		return repository.findAll();
	}
	
	public Entrevista findById(Long id) {
		Optional<Entrevista> obj = repository.findById(id);
		return obj.get();
	}
	
}
