package com.jrdev.ps.resurces;

import java.io.IOException;
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
	
	@GetMapping(value = "/calculardistancia/{id}")
	public ResponseEntity<Double> calcularDistancia(@PathVariable Long id) throws IOException {
		Entrevista obj = service.findById(id);
		Double valor = service.calcularDistancia(obj);
		return ResponseEntity.ok().body(valor);
	}
	
	@PostMapping
	public ResponseEntity<Entrevista> insert(@RequestBody Entrevista obj) {
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
	public ResponseEntity<Entrevista> update(@PathVariable Long id, @RequestBody Entrevista obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
