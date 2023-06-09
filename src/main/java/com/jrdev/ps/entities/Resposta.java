package com.jrdev.ps.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_resposta")
public class Resposta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
    @JoinColumn(name = "aplicacaoQuestionario_id")
    private AplicacaoQuestionario aplicacaoQuestionario;
	
	@ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;
	
	private String resposta;
	
	public Resposta() {
	}

	public Resposta(Long id, AplicacaoQuestionario aplicacaoQuestionario, String resposta) {
		super();
		this.id = id;
		this.aplicacaoQuestionario = aplicacaoQuestionario;
		this.resposta = resposta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AplicacaoQuestionario getAplicacaoQuestionario() {
		return aplicacaoQuestionario;
	}

	public void setAplicacaoQuestionario(AplicacaoQuestionario aplicacaoQuestionario) {
		this.aplicacaoQuestionario = aplicacaoQuestionario;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
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
		Resposta other = (Resposta) obj;
		return Objects.equals(id, other.id);
	}

}