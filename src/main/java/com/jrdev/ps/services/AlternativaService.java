package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.Alternativa;
import com.jrdev.ps.repositories.AlternativaRepository;
import com.jrdev.ps.services.exceptions.DatabaseException;
import com.jrdev.ps.services.exceptions.ResourceNotFoundException;

@Service
public class AlternativaService {

	@Autowired
	private AlternativaRepository repository;

	public List<Alternativa> findAll() {
		return repository.findAll();
	}

	public Alternativa findById(Long id) {
		Optional<Alternativa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public Alternativa insert(Alternativa obj) {
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

	public Alternativa update(Long id, Alternativa obj) {
		Alternativa entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Alternativa entity, Alternativa obj) {
		entity.setDescricao(obj.getDescricao());
	}

}
