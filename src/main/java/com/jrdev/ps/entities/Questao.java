package com.jrdev.ps.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jrdev.ps.entities.enums.TipoQuestao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_questao")
public class Questao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String problema;
	private Integer tempoResolucaoSeg;
	private Double qtdPontos;
	private Integer tipoQuestao;
	
	@ManyToOne
	@JoinColumn(name = "questionario_id")
	private Questionario questionario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "questao")
	private Set<Resposta> respostas = new HashSet<>();
	
	public Questao() {
	}

	public Questao(Long id, String problema, Integer tempoResolucaoSeg, Double qtdPontos, TipoQuestao tipoQuestao, Questionario questionario) {
		super();
		this.id = id;
		this.problema = problema;
		this.tempoResolucaoSeg = tempoResolucaoSeg;
		this.qtdPontos = qtdPontos;
		setTipoQuestao(tipoQuestao);
		setQuestionario(questionario);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public Integer getTempoResolucaoSeg() {
		return tempoResolucaoSeg;
	}

	public void setTempoResolucaoSeg(Integer tempoResolucaoSeg) {
		this.tempoResolucaoSeg = tempoResolucaoSeg;
	}

	public Double getQtdPontos() {
		return qtdPontos;
	}

	public void setQtdPontos(Double qtdPontos) {
		this.qtdPontos = qtdPontos;
	}

	public TipoQuestao getTipoQuestao() {
		return TipoQuestao.valueOf(tipoQuestao);
	}

	public void setTipoQuestao(TipoQuestao tipoQuestao) {
		if(tipoQuestao != null) {
			this.tipoQuestao = tipoQuestao.getCode();
		}
	}
	
	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public Set<Resposta> getRespostas() {
		return respostas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questao other = (Questao) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
