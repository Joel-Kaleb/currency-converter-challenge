package com.aluracursos.conversor.service;

import com.aluracursos.conversor.models.CurrencyApiResponse;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CurrencyQuery {
    public CurrencyApiResponse consultExchangeRateAPI(String currency) {
        String BASE_URL = "https://v6.exchangerate-api.com/v6/";
        String API_KEY = System.getenv("EXCHANGERATE_API_KEY");
        URI address = URI.create(BASE_URL + API_KEY + "/latest/" + currency);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(address)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), CurrencyApiResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("Ocurrio un error");
        }
    }
}
