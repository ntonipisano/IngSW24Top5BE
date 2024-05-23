package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "utenti")
@Data
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class Tableutenti {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idutente;
    private String nomeutente;
    private double latitudine;
    private double longitudine;
}