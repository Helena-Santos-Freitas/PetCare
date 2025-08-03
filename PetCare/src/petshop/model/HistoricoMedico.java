package petshop.model;

import java.time.LocalDateTime;

public class HistoricoMedico {
    private String motivo;
    private String diagnostico;
    private String tratamentos;
    private String vacinas;
    private String prescricoes;
    private String observacoes;
    private LocalDateTime dataConsulta;

    public HistoricoMedico(String motivo, String diagnostico, String tratamentos, String vacinas, String prescricoes, String observacoes) {
        this.motivo = motivo;
        this.diagnostico = diagnostico;
        this.tratamentos = tratamentos;
        this.vacinas = vacinas;
        this.prescricoes = prescricoes;
        this.observacoes = observacoes;
        this.dataConsulta = LocalDateTime.now();
    }

    public String getMotivo() {
        return motivo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public String getTratamentos() {
        return tratamentos;
    }

    public String getVacinas() {
        return vacinas;
    }

    public String getPrescricoes() {
        return prescricoes;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setTratamentos(String tratamentos) {
        this.tratamentos = tratamentos;
    }

    public void setVacinas(String vacinas) {
        this.vacinas = vacinas;
    }

    public void setPrescricoes(String prescricoes) {
        this.prescricoes = prescricoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public void exibirHistorico() {
        System.out.println("Motivo da consulta: " + motivo);
        System.out.println("Diagnóstico: " + diagnostico);
        System.out.println("Tratamentos realizados: " + tratamentos);
        System.out.println("Vacinas aplicadas: " + vacinas);
        System.out.println("Prescrições médicas: " + prescricoes);
        System.out.println("Observações: " + observacoes);
        System.out.println("Data da consulta: " + dataConsulta);
    }
}
