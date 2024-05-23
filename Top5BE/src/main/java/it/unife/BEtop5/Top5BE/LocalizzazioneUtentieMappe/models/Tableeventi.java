package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Entity
@Table(name = "eventi")
@Data
@AllArgsConstructor
@NoArgsConstructor

@Getter
@Setter
public class Tableeventi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idevento;
    private String nomevento;
    private double latitudine;
    private double longitudine;

    /*
    public Long getIdevento() {
        return idevento;
    }

    public void setIdevento(Long idevento) {
        this.idevento = idevento;
    }

    public String getNomevento() {
        return nomevento;
    }

    public void setNomevento(String nomevento) {
        this.nomevento = nomevento;
    }

    public double getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(double latitudine) {
        this.latitudine = latitudine;
    }

    public double getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(double longitudine) {
        this.longitudine = longitudine;
    }
*/
}