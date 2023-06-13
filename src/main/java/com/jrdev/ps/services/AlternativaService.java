package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.Alternativa;
import com.jrdev.ps.repositories.AlternativaRepository;

@Service
public class AlternativaService {
	
	@Autowired
	private AlternativaRepository repository;
	
	public List<Alternativa> findAll() {
		return repository.findAll();
	}
	
	public Alternativa findById(Long id) {
		Optional<Alternativa> obj = repository.findById(id);
		return obj.get();
	}
	
}
