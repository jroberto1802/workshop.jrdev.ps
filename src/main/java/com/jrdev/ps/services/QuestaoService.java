package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.Questao;
import com.jrdev.ps.repositories.QuestaoRepository;
import com.jrdev.ps.services.exceptions.DatabaseException;
import com.jrdev.ps.services.exceptions.ResourceNotFoundException;

@Service
public class QuestaoService {
	
	@Autowired
	private QuestaoRepository repository;
	
	public List<Questao> findAll() {
		return repository.findAll();
	}
	
	public Questao findById(Long id) {
		Optional<Questao> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Questao insert(Questao obj) {
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
	
	public Questao update(Long id, Questao obj) {
		Questao entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Questao entity, Questao obj) {
		entity.setProblema(obj.getProblema());
		entity.setQtdPontos(obj.getQtdPontos());
		entity.setTempoResolucaoSeg(obj.getTempoResolucaoSeg());
		entity.setTipoQuestao(obj.getTipoQuestao());
	}
}
