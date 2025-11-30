package com.aluracursos.conversor;

import com.aluracursos.conversor.service.CurrencyQuery;

public class Main {
    static void main(String[] args) {
        var query = new CurrencyQuery();

        try {
            String response = query.consultExchangeRateAPI("MXN");
            System.out.println(response);
        } catch (Exception e){
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
    }
}
