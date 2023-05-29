package com.jrdev.ps.resurces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrdev.ps.entities.CadastroPDV;

@RestController
@RequestMapping(value="/pdvs")
public class CadastroPDVResurce {
	
	@GetMapping
	public ResponseEntity<CadastroPDV> findAll() {
		CadastroPDV pdv = new CadastroPDV(1L, "João Pessoa", 58030021);
		return ResponseEntity.ok().body(pdv);
	}
}
