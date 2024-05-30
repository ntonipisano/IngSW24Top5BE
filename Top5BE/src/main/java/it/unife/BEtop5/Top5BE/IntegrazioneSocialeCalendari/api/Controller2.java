package it.unife.BEtop5.Top5BE.IntegrazioneSocialeCalendari.api;

import it.unife.BEtop5.Top5BE.IntegrazioneSocialeCalendari.services.IntegCalend;
import it.unife.BEtop5.Top5BE.IntegrazioneSocialeCalendari.services.CalendarioSaveService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /* Annotation per definire che la classe risponderà tramite rest */
@RequestMapping("/api") /* Annotation per definire il path della classe  */

public class Controller2 {
    @Autowired
    private IntegCalend integCalend;

    /* Annotation per definire il path del metodo (relativo alla classe) che restituisce le informazioni sulle date degli eventi */
    @GetMapping("/callRESTcalendario") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public String callRestcalendario() {
        return IntegCalend.callREST("/infoeventi", null, true);
    }

    @Autowired
    private CalendarioSaveService calendarioSaveService;

    /* Annotation per definire il path del metodo (relativo alla classe) che importa le informazioni sugli eventi nel database e li stampa */
    @GetMapping("/importCalendar")
    public String importCalendar() {
        /* Chiama il servizio REST per ottenere le info sugli eventi, se la risposta non è nulla salva, poi stampa il risultato */
        String calendariJson = IntegCalend.callREST("/infoeventi", null, true);
        if (calendariJson != null) {
            calendarioSaveService.saveCalendari(calendariJson);
        }
        return calendariJson;
    }
}
