import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ARStoUSD {
    public static void convert(double amount) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/ad5e3a6257cf9308c36ea782/latest/USD"))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Parsear la respuesta JSON
                JsonObject jsonResponse = new Gson().fromJson(response.body(), JsonObject.class);

                // Obtener la tasa de cambio de ARS a USD
                double tasaDeCambioARS = jsonResponse.getAsJsonObject("conversion_rates").get("ARS").getAsDouble();

                // Realizar la conversión de ARS a USD
                double resultadoUSD = amount / tasaDeCambioARS;

                // Imprimir el resultado
                System.out.println("---------------------");
                System.out.println(amount + " ARS equivale a " + resultadoUSD + " USD.");
                System.out.println("---------------------");
            } else {
                System.out.println("La solicitud a la API no fue exitosa. Código de estado: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

