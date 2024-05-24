package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models.Tableutenti;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models.UtenteDTO;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.repositories.Repoutenti;

@Service
public class UtenteSaveService {

    @Autowired
    private Repoutenti utenteRepository;

    public void saveUtenti(String utentiJson) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            UtenteDTO[] utentiDTO = objectMapper.readValue(utentiJson, UtenteDTO[].class);

            for (UtenteDTO dto : utentiDTO) {
                Tableutenti utente = new Tableutenti();
                utente.setNomeutente(dto.getNomeutente());
                utente.setLatitudine(Double.parseDouble(dto.getLatitudine()));
                utente.setLongitudine(Double.parseDouble(dto.getLongitudine()));

                utenteRepository.save(utente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
