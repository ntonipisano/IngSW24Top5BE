package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models;

public class UtenteDTO {
    private String idutente;
    private String nomeutente;
    private String latitudine;
    private String longitudine;

    public String getIdutente() {
        return idutente;
    }

    public void setIdutente(String idutente) {
        this.idutente = idutente;
    }

    public String getNomeutente() {return nomeutente;
    }

    public void setNomevento(String nomeutente) {
        this.nomeutente = nomeutente;
    }

    public String getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(String latitudine) {
        this.latitudine = latitudine;
    }

    public String getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(String longitudine) {
        this.longitudine = longitudine;
    }
}
