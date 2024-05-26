package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/* Modello della tabella utenti
 * Le annotation indicano che questa classe è un entity bean,
 * mappa una tabella che ha un nome fisico "utenti",
 * con i costruttori, i getter e i setter generati da lombok */
@Entity
@Table(name = "utenti")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Tableutenti {
    @Id     /* Annotation per indicare la chiave primaria della tabella */
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idutente;
    private String nomeutente;
    private double latitudine;
    private double longitudine;
}