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
@Table(name = "tb_cadastropdv")
public class CadastroPDV implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer cep;
	
	@JsonIgnore
	@OneToMany(mappedBy = "pdv")
	private Set<ProcessoSeletivo> processos = new HashSet<>();
	
	public CadastroPDV() {
	}
	
	public CadastroPDV(Long id, String nome, Integer cep) {
		super();
		this.id = id;
		this.nome = nome;
		this.cep = cep;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}
	
	public Set<ProcessoSeletivo> getProcessos() {
		return processos;
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
		CadastroPDV other = (CadastroPDV) obj;
		return id == other.id;
	}
	
	
}
