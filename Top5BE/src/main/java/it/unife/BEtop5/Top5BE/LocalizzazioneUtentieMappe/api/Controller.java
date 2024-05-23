package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.api;

import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models.Tableeventi;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services.EventoSaveService;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services.LocalEventi;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models.Tableutenti;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services.UtenteSaveService;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services.LocalUtenti;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController /* Annotation per definire che la classe risponderà tramite rest  */
@RequestMapping("/api") /* Annotation per definire il path della classe  */

public class Controller {
    @Autowired
    private LocalEventi localeventi;

    @RequestMapping("/callRESTevento") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public String callRestevento() {
        return LocalEventi.callREST("/posizionevento", null, true);
    }

    @Autowired
    private EventoSaveService eventoSaveService;

    @GetMapping("/importEvents")
    public void importEvents() {
        String eventiJson = LocalEventi.callREST("/posizionevento", null, true);
        if (eventiJson != null) {
            eventoSaveService.saveEventi(eventiJson);
        }
    }

    @Autowired
    private LocalUtenti localutenti;

    @RequestMapping("/callRESTutente") /* Annotation per definire il path del metodo (relativo alla classe)  */
    public String callRestutente() {
        return LocalUtenti.callREST("/utente", null, true);
    }


    @Autowired
    private UtenteSaveService utenteSaveService;

    @GetMapping("/importUsers")
    public void importUsers() {
        String utentiJson = LocalUtenti.callREST("/utente", null, true);
        if (utentiJson != null) {
            utenteSaveService.saveUtenti(utentiJson);
        }
    }
}
