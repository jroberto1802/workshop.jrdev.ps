package com.jrdev.ps.resurces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrdev.ps.entities.AplicacaoQuestionario;
import com.jrdev.ps.services.AplicacaoQuestionarioService;

@RestController
@RequestMapping(value="/apquest")
public class AplicacaoQuestionarioResurce {
	
	@Autowired
	private AplicacaoQuestionarioService service;
	
	@GetMapping
	public ResponseEntity<List<AplicacaoQuestionario>> findAll() {
		List<AplicacaoQuestionario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AplicacaoQuestionario> findById(@PathVariable Long id) {
		AplicacaoQuestionario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
