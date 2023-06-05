package com.jrdev.ps.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_entrevista")
public class Entrevista implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant data;
	private Double postura;
	private Double diccao;
	private Double girias;
	private Double pontualidade;
	
	@ManyToOne
	@JoinColumn(name = "ps_id")
	private ProcessoSeletivo processo;
	
	@ManyToOne
	@JoinColumn(name = "candidato_id")
	private Candidato candidato;
	
	@OneToMany
	private Set<AplicacaoQuestionario> questionarios = new HashSet<>();
	
	public Entrevista() {
	}

	public Entrevista(Long id, Instant data, Double postura, Double diccao, Double girias, Double pontualidade,
			ProcessoSeletivo processo, Candidato candidato) {
		super();
		this.id = id;
		this.data = data;
		this.postura = postura;
		this.diccao = diccao;
		this.girias = girias;
		this.pontualidade = pontualidade;
		this.processo = processo;
		this.candidato = candidato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Double getPostura() {
		return postura;
	}

	public void setPostura(Double postura) {
		this.postura = postura;
	}

	public Double getDiccao() {
		return diccao;
	}

	public void setDiccao(Double diccao) {
		this.diccao = diccao;
	}

	public Double getGirias() {
		return girias;
	}

	public void setGirias(Double girias) {
		this.girias = girias;
	}

	public Double getPontualidade() {
		return pontualidade;
	}

	public void setPontualidade(Double pontualidade) {
		this.pontualidade = pontualidade;
	}

	public ProcessoSeletivo getProcesso() {
		return processo;
	}

	public void setProcesso(ProcessoSeletivo processo) {
		this.processo = processo;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Set<AplicacaoQuestionario> getQuestionarios() {
		return questionarios;
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
		Entrevista other = (Entrevista) obj;
		return Objects.equals(id, other.id);
	}
	
	public void aplicarQuestionario(AplicacaoQuestionario aplicacaoQuestionario) {
		questionarios.add(aplicacaoQuestionario);
	}

	
	
}
