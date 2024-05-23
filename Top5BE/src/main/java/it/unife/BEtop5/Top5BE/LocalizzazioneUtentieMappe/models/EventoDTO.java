package it.unife.BEtop5.Top5BE.LocalizzazioneUtentieMappe.models;

public class EventoDTO {
    private String idevento;
    private String nomevento;
    private String latitudine;
    private String longitudine;

    public String getIdevento() {
        return idevento;
    }

    public void setIdevento(String idevento) {
        this.idevento = idevento;
    }

    public String getNomevento() {
        return nomevento;
    }

    public void setNomevento(String nomevento) {
        this.nomevento = nomevento;
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
