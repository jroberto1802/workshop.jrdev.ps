package com.jrdev.ps.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_aplicacao_questionario")
public class AplicacaoQuestionario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long token = TokenGenerator.generateRandomToken();
	
	private Double percentualAcerto = null;
	private Double pontuacaoTotal = null;
	private Double tempoResolucaoMedCandidatoSeg = null;
	
	@ManyToOne
    @JoinColumn(name = "entrevista_id")
    private Entrevista entrevista;
	
	@OneToMany(mappedBy = "aplicacaoQuestionario")
	private List<Resposta> respostas = new ArrayList<>();
	
	@ManyToOne
    @JoinColumn(name = "questionario_id")
	private Questionario questionario;
	
	public AplicacaoQuestionario() {
	}
	
	public AplicacaoQuestionario(Entrevista entrevista, Questionario questionario) {
		setEntrevista(entrevista);
		setQuestionario(questionario);
	}

	public Long getToken() {
		return token;
	}

	public void setToken(Long token) {
		this.token = token;
	}

	public Double getPercentualAcerto() {
		return percentualAcerto;
	}

	public void setPercentualAcerto(Double percentualAcerto) {
		this.percentualAcerto = percentualAcerto;
	}

	public Double getPontuacaoTotal() {
		return pontuacaoTotal;
	}

	public void setPontuacaoTotal(Double pontuacaoTotal) {
		this.pontuacaoTotal = pontuacaoTotal;
	}

	public Double getTempoResolucaoMedCandidatoSeg() {
		return tempoResolucaoMedCandidatoSeg;
	}

	public void setTempoResolucaoMedCandidatoSeg(Double tempoResolucaoMedCandidatoSeg) {
		this.tempoResolucaoMedCandidatoSeg = tempoResolucaoMedCandidatoSeg;
	}

	public Entrevista getEntrevista() {
		return entrevista;
	}

	public void setEntrevista(Entrevista entrevista) {
		this.entrevista = entrevista;
	}

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}
	
	@JsonIgnore
	public List<Resposta> getRespostas() {
		return respostas;
	}
	
	public void addRespostas(Resposta resposta) {
		respostas.add(resposta);
		setPontuacaoTotal(calcularPontuacaoTotal());
		setTempoResolucaoMedCandidatoSeg(calcularTempoResolucaoMedCandidatoSeg());
		setPercentualAcerto(calcularPercentual());
	}
	
	public Double calcularPontuacaoTotal() {
		Double sum = 0.0;
		for (Resposta r : respostas) {
			sum = sum + r.getPontuacao();
		}
		return sum;
	}
	
	public Double calcularTempoResolucaoMedCandidatoSeg() {
		Integer sum = 0;
        for (Resposta r : respostas) {
            sum += r.getCalcularTempoResolucaoSeg();
        }
        Double media = (double) sum / respostas.size();
        return media;
	}
	
	public Double calcularPercentual() {
		Integer acertos = 0;
		
		for (Resposta r : respostas) {
            if(r.getQuestao() instanceof MutiplaEscolha) {
            	MutiplaEscolha q = (MutiplaEscolha) r.getQuestao();
            	for(Alternativa a : q.getAlternativas()) {
            		if (q.getAlternativaCorreta() == a.getCodigo() && Integer.parseInt(r.getDescricao()) == q.getAlternativaCorreta()) {
            			acertos++;
            		}
            	}
            }
            else {
            	if (r.getDescricao() != null) {
            		acertos++;
            	}
            }
        }
		return (double) acertos*100/respostas.size();
	}

	@Override
	public int hashCode() {
		return Objects.hash(token);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AplicacaoQuestionario other = (AplicacaoQuestionario) obj;
		return Objects.equals(token, other.token);
	}

	@Override
	public String toString() {
		return "AplicacaoQuestionario [token=" + token + ", percentualAcerto=" + percentualAcerto + ", pontuacao="
				+ pontuacaoTotal + ", tempoResolucaoCandidatoSeg=" + tempoResolucaoMedCandidatoSeg + ", entrevista="
				+ entrevista + ", respostas=" + respostas + ", questionario=" + questionario + "]";
	}
	
	
}
