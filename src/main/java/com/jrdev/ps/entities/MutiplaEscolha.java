package com.jrdev.ps.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jrdev.ps.entities.enums.TipoQuestao;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class MutiplaEscolha extends Questao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany
    private List<Alternativa> alternativas = new ArrayList<>();
	
	private Integer alternativaCorreta;
	
	public MutiplaEscolha() {
	}

	public MutiplaEscolha(Long id, String problema, Integer tempoResolucaoSeg, Double qtdPontos,
			TipoQuestao tipoQuestao, Questionario questionario, Integer alternativaCorreta) {
		super(id, problema, tempoResolucaoSeg, qtdPontos, tipoQuestao, questionario);
		this.alternativaCorreta = alternativaCorreta;
	}

	public List<Alternativa> getAlternativas() {
		return alternativas;
	}
	
	public void addAlternativa(Alternativa alternativa) {
		alternativas.add(alternativa);
	}

	public Integer getAlternativaCorreta() {
		return alternativaCorreta;
	}

	public void setAlternativaCorreta(Integer alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}
	
}
