package it.unife.BEtop5.Top5BE.IntegrazioneSocialeCalendari.repositories;

import it.unife.BEtop5.Top5BE.IntegrazioneSocialeCalendari.models.Tablecalendari;
import org.springframework.data.jpa.repository.JpaRepository;

/* Classe che definisce il repository (database) */
public interface Repocalendari extends JpaRepository <Tablecalendari, Long> {

}
