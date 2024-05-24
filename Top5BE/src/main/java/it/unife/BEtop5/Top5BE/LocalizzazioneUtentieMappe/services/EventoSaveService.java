package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models.Tableeventi;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models.EventoDTO;
import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.repositories.Repoeventi;

@Service
public class EventoSaveService {

    @Autowired
    private Repoeventi eventoRepository;

    public void saveEventi(String eventiJson) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            EventoDTO[] eventiDTO = objectMapper.readValue(eventiJson, EventoDTO[].class);

            for (EventoDTO dto : eventiDTO) {
                Tableeventi evento = new Tableeventi();
                evento.setNomevento(dto.getNomevento());
                evento.setLatitudine(Double.parseDouble(dto.getLatitudine()));
                evento.setLongitudine(Double.parseDouble(dto.getLongitudine()));

                eventoRepository.save(evento);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
