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
	
	private String descricao;
	
	@ManyToOne
    @JoinColumn(name = "aplicacaoQuestionario_id")
    private AplicacaoQuestionario aplicacaoQuestionario;
	
	@ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;
	
	public Resposta() {
	}

	public Resposta(Long id, String descricao, Questao questao, AplicacaoQuestionario aplicacaoQuestionario) {
		super();
		this.id = id;
		this.descricao = descricao;
		setQuestao(questao);
		setAplicacaoQuestionario(aplicacaoQuestionario);
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
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
