package com.jrdev.ps.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jrdev.ps.entities.CadastroPDV;
import com.jrdev.ps.entities.Candidato;
import com.jrdev.ps.entities.Entrevista;
import com.jrdev.ps.entities.ProcessoSeletivo;
import com.jrdev.ps.entities.enums.Status;
import com.jrdev.ps.entities.enums.TipoVaga;
import com.jrdev.ps.entities.enums.Turno;
import com.jrdev.ps.repositories.CadastroPDVRepository;
import com.jrdev.ps.repositories.CandidatoRepository;
import com.jrdev.ps.repositories.EntrevistaRepository;
import com.jrdev.ps.repositories.ProcessoSeletivoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private CadastroPDVRepository cadastroPDVRepository;
	
	@Autowired
	private ProcessoSeletivoRepository processoSeletivoRepository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private EntrevistaRepository entrevistaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		CadastroPDV pdv1 = new CadastroPDV(null, "João Pessoa", 58030021);
		CadastroPDV pdv2 = new CadastroPDV(null, "Recife", 52041080);
		CadastroPDV pdv3 = new CadastroPDV(null, "Goiânia", 74175050);
		
		cadastroPDVRepository.saveAll(Arrays.asList(pdv1, pdv2, pdv3));
		
		ProcessoSeletivo ps1 = new ProcessoSeletivo(null, Instant.parse("2023-05-30T18:01:00Z"), "Goiânia-2023.3", 2, TipoVaga.ESTAGIO, Turno.MANHA_TARDE, pdv3);
		ProcessoSeletivo ps2 = new ProcessoSeletivo(null, Instant.parse("2023-05-31T08:00:00Z"), "Recife-2023.1", 1, TipoVaga.ESTAGIO, Turno.MANHA, pdv2);
		
		processoSeletivoRepository.saveAll(Arrays.asList(ps1, ps2));
		
		Candidato c1 = new Candidato(null, 83988264564L, "PEDRO HENRIQUE PORTELA DE SOUSA", 19, "Rua Narayola, Qd. 34 lote 1/21", 74915235, "Goiânia", "GO", "1º Periodo", Turno.NOITE, Status.EM_PROCESSO);
		Candidato c2 = new Candidato(null, 83988264565L, "GIDEL JOSÉ FERREIRA DA SILVA", 18, "Rua Canavieira, 316", 52150120, "Recife", "PE", "2º Periodo", Turno.NOITE, Status.EM_PROCESSO);
		Candidato c3 = new Candidato(null, 83988264562L, "MATHEUS DIOGO DA SILVA", 21, "R. 1 Q 3, 170 - St. Central", 74013010, "Goiânia", "GO", "1º Periodo", Turno.MANHA, Status.EM_PROCESSO);
		
		candidatoRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Entrevista ent1 = new Entrevista(null, Instant.parse("2023-05-31T09:00:00Z"), 8.0, 9.0, 8.0, 9.0, ps1, c1);
		Entrevista ent2 = new Entrevista(null, Instant.parse("2023-06-01T09:00:00Z"), 9.0, 9.0, 9.0, 10.0, ps2, c2);
		Entrevista ent3 = new Entrevista(null, Instant.parse("2023-05-31T09:00:00Z"), 8.0, 9.0, 8.0, 9.0, ps1, c3);
		
		entrevistaRepository.saveAll(Arrays.asList(ent1, ent2, ent3));

		ps1.agendarEntrevista(ent1);
		ps1.agendarEntrevista(ent3);
		ps2.agendarEntrevista(ent2);
		
		processoSeletivoRepository.saveAll(Arrays.asList(ps1, ps2));
	}
}
