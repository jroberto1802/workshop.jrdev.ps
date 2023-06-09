package com.jrdev.ps.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_questionario")
public class Questionario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	private String titulo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "questionario")
	private Set<Questao> questoes = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "questionario")
	private Set<AplicacaoQuestionario> aplicacaoQuestionarios = new HashSet<>();
	
	public Questionario () {
	}

	public Questionario(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Set<Questao> getQuestoes() {
		return questoes;
	}
	
	public void addQuestao(Questao questao) {
		questoes.add(questao);
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
		Questionario other = (Questionario) obj;
		return Objects.equals(id, other.id);
	}
	
}
