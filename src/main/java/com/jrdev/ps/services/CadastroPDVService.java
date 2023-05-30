package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.CadastroPDV;
import com.jrdev.ps.repositories.CadastroPDVRepository;

@Service
public class CadastroPDVService {
	
	@Autowired
	private CadastroPDVRepository repository;
	
	public List<CadastroPDV> findAll() {
		return repository.findAll();
	}
	
	public CadastroPDV findById(Long id) {
		Optional<CadastroPDV> obj = repository.findById(id);
		return obj.get();
	}
	
}
