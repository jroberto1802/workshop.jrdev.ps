package com.jrdev.ps.resurces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrdev.ps.entities.Entrevista;
import com.jrdev.ps.services.EntrevistaService;

@RestController
@RequestMapping(value="/entrevistas")
public class EntrevistaResurce {
	
	@Autowired
	private EntrevistaService service;
	
	@GetMapping
	public ResponseEntity<List<Entrevista>> findAll() {
		List<Entrevista> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Entrevista> findById(@PathVariable Long id) {
		Entrevista obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
