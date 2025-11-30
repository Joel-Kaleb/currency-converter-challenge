package com.aluracursos.conversor.models;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record CurrencyApiResponse(
        @SerializedName("conversion_rates") Map<String, Double> conversionRates
) {}
