package com.jrdev.ps.resurces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrdev.ps.entities.Candidato;
import com.jrdev.ps.services.CandidatoService;

@RestController
@RequestMapping(value="/candidatos")
public class CandidatoResurce {
	
	@Autowired
	private CandidatoService service;
	
	@GetMapping
	public ResponseEntity<List<Candidato>> findAll() {
		List<Candidato> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Candidato> findById(@PathVariable Long id) {
		Candidato obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
