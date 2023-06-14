package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.Candidato;
import com.jrdev.ps.repositories.CandidatoRepository;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository repository;
	
	public List<Candidato> findAll() {
		return repository.findAll();
	}
	
	public Candidato findById(Long id) {
		Optional<Candidato> obj = repository.findById(id);
		return obj.get();
	}
	
	public Candidato insert(Candidato obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Candidato update(Long id, Candidato obj) {
		Candidato entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Candidato entity, Candidato obj) {
		entity.setCep(obj.getCep());
		entity.setCidade(obj.getCidade());
		entity.setFone(obj.getFone());
		entity.setIdade(obj.getIdade());
		entity.setLogradouro(obj.getLogradouro());
		entity.setNomeCompleto(obj.getNomeCompleto());
		entity.setPeriodoAtual(obj.getPeriodoAtual());
		entity.setStatus(obj.getStatus());
		entity.setTurnoFaculdade(obj.getTurnoFaculdade());
		entity.setUf(obj.getUf());
	}
	
}
