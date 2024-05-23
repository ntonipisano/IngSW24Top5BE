package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "utenti")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Tableutenti {
    @Id
    private Long id;
    private double latitudine;
    private double longitudine;
}