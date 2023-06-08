package com.jrdev.ps.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aplicacao_questionario")
public class AplicacaoQuestionario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long token = TokenGenerator.generateRandomToken();
	
	private Double percentualAcerto = null;
	private Double pontuacao = null;
	private Integer tempoResolucaoCandidatoSeg = null;
	
	@ManyToOne
    @JoinColumn(name = "entrevista_id")
    private Entrevista entrevista;
	
	public AplicacaoQuestionario() {
	}

	public Long getToken() {
		return token;
	}

	public void setToken(Long token) {
		this.token = token;
	}

	public Double getPercentualAcerto() {
		return percentualAcerto;
	}

	public void setPercentualAcerto(Double percentualAcerto) {
		this.percentualAcerto = percentualAcerto;
	}

	public Double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Double pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Integer getTempoResolucaoCandidatoSeg() {
		return tempoResolucaoCandidatoSeg;
	}

	public void setTempoResolucaoCandidatoSeg(Integer tempoResolucaoCandidatoSeg) {
		this.tempoResolucaoCandidatoSeg = tempoResolucaoCandidatoSeg;
	}

	public Entrevista getEntrevistaId() {
		return entrevista;
	}

	public void setEntrevistaId(Entrevista entrevistaId) {
		this.entrevista = entrevistaId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(token);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AplicacaoQuestionario other = (AplicacaoQuestionario) obj;
		return Objects.equals(token, other.token);
	}
	
}
