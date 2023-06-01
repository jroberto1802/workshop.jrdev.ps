package com.jrdev.ps.resurces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrdev.ps.entities.ProcessoSeletivo;
import com.jrdev.ps.services.ProcessoSeletivoService;

@RestController
@RequestMapping(value="/ps")
public class ProcessoSeletivoResurce {
	
	@Autowired
	private ProcessoSeletivoService service;
	
	@GetMapping
	public ResponseEntity<List<ProcessoSeletivo>> findAll() {
		List<ProcessoSeletivo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProcessoSeletivo> findById(@PathVariable Long id) {
		ProcessoSeletivo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
