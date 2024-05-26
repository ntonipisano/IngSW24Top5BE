package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
@Service
public class LocalUtenti {

    /* URI base per le chiamate al servizio REST */
    static String uriBaseMock = "http://localhost:3001";
    /* Metodo che fa la chiamata REST */
    public static String callREST(String resourceName, String uriBase, boolean useMock) {
        RestClient restClient = RestClient.create();
        /* Se useMock è True l'URI base sarà quella definita sopra */
        if(useMock)
            uriBase = uriBaseMock;

        /* Eseguo una chiamata GET al servizio REST e restituisco la risposta */
        return restClient.get()
                .uri(uriBase + resourceName)
                .retrieve()
                .body(String.class);
    }
}