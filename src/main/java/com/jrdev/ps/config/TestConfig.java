package com.jrdev.ps.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jrdev.ps.entities.CadastroPDV;
import com.jrdev.ps.repositories.CadastroPDVRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private CadastroPDVRepository cadastroPDVRepository;

	@Override
	public void run(String... args) throws Exception {
		
		CadastroPDV pdv = new CadastroPDV(null, "João Pessoa", 58030021);
		CadastroPDV pdv2 = new CadastroPDV(null, "Recife", 52041080);
		
		cadastroPDVRepository.saveAll(Arrays.asList(pdv, pdv2));
	}
}
