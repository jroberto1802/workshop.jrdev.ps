package com.jrdev.ps.resurces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrdev.ps.entities.Alternativa;
import com.jrdev.ps.services.AlternativaService;

@RestController
@RequestMapping(value="/alternativas")
public class AlternativaResurce {
	
	@Autowired
	private AlternativaService service;
	
	@GetMapping
	public ResponseEntity<List<Alternativa>> findAll() {
		List<Alternativa> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Alternativa> findById(@PathVariable Long id) {
		Alternativa obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
