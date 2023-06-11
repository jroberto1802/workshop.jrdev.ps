package com.jrdev.ps.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrdev.ps.entities.Entrevista;
import com.jrdev.ps.repositories.EntrevistaRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class EntrevistaService {
	
	@Autowired
	private EntrevistaRepository entrevistaRepository;
	
	public List<Entrevista> findAll() {
		return entrevistaRepository.findAll();
	}
	
	public Entrevista findById(Long id) {
		Optional<Entrevista> obj = entrevistaRepository.findById(id);
		return obj.get();
	}
	
	public Double calcularDistancia(Entrevista entrevista) throws IOException {
        String apiKey = "AIzaSyBQDKSLXTpiV0G7jwZGzQh-hk0rhW894ec";
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json" +
                "?origins=" + entrevista.getProcesso().getPdv().getCep() +
                "&destinations=" + entrevista.getCandidato().getCep() +
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
	
}
