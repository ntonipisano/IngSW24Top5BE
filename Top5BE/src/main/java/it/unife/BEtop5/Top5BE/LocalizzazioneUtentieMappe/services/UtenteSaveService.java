package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models.Tableutenti;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models.UtenteDTO;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.repositories.Repoutenti;

/* Annotation per dichiarare la classe come servizio Spring */
@Service
public class UtenteSaveService {

    @Autowired
    private Repoutenti utenteRepository;

    /* Metodo che salva gli utenti sul database a partire da una stringa JSON */
    public void saveUtenti (String utentiJson) {

        try {
            /* Creazione oggetto ObjectMapper per la conversione da JSON a oggetti Java */
            ObjectMapper objectMapper = new ObjectMapper();
            /* Deserializzazione stringa JSON in un array di oggetti UtenteDTO */
            UtenteDTO[] utentiDTO = objectMapper.readValue(utentiJson, UtenteDTO[].class);

            for (UtenteDTO dto : utentiDTO) {
                /* Creazione oggetto utente e popolamento dei suoi attributi */
                Tableutenti utente = new Tableutenti();
                utente.setNomeutente(dto.getNomeutente());
                utente.setLatitudine(Double.parseDouble(dto.getLatitudine()));
                utente.setLongitudine(Double.parseDouble(dto.getLongitudine()));

                /* Salvataggio oggetto evento sul database tramite repository */
                utenteRepository.save(utente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
