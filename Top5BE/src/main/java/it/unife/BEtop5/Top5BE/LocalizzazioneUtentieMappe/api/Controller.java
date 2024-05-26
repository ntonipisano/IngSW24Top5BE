package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.api;

import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services.EventoSaveService;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services.LocalEventi;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services.UtenteSaveService;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services.LocalUtenti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /* Annotation per definire che la classe risponderà tramite rest */
@RequestMapping("/api") /* Annotation per definire il path della classe  */

public class Controller {

    @Autowired
    private LocalEventi localeventi;

    /* Annotation per definire il path del metodo (relativo alla classe) che restituisce la posizione degli eventi */
    @GetMapping("/callRESTevento") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public String callRestevento() {
        return LocalEventi.callREST("/posizionevento", null, true);
    }

    @Autowired
    private EventoSaveService eventoSaveService;

    /* Annotation per definire il path del metodo (relativo alla classe) che importa la posizione degli eventi sul database e li stampa */
    @GetMapping("/importEvents")
    public String importEvents() {
        /* Chiama il servizio REST per ottenere le info sugli eventi, se la risposta non è nulla salva, poi stampa il risultato */
        String eventiJson = LocalEventi.callREST("/posizionevento", null, true);
        if (eventiJson != null) {
            eventoSaveService.saveEventi(eventiJson);
        }
        return eventiJson;
    }

    @Autowired
    private LocalUtenti localutenti;

    /* Annotation per definire il path del metodo (relativo alla classe) che restituisce la posizione degli utenti */
    @GetMapping("/callRESTutente") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public String callRestutente() {
        return LocalUtenti.callREST("/utente", null, true);
    }

    @Autowired
    private UtenteSaveService utenteSaveService;

    /* Annotation per definire il path del metodo (relativo alla classe) che importa la posizione degli utenti sul database e li stampa */
    @GetMapping("/importUsers")
    public String importUsers() {
        /* Chiama il servizio REST per ottenere le info sugli utenti, se la risposta non è nulla salva, poi stampa il risultato */
        String utentiJson = LocalUtenti.callREST("/utente", null, true);
        if (utentiJson != null) {
            utenteSaveService.saveUtenti(utentiJson);
        }
        return utentiJson;
    }
}
