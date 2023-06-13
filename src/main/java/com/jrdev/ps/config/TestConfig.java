package com.jrdev.ps.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jrdev.ps.entities.Alternativa;
import com.jrdev.ps.entities.AplicacaoQuestionario;
import com.jrdev.ps.entities.CadastroPDV;
import com.jrdev.ps.entities.Candidato;
import com.jrdev.ps.entities.Entrevista;
import com.jrdev.ps.entities.MutiplaEscolha;
import com.jrdev.ps.entities.ProcessoSeletivo;
import com.jrdev.ps.entities.Questao;
import com.jrdev.ps.entities.Questionario;
import com.jrdev.ps.entities.Resposta;
import com.jrdev.ps.entities.enums.Status;
import com.jrdev.ps.entities.enums.TipoQuestao;
import com.jrdev.ps.entities.enums.TipoVaga;
import com.jrdev.ps.entities.enums.Turno;
import com.jrdev.ps.repositories.AplicacaoQuestionarioRepository;
import com.jrdev.ps.repositories.CadastroPDVRepository;
import com.jrdev.ps.repositories.CandidatoRepository;
import com.jrdev.ps.repositories.EntrevistaRepository;
import com.jrdev.ps.repositories.ProcessoSeletivoRepository;
import com.jrdev.ps.repositories.QuestaoRepository;
import com.jrdev.ps.repositories.QuestionarioRepository;
import com.jrdev.ps.repositories.RespostaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private QuestaoRepository questaoRepository;
	
	@Autowired
	private QuestionarioRepository questionarioRepository;
	
	@Autowired
	private RespostaRepository respostaRepository;
	
	@Autowired
	private CadastroPDVRepository cadastroPDVRepository;
	
	@Autowired
	private ProcessoSeletivoRepository processoSeletivoRepository;
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@Autowired
	private EntrevistaRepository entrevistaRepository;
	
	@Autowired
	private AplicacaoQuestionarioRepository aplicacaoQuestionario;
	

	@Override
	public void run(String... args) throws Exception {
		
		
		CadastroPDV pdv1 = new CadastroPDV(null, "João Pessoa", 58030021);
		CadastroPDV pdv2 = new CadastroPDV(null, "Recife", 52041080);
		CadastroPDV pdv3 = new CadastroPDV(null, "Goiânia", 74175050);
		
		cadastroPDVRepository.saveAll(Arrays.asList(pdv1, pdv2, pdv3));
		
		ProcessoSeletivo ps1 = new ProcessoSeletivo(null, Instant.parse("2023-05-30T18:01:00Z"), "Goiânia-2023.3", 2, TipoVaga.ESTAGIO, Turno.MANHA_TARDE, pdv3);
		ProcessoSeletivo ps2 = new ProcessoSeletivo(null, Instant.parse("2023-05-31T08:00:00Z"), "Recife-2023.1", 1, TipoVaga.ESTAGIO, Turno.MANHA, pdv2);
		
		processoSeletivoRepository.saveAll(Arrays.asList(ps1, ps2));
		
		Candidato c1 = new Candidato(null, 83988264564L, "PEDRO HENRIQUE PORTELA DE SOUSA", 19, "Rua Narayola, Qd. 34 lote 1/21", 58108357, "Goiânia", "GO", "1º Periodo", Turno.NOITE, Status.EM_PROCESSO);
		Candidato c2 = new Candidato(null, 83988264565L, "GIDEL JOSÉ FERREIRA DA SILVA", 18, "Rua Canavieira, 316", 52150120, "Recife", "PE", "2º Periodo", Turno.NOITE, Status.EM_PROCESSO);
		Candidato c3 = new Candidato(null, 83988264562L, "MATHEUS DIOGO DA SILVA", 21, "R. 1 Q 3, 170 - St. Central", 74013010, "Goiânia", "GO", "1º Periodo", Turno.MANHA, Status.EM_PROCESSO);
		
		candidatoRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Questionario qtn1 = new Questionario(1L, "Questionário Técnico");
		
		questionarioRepository.saveAll(Arrays.asList(qtn1));
		
		Questao q1 = new Questao(null, "Como fazemos para descobrir o nome do Computador no Windows?", 120, 5.0, TipoQuestao.ABERTA, qtn1);
		Questao q2 = new Questao(null, "Como podemos realizar o compartilhamento de pastas no Windows 10, para todos os usuários?", 120, 5.0, TipoQuestao.ABERTA, qtn1);
		Questao q3 = new Questao(null, "Como podemos descobrir o endereço IP de um computador na rede local no Windows?", 120, 5.0, TipoQuestao.ABERTA, qtn1);
		
		Questao q4 = new MutiplaEscolha(null, "Os computadores atuais ainda funcionam com sistema binário. A unidade básica nesse sistema é:", 60, 2.0, TipoQuestao.MUTIPLA_ESCOLHA, qtn1, new Alternativa("byte", 1), new Alternativa("bit", 2), new Alternativa("0", 3), new Alternativa("1", 4), 2);
		
		questaoRepository.saveAll(Arrays.asList(q1, q2, q3, q4));
		
		qtn1.addQuestao(q1);
		qtn1.addQuestao(q2);
		qtn1.addQuestao(q3);
		qtn1.addQuestao(q4);
		
		questionarioRepository.saveAll(Arrays.asList(qtn1));
		
		Entrevista ent1 = new Entrevista(null, Instant.parse("2023-05-31T09:00:00Z"), 8.0, 9.0, 8.0, 9.0, ps1, c1);
		Entrevista ent2 = new Entrevista(null, Instant.parse("2023-06-01T09:00:00Z"), 9.0, 9.0, 9.0, 10.0, ps2, c2);
		Entrevista ent3 = new Entrevista(null, Instant.parse("2023-05-31T09:00:00Z"), 8.0, 9.0, 8.0, 9.0, ps1, c3);
		
		entrevistaRepository.saveAll(Arrays.asList(ent1, ent2, ent3));
		
		AplicacaoQuestionario aq1 = new AplicacaoQuestionario(ent1, qtn1);
		
		aplicacaoQuestionario.saveAll(Arrays.asList(aq1));
		
		Resposta r1 = new Resposta(null, "Configurações>Sistema", q1, aq1, Instant.parse("2023-05-31T09:15:00Z"), Instant.parse("2023-05-31T09:18:30Z"));
		Resposta r2 = new Resposta(null, "botão direito sob a pasta desejada>Mostrar mais opções>Conceder acesso a>Pessoas Específicas>Selecione Todos", q2, aq1, Instant.parse("2023-05-31T09:18:30Z"), Instant.parse("2023-05-31T09:20:45Z"));
		Resposta r3 = new Resposta(null, "windows+r>Comando(ncpa.cpl)>acesso ao painel de conexão de redes>Botão direito na rede conectada>status>detalhes...", q3, aq1, Instant.parse("2023-05-31T09:20:45Z"), Instant.parse("2023-05-31T09:22:30Z"));
		Resposta r4 = new Resposta(null, "2", q4, aq1, Instant.parse("2023-05-31T09:22:35Z"), Instant.parse("2023-05-31T09:23:30Z"));
		
		respostaRepository.saveAll(Arrays.asList(r1, r2, r3, r4));
		
		ps1.agendarEntrevista(ent1);
		ps1.agendarEntrevista(ent3);
		ps2.agendarEntrevista(ent2);
		
		aq1.addRespostas(r1);
		aq1.addRespostas(r2);
		aq1.addRespostas(r3);
		aq1.addRespostas(r4);
		
		processoSeletivoRepository.saveAll(Arrays.asList(ps1, ps2));
		
		aplicacaoQuestionario.saveAll(Arrays.asList(aq1));
		
		for(Resposta r : aq1.getRespostas()) {
			System.out.println(r.getCalcularTempoResolucaoSeg());
		}
		
	}
}
