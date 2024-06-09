package it.unife.BEtop5.Top5BE.IntegrazioneSocialeCalendari.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unife.BEtop5.Top5BE.IntegrazioneSocialeCalendari.models.Tablecalendari;
import it.unife.BEtop5.Top5BE.IntegrazioneSocialeCalendari.models.CalendarioDTO;
import it.unife.BEtop5.Top5BE.IntegrazioneSocialeCalendari.repositories.Repocalendari;

/* Annotation per dichiarare la classe come servizio Spring */
@Service
public class CalendarioSaveService {

    @Autowired
    private Repocalendari calendarioRepository;

    /* Metodo che salva le informazioni sugli eventi sul database a partire da una stringa JSON */
    public void saveCalendari(String calendariJson) {

        try {
            /* Creazione oggetto ObjectMapper per la conversione da JSON a oggetti Java */
            ObjectMapper objectMapper = new ObjectMapper();
            /* Deserializzazione stringa JSON in un array di oggetti EventoDTO */
            CalendarioDTO[] calendariDTO = objectMapper.readValue(calendariJson, CalendarioDTO[].class);

            for (CalendarioDTO dto : calendariDTO) {
                /* Creazione oggetto calendario e popolamento dei suoi attributi */
                Tablecalendari calendario = new Tablecalendari();
                calendario.setNomevento(dto.getNomevento());
                calendario.setDescrizonevento(dto.getDescrizionevento());
                calendario.setDataevento(dto.getDataevento());
                calendario.setOrarioevento(dto.getOrarioevento());


                /* Salvataggio oggetto calendario sul database tramite repository */
                calendarioRepository.save(calendario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}