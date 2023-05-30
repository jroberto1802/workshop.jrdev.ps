package com.jrdev.ps.resurces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrdev.ps.entities.CadastroPDV;
import com.jrdev.ps.services.CadastroPDVService;

@RestController
@RequestMapping(value="/pdvs")
public class CadastroPDVResurce {
	
	@Autowired
	private CadastroPDVService service;
	
	@GetMapping
	public ResponseEntity<List<CadastroPDV>> findAll() {
		List<CadastroPDV> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CadastroPDV> findById(@PathVariable Long id) {
		CadastroPDV obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
