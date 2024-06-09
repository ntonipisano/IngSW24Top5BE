package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models.Tableeventi;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models.EventoDTO;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.repositories.Repoeventi;

/* Annotation per dichiarare la classe come servizio Spring */
@Service
public class EventoSaveService {

    @Autowired
    private Repoeventi eventoRepository;

    /* Metodo che salva gli eventi sul database a partire da una stringa JSON */
    public void saveEventi(String eventiJson) {

        try {
            /* Creazione oggetto ObjectMapper per la conversione da JSON a oggetti Java */
            ObjectMapper objectMapper = new ObjectMapper();
            /* Deserializzazione stringa JSON in un array di oggetti EventoDTO */
            EventoDTO[] eventiDTO = objectMapper.readValue(eventiJson, EventoDTO[].class);

            for (EventoDTO dto : eventiDTO) {
                /* Creazione oggetto evento e popolamento dei suoi attributi */
                Tableeventi evento = new Tableeventi();
                evento.setNomevento(dto.getNomevento());
                evento.setLatitudine(Double.parseDouble(dto.getLatitudine()));
                evento.setLongitudine(Double.parseDouble(dto.getLongitudine()));
                evento.setAccessibilità(dto.getAccessibilità());
                /* Salvataggio oggetto evento sul database tramite repository */
                eventoRepository.save(evento);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
