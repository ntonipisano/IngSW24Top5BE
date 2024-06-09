package it.unife.BEtop5.Top5BE.IntegrazioneSocialeCalendari.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/* Modello della tabella utenti
 * Le annotation indicano che questa classe è un entity bean,
 * mappa una tabella che ha un nome fisico "calendario",
 * con i costruttori, i getter e i setter generati da lombok */
@Entity
@Table(name = "calendario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Tablecalendari {
    @Id     /* Annotation per indicare la chiave primaria della tabella */
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idevento;
    private String nomevento;
    private String descrizionevento;
    private String dataevento;
    private String orarioevento;


    /* Metodo setDescrizionevento*/ 
    public void setDescrizonevento(String descrizionevento) {
        this.descrizionevento=descrizionevento;
    }
}