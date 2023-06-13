package com.jrdev.ps.entities;

import java.io.Serializable;

public class Alternativa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String descricao;
	private Integer codigo;
	
	public Alternativa () {
	}

	public Alternativa(String descricao, Integer codigo) {
		super();
		this.descricao = descricao;
		this.codigo = codigo;
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
	
	

}
