package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.CadastroPDV;
import com.jrdev.ps.repositories.CadastroPDVRepository;
import com.jrdev.ps.services.exceptions.DatabaseException;
import com.jrdev.ps.services.exceptions.ResourceNotFoundException;

@Service
public class CadastroPDVService {
	
	@Autowired
	private CadastroPDVRepository repository;
	
	public List<CadastroPDV> findAll() {
		return repository.findAll();
	}
	
	public CadastroPDV findById(Long id) {
		Optional<CadastroPDV> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public CadastroPDV insert(CadastroPDV obj) {
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
	
	public CadastroPDV update(Long id, CadastroPDV obj) {
		CadastroPDV entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(CadastroPDV entity, CadastroPDV obj) {
		entity.setNome(obj.getNome());
		entity.setCep(obj.getCep());
	}
}
