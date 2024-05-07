package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.repositories;

import it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models.Tableeventi;
import org.springframework.data.jpa.repository.JpaRepository;

/* Classe che definisce il repository (database)  */
public interface Repoeventi extends JpaRepository <Tableeventi, Long> {

}