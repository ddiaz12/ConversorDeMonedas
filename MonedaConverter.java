import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MonedaConverter {

    public static void convertirEntreMonedas(String monedaOrigen, String monedaDestino, double cantidad) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/ad5e3a6257cf9308c36ea782/latest/" + monedaOrigen))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                JsonObject jsonResponse = new Gson().fromJson(response.body(), JsonObject.class);

                double tasaDeCambio = jsonResponse.getAsJsonObject("conversion_rates").get(monedaDestino).getAsDouble();

                double resultado = cantidad * tasaDeCambio;

                System.out.println("------------------------------------");
                System.out.println(cantidad + " " + monedaOrigen + " equivale a " + resultado + " " + monedaDestino + ".");
                System.out.println("------------------------------------");
            } else {
                System.out.println("La solicitud a la API no fue exitosa. Código de estado: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}