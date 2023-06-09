package com.jrdev.ps.resurces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrdev.ps.entities.Questao;
import com.jrdev.ps.services.QuestaoService;

@RestController
@RequestMapping(value="/questoes")
public class QuestaoResurce {
	
	@Autowired
	private QuestaoService service;
	
	@GetMapping
	public ResponseEntity<List<Questao>> findAll() {
		List<Questao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Questao> findById(@PathVariable Long id) {
		Questao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
