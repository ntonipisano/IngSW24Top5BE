package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.api;

import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services.EventoSaveService;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services.LocalEventi;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services.UtenteSaveService;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services.LocalUtenti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController /* Annotation per definire che la classe risponderà tramite rest  */
@RequestMapping("/api") /* Annotation per definire il path della classe  */

public class Controller {

    //Endpoint /callRESTevento che fa la chiamata REST e stampa a video il risultato
    @Autowired
    private LocalEventi localeventi;
    @GetMapping("/callRESTevento") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public String callRestevento() {
        return LocalEventi.callREST("/posizionevento", null, true);
    }

    //Endpoint /importEvents che fa la chiamata REST, stampa a video il risultato e salva i dati sul database
    @Autowired
    private EventoSaveService eventoSaveService;
    @GetMapping("/importEvents")
    public String importEvents() {
        String eventiJson = LocalEventi.callREST("/posizionevento", null, true);
        if (eventiJson != null) {
            eventoSaveService.saveEventi(eventiJson);
        }
        return eventiJson;
    }

    //Endpoint /callRESTutente che fa la chiamata REST e stampa a video il risultato
    @Autowired
    private LocalUtenti localutenti;
    @GetMapping("/callRESTutente") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public String callRestutente() {
        return LocalUtenti.callREST("/utente", null, true);
    }

    //Endpoint /importUsers che fa la chiamata REST, stampa a video il risultato e salva i dati sul database
    @Autowired
    private UtenteSaveService utenteSaveService;
    @GetMapping("/importUsers")
    public String importUsers() {
        String utentiJson = LocalUtenti.callREST("/utente", null, true);
        if (utentiJson != null) {
            utenteSaveService.saveUtenti(utentiJson);
        }
        return utentiJson;
    }
}
