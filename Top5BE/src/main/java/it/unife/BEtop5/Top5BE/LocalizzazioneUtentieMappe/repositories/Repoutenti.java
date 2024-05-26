package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.repositories;

import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models.Tableutenti;
import org.springframework.data.jpa.repository.JpaRepository;

/* Classe che definisce il repository (database) */
public interface Repoutenti extends JpaRepository <Tableutenti, Long> {

}