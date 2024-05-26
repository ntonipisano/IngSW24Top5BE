package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/* Costruttori, getter e setter della classe generati da lombok */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

/* Classe DTO (Data Transfer Object) per trasferire dati tra i servizi REST e il database */
public class UtenteDTO {
    private String idutente;
    private String nomeutente;
    private String latitudine;
    private String longitudine;
}
