package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.Resposta;
import com.jrdev.ps.repositories.RespostaRepository;

@Service
public class RespostaService {
	
	@Autowired
	private RespostaRepository repository;
	
	public List<Resposta> findAll() {
		return repository.findAll();
	}
	
	public Resposta findById(Long id) {
		Optional<Resposta> obj = repository.findById(id);
		return obj.get();
	}
	
}
