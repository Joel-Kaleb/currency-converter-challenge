package com.aluracursos.conversor;

import com.aluracursos.conversor.service.ConvertCurrency;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner userInput = new Scanner(System.in);
    private static final List<String> CURRENCY_CODES = List.of(
            "MXN", "USD", "EUR", "GBP", "ARS", "BRL"
    );
    // Menu y opciones
    private static final String MENU_TITLE = "Selecciona la divisa:";
    private static final String MENU_OPTIONS = """
            1. Pesos Mexicano (MXN)
            2. Dólar Estadounidense (USD)
            3. Euro (EUR)
            4. Libra Esterlina Británica (GBP)
            5. Peso Argentino (ARS)
            6. Real Brasileño (BRL)
            7. Salir
            """;
    private static final int EXIT_OPTION = 7;

    public static void main(String[] args) {
        var convert = new ConvertCurrency();

        while (true) {
            try {
                // Obtener Divisa Base
                String baseCurrency = getCurrencyCode("BASE");
                if (baseCurrency == null) break;

                // Obtener Divisa Destino
                String targetCurrency = getCurrencyCode("DESTINO");
                if (targetCurrency == null) break;

                // Obtener Monto
                System.out.print("\nIngresa el monto original: ");
                double originAmount = Double.parseDouble(userInput.nextLine());

                // Realizar Conversión y Mostrar Resultado
                double response = convert.convert(baseCurrency, targetCurrency, originAmount);

                System.out.printf("\n RESULTADO: %.2f %s equivale a %.2f %s\n",
                        originAmount, baseCurrency, response, targetCurrency);

            } catch (NumberFormatException e) {
                System.out.println("\n ERROR: Ingresa un valor numérico válido para la opción o el monto.");
            } catch (RuntimeException e) {
                System.out.println("\n ERROR en la conversión: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("\n Ocurrió un error inesperado.");
            }
        }
        System.out.println("\nConversor finalizado. ¡Gracias!");
    }

    // Metodo estatico para obtener el código de la divisa
    private static String getCurrencyCode(String type) {
        int choice = -1;
        int maxOption = CURRENCY_CODES.size() + 1;

        System.out.println("\n--- " + MENU_TITLE + " (" + type + ") ---");
        System.out.println(MENU_OPTIONS);

        while (choice < 1 || choice > maxOption) {
            System.out.print("Ingresa tu opción (" + type + "): ");

            try {
                choice = Integer.parseInt(userInput.nextLine());

                if (choice < 1 || choice > maxOption) {
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } catch (NumberFormatException e) {
                // Maneja si el usuario ingresa una letra aquí
                System.out.println("Entrada inválida. Debe ingresar un número.");
            }
        }

        if (choice == EXIT_OPTION) {
            return null;
        }

        return CURRENCY_CODES.get(choice - 1);
    }
}