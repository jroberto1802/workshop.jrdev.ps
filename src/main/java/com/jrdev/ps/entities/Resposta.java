package com.jrdev.ps.entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private Double pontuacao = null;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant inicioResposta;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant finalResposta;
	
	@ManyToOne
    @JoinColumn(name = "aplicacaoQuestionario_id")
    private AplicacaoQuestionario aplicacaoQuestionario;
	
	@ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;
	
	public Resposta() {
	}

	public Resposta(Long id, String descricao, Questao questao, AplicacaoQuestionario aplicacaoQuestionario, Instant inicioResposta, Instant finalResposta) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.inicioResposta = inicioResposta;
		this.finalResposta = finalResposta;
		setQuestao(questao);
		setAplicacaoQuestionario(aplicacaoQuestionario);
		setPontuacao(getCalcularPontuacao());
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

	public Double getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Double pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Instant getInicioResposta() {
		return inicioResposta;
	}

	public void setInicioResposta(Instant inicioResposta) {
		this.inicioResposta = inicioResposta;
	}

	public Instant getFinalResposta() {
		return finalResposta;
	}

	public void setFinalResposta(Instant finalResposta) {
		this.finalResposta = finalResposta;
	}
	
	public Integer getCalcularTempoResolucaoSeg() {
        Duration duracao = Duration.between(inicioResposta, finalResposta);
        long diferencaEmSegundos = duracao.getSeconds();
        return Math.toIntExact(diferencaEmSegundos);
    }
	
	public Double getCalcularPontuacao() {
		if (getCalcularTempoResolucaoSeg() <= questao.getTempoResolucaoSeg()) {
			return questao.getQtdPontos();
		}
		else {
			return questao.getQtdPontos()/2;
		}
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

	@Override
	public String toString() {
		return "Resposta [id=" + id + ", descricao=" + descricao + ", pontuacaoTotal=" + pontuacao
				+ ", inicioResposta=" + inicioResposta + ", finalResposta=" + finalResposta + ", aplicacaoQuestionario="
				+ aplicacaoQuestionario + ", questao=" + questao + "]";
	}
	
	

}
