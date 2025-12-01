package com.aluracursos.conversor.service;

import com.aluracursos.conversor.models.CurrencyApiResponse;

public class ConvertCurrency {
    public double convert(String currencyQuery, String targetCurrency, double amount){
        var query = new CurrencyQuery();
        CurrencyApiResponse response;

        try {
            response = query.consultExchangeRateAPI(currencyQuery);

            double factor = response.conversionRates().get(targetCurrency);
            return amount * factor;
        } catch (Exception e){
            System.out.println("ERROR: No se pudo conectar o procesar los datos de la API.");
            throw new RuntimeException("Fallo en la consulta de la API: " + e.getMessage());
        }
    }
}
