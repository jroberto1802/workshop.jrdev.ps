package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.ProcessoSeletivo;
import com.jrdev.ps.repositories.ProcessoSeletivoRepository;
import com.jrdev.ps.services.exceptions.DatabaseException;
import com.jrdev.ps.services.exceptions.ResourceNotFoundException;

@Service
public class ProcessoSeletivoService {
	
	@Autowired
	private ProcessoSeletivoRepository repository;
	
	public List<ProcessoSeletivo> findAll() {
		return repository.findAll();
	}
	
	public ProcessoSeletivo findById(Long id) {
		Optional<ProcessoSeletivo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public ProcessoSeletivo insert(ProcessoSeletivo obj) {
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
	
	public ProcessoSeletivo update(Long id, ProcessoSeletivo obj) {
		ProcessoSeletivo entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(ProcessoSeletivo entity, ProcessoSeletivo obj) {
		entity.setDataInicio(obj.getDataInicio());
		entity.setNome(obj.getNome());
		entity.setPdv(obj.getPdv());
		entity.setQtdVagas(obj.getQtdVagas());
		entity.setTipoVaga(obj.getTipoVaga());
		entity.setTurnoVaga(obj.getTurnoVaga());
	}
}
