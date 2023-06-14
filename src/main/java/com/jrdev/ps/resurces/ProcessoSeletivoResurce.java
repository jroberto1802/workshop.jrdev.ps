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
	
	@PostMapping
	public ResponseEntity<ProcessoSeletivo> insert(@RequestBody ProcessoSeletivo obj) {
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
	public ResponseEntity<ProcessoSeletivo> update(@PathVariable Long id, @RequestBody ProcessoSeletivo obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
