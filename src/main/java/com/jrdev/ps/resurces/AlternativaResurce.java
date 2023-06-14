package com.jrdev.ps.resurces;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Alternativa> insert(@RequestBody Alternativa obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Alternativa> update(@PathVariable Long id, @RequestBody Alternativa obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
