package com.jrdev.ps.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jrdev.ps.entities.enums.Status;
import com.jrdev.ps.entities.enums.Turno;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_candidato")
public class Candidato implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long fone;
	private String nomeCompleto;
	private Integer idade;
	private String logradouro;
	private Integer cep;
	private String cidade;
	private String uf;
	private String periodoAtual;
	
	private Integer turnoFaculdade;
	private Integer status;
	
	@OneToMany(mappedBy = "candidato")
	private Set<Entrevista> entrevistas = new HashSet<>();
	
	public Candidato() {
	}

	public Candidato(Long id, Long fone, String nomeCompleto, Integer idade, String logradouro, Integer cep, String cidade,
			String uf, String periodoAtual, Turno turnoFaculdade, Status status) {
		super();
		this.id = id;
		this.fone = fone;
		this.nomeCompleto = nomeCompleto;
		this.idade = idade;
		this.logradouro = logradouro;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
		this.periodoAtual = periodoAtual;
		setStatus(status);
		setTurnoFaculdade(turnoFaculdade);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getFone() {
		return fone;
	}

	public void setFone(Long fone) {
		this.fone = fone;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getPeriodoAtual() {
		return periodoAtual;
	}

	public void setPeriodoAtual(String periodoAtual) {
		this.periodoAtual = periodoAtual;
	}

	public Turno getTurnoFaculdade() {
		return Turno.valueOf(turnoFaculdade);
	}

	public void setTurnoFaculdade(Turno turnoFaculdade) {
		if(turnoFaculdade != null) {
			this.turnoFaculdade = turnoFaculdade.getCode();
		}
	}

	public Status getStatus() {
		return Status.valueOf(status);
	}

	public void setStatus(Status status) {
		if(status != null) {
			 this.status = status.getCode();
		}
	}
	
	@JsonIgnore
	public Set<Entrevista> getEntrevista() {
		return entrevistas;
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
		Candidato other = (Candidato) obj;
		return Objects.equals(id, other.id);
	}	
	
}
