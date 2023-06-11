package com.jrdev.ps.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_questao_mutiplaescolha")
public class MutiplaEscolha extends Questao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Alternativa alternativa1;
	private Alternativa alternativa2;
	private Alternativa alternativa3;
	private Alternativa alternativa4;
	private Integer alternativaCorreta;
	
	public MutiplaEscolha() {
	}

	public MutiplaEscolha(Alternativa alternativa1, Alternativa alternativa2, Alternativa alternativa3,
			Alternativa alternativa4, Integer alternativaCorreta) {
		super();
		this.alternativa1 = alternativa1;
		this.alternativa2 = alternativa2;
		this.alternativa3 = alternativa3;
		this.alternativa4 = alternativa4;
		this.alternativaCorreta = alternativaCorreta;
	}

	public Alternativa getAlternativa1() {
		return alternativa1;
	}

	public void setAlternativa1(Alternativa alternativa1) {
		this.alternativa1 = alternativa1;
	}

	public Alternativa getAlternativa2() {
		return alternativa2;
	}

	public void setAlternativa2(Alternativa alternativa2) {
		this.alternativa2 = alternativa2;
	}

	public Alternativa getAlternativa3() {
		return alternativa3;
	}

	public void setAlternativa3(Alternativa alternativa3) {
		this.alternativa3 = alternativa3;
	}

	public Alternativa getAlternativa4() {
		return alternativa4;
	}

	public void setAlternativa4(Alternativa alternativa4) {
		this.alternativa4 = alternativa4;
	}

	public Integer getAlternativaCorreta() {
		return alternativaCorreta;
	}

	public void setAlternativaCorreta(Integer alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}
	
	

}
