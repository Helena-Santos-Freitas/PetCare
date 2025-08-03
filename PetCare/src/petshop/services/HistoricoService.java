package petshop.services;

import petshop.model.HistoricoMedico;

import java.util.ArrayList;
import java.util.List;

public class HistoricoService {
    public static final HistoricoService INSTANCE = new HistoricoService();

    private final List<HistoricoMedico> historicos = new ArrayList<>();

    public void cadastrarHistorico(String motivo, String diagnostico, String tratamentos, String vacinas, String prescricoes, String observacoes) {
        HistoricoMedico historico = new HistoricoMedico(motivo, diagnostico, tratamentos, vacinas, prescricoes, observacoes);
        historicos.add(historico);
        System.out.println("Histórico criado com sucesso!");
    }

    public List<HistoricoMedico> getHistoricos() {
        return historicos;
    }
}
