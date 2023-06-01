package com.jrdev.ps.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jrdev.ps.entities.enums.TipoVaga;
import com.jrdev.ps.entities.enums.Turno;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_processo_seletivo")
public class ProcessoSeletivo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant dataInicio;
	private String nome;
	private Integer qtdVagas;
	
	private Integer tipoVaga;
	private Integer turnoVaga;
	
	@ManyToOne
	@JoinColumn(name = "pdv_id")
	private CadastroPDV pdv;
	
	@JsonIgnore
	@OneToMany(mappedBy = "processo")
	private Set<Entrevista> entrevistas = new HashSet<>();
	
	public ProcessoSeletivo() {
	}

	public ProcessoSeletivo(Long id, Instant dataInicio, String nome, Integer qtdVagas, TipoVaga tipoVaga, Turno turnoVaga, CadastroPDV pdv) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.nome = nome;
		this.qtdVagas = qtdVagas;
		setTipoVaga(tipoVaga);
		setTurnoVaga(turnoVaga);
		this.pdv = pdv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Instant dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getQtdVagas() {
		return qtdVagas;
	}

	public void setQtdVagas(Integer qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

	public CadastroPDV getPdv() {
		return pdv;
	}

	public void setPdv(CadastroPDV pdv) {
		this.pdv = pdv;
	}

	public TipoVaga getTipoVaga() {
		return TipoVaga.valueOf(tipoVaga);
	}

	public void setTipoVaga(TipoVaga tipoVaga) {
		if(tipoVaga != null) {
			this.tipoVaga = tipoVaga.getCode();
		}
	}

	public Turno getTurnoVaga() {
		return Turno.valueOf(turnoVaga);
	}

	public void setTurnoVaga(Turno turnoVaga) {
		if(turnoVaga != null) {
			this.turnoVaga = turnoVaga.getCode();
		}
	}

	public Set<Entrevista> getEntrevistas() {
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
		ProcessoSeletivo other = (ProcessoSeletivo) obj;
		return Objects.equals(id, other.id);
	}

	public void agendarEntrevista(Entrevista entrevista) {
		entrevistas.add(entrevista);
	}

}
