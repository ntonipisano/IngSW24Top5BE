package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestClient;
@SpringBootApplication
public class LocalEventi {
    static String uriBaseMock = "http://localhost:3001/posizionevento";  //URL endpoint Mockoon

    public static String callREST(String uriBaseMock) {
        RestClient restClient = RestClient.create();

        return restClient.get()
                .uri(uriBaseMock)
                .retrieve()
                .body(String.class);
    }
}