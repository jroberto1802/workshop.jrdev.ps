package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.Questionario;
import com.jrdev.ps.repositories.QuestionarioRepository;
import com.jrdev.ps.services.exceptions.DatabaseException;
import com.jrdev.ps.services.exceptions.ResourceNotFoundException;

@Service
public class QuestionarioService {
	
	@Autowired
	private QuestionarioRepository repository;
	
	public List<Questionario> findAll() {
		return repository.findAll();
	}
	
	public Questionario findById(Long id) {
		Optional<Questionario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Questionario insert(Questionario obj) {
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
	
	public Questionario update(Long id, Questionario obj) {
		Questionario entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Questionario entity, Questionario obj) {
		entity.setTitulo(obj.getTitulo());
	}
	
}
