package com.jrdev.ps.resurces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrdev.ps.entities.Questionario;
import com.jrdev.ps.services.QuestionarioService;

@RestController
@RequestMapping(value="/questionarios")
public class QuestionarioResurce {
	
	@Autowired
	private QuestionarioService service;
	
	@GetMapping
	public ResponseEntity<List<Questionario>> findAll() {
		List<Questionario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Questionario> findById(@PathVariable Long id) {
		Questionario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
