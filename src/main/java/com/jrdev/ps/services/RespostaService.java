package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.Resposta;
import com.jrdev.ps.repositories.RespostaRepository;
import com.jrdev.ps.services.exceptions.ResourceNotFoundException;

@Service
public class RespostaService {
	
	@Autowired
	private RespostaRepository repository;
	
	public List<Resposta> findAll() {
		return repository.findAll();
	}
	
	public Resposta findById(Long id) {
		Optional<Resposta> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Resposta insert(Resposta obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Resposta update(Long id, Resposta obj) {
		Resposta entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Resposta entity, Resposta obj) {
		entity.setDescricao(obj.getDescricao());
		entity.setInicioResposta(obj.getInicioResposta());
		entity.setFinalResposta(obj.getFinalResposta());
	}
}
