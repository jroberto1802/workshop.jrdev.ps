package com.jrdev.ps.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.Entrevista;
import com.jrdev.ps.repositories.EntrevistaRepository;
import com.jrdev.ps.services.exceptions.DatabaseException;
import com.jrdev.ps.services.exceptions.ResourceNotFoundException;


@Service
public class EntrevistaService {
	
	@Autowired
	private EntrevistaRepository repository;
	
	public List<Entrevista> findAll() {
		return repository.findAll();
	}
	
	public Entrevista findById(Long id) {
		Optional<Entrevista> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Double calcularDistancia(Entrevista entrevista) throws IOException {
		return entrevista.getCalcularDistancia(entrevista.getProcesso().getPdv().getCep(), entrevista.getCandidato().getCep());
	}
	
	public Entrevista insert(Entrevista obj) {
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
	
	public Entrevista update(Long id, Entrevista obj) {
		Entrevista entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Entrevista entity, Entrevista obj) {
		entity.setData(obj.getData());
		entity.setDiccao(obj.getDiccao());
		entity.setGirias(obj.getGirias());
		entity.setPontualidade(obj.getPontualidade());
		entity.setPostura(obj.getPostura());
	}
	
}
