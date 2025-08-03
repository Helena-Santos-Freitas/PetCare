package petshop.model;

import java.time.LocalDateTime;

public class Compromisso {
    private String compromisso;
    private LocalDateTime dataHora;
    private String local;
    private String afazeres;

    public Compromisso(String compromisso, LocalDateTime dataHora, String local, String afazeres) {
        this.compromisso = compromisso;
        this.dataHora = dataHora;
        this.local = local;
        this.afazeres = afazeres;
    }

    public String getCompromisso() {
        return compromisso;
    }

    public void setCompromisso(String compromisso) {
        this.compromisso = compromisso;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getAfazeres() {
        return afazeres;
    }

    public void setAfazeres(String afazeres) {
        this.afazeres = afazeres;
    }

    @Override
    public String toString() {
        return "Compromisso: " + compromisso +
                "\nData e Hora: " + dataHora +
                "\nLocal: " + local +
                "\nAfazeres: " + afazeres;
    }
}
