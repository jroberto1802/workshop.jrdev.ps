package com.jrdev.ps.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_alternativa")
public class Alternativa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name = "questao_id")
	private MutiplaEscolha questaoMutiplaEscolha;
	
	public Alternativa() {
	}

	public Alternativa(Long id, String descricao, Integer codigo, MutiplaEscolha questaoMutiplaEscolha) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.codigo = codigo;
		setQuestaoMutiplaEscolha(questaoMutiplaEscolha);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public MutiplaEscolha getQuestaoMutiplaEscolha() {
		return questaoMutiplaEscolha;
	}

	public void setQuestaoMutiplaEscolha(MutiplaEscolha questaoMutiplaEscolha) {
		this.questaoMutiplaEscolha = questaoMutiplaEscolha;
	}

	
}
