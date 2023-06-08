package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.Entrevista;
import com.jrdev.ps.repositories.EntrevistaRepository;

@Service
public class EntrevistaService {
	
	@Autowired
	private EntrevistaRepository entrevistaRepository;
	
	public List<Entrevista> findAll() {
		return entrevistaRepository.findAll();
	}
	
	public Entrevista findById(Long id) {
		Optional<Entrevista> obj = entrevistaRepository.findById(id);
		return obj.get();
	}
	
	public Entrevista associarQuestionario(Long entrevistaId, Long questionarioId) {
        Entrevista entrevista = entrevistaRepository.findById(entrevistaId).orElseThrow(() -> new IllegalArgumentException("Entrevista não encontrada"));
        
        Questionario questionario = entrevistaRepository.findById(questionarioId).orElseThrow(() -> new IllegalArgumentException("Questionário não encontrado"));
        
        entrevista.setQuestionario(questionario);
        
        return entrevistaRepository.save(entrevista);
    }
}
