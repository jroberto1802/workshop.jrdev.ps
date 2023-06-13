package com.jrdev.ps.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
	
	@OneToMany(mappedBy = "entrevista")
	private List<AplicacaoQuestionario> aplicacoesQuestionarios = new ArrayList<>();

	
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
	
	@JsonIgnore
	public List<AplicacaoQuestionario> getQuestionarios() {
		return aplicacoesQuestionarios;
	}
	
	public Double getCalcularDistancia(Integer origem, Integer destino) throws IOException {
		String apiKey = "AIzaSyBQDKSLXTpiV0G7jwZGzQh-hk0rhW894ec";
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json" +
                "?origins=" + origem +
                "&destinations=" + destino +
                "&key=" + apiKey;

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            String jsonResponse = response.toString();

			@SuppressWarnings("deprecation")
			JsonParser parser = new JsonParser();
            @SuppressWarnings("deprecation")
			JsonObject jsonObject = parser.parse(jsonResponse).getAsJsonObject();

            JsonArray rows = jsonObject.getAsJsonArray("rows");
            JsonObject rowObject = rows.get(0).getAsJsonObject();

            JsonArray elements = rowObject.getAsJsonArray("elements");
            JsonObject elementObject = elements.get(0).getAsJsonObject();

            JsonObject distance = elementObject.getAsJsonObject("distance");
            int distanceValue = distance.get("value").getAsInt();

            // Converter o valor da distância de metros para quilômetros
            double distanciaEmKm = distanceValue / 1000.0;

            return distanciaEmKm; 
        } else {
            throw new IOException("Falha na solicitação HTTP. Código de resposta: " + responseCode);
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
		Entrevista other = (Entrevista) obj;
		return Objects.equals(id, other.id);
	}
	
	public void aplicarQuestionario(AplicacaoQuestionario aplicacaoQuestionario) {
		aplicacoesQuestionarios.add(aplicacaoQuestionario);
	}
	
	@Override
	public String toString() {
		return "Entrevista [id=" + id + ", data=" + data + ", postura=" + postura + ", diccao=" + diccao + ", girias="
				+ girias + ", pontualidade=" + pontualidade + ", processo=" + processo + ", candidato=" + candidato
				+ ", aplicacoesQuestionarios=" + aplicacoesQuestionarios + "]";
	}

	
	
}
