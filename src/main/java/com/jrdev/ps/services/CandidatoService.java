package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.Candidato;
import com.jrdev.ps.repositories.CandidatoRepository;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository repository;
	
	public List<Candidato> findAll() {
		return repository.findAll();
	}
	
	public Candidato findById(Long id) {
		Optional<Candidato> obj = repository.findById(id);
		return obj.get();
	}
	
}
