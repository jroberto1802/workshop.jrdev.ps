package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.AplicacaoQuestionario;
import com.jrdev.ps.repositories.AplicacaoQuestionarioRepository;
import com.jrdev.ps.services.exceptions.DatabaseException;
import com.jrdev.ps.services.exceptions.ResourceNotFoundException;

@Service
public class AplicacaoQuestionarioService {
	
	@Autowired
	private AplicacaoQuestionarioRepository repository;
	
	public List<AplicacaoQuestionario> findAll() {
		return repository.findAll();
	}
	
	public AplicacaoQuestionario findById(Long id) {
		Optional<AplicacaoQuestionario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public AplicacaoQuestionario insert(AplicacaoQuestionario obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
}
