package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.ProcessoSeletivo;
import com.jrdev.ps.repositories.ProcessoSeletivoRepository;

@Service
public class ProcessoSeletivoService {
	
	@Autowired
	private ProcessoSeletivoRepository repository;
	
	public List<ProcessoSeletivo> findAll() {
		return repository.findAll();
	}
	
	public ProcessoSeletivo findById(Long id) {
		Optional<ProcessoSeletivo> obj = repository.findById(id);
		return obj.get();
	}
	
}
