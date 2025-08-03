package petshop.services;

import petshop.exceptions.CustomException;
import petshop.model.Compromisso;
import petshop.utils.DateUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class CompromissoService {
    public static final CompromissoService INSTANCE = new CompromissoService();

    private final List<Compromisso> compromissos = new ArrayList<>();

    public void cadastrarCompromisso(String compromisso, String dataHora, String local, String afazeres) {
        try {
            LocalDateTime data = DateUtils.parseDateTime(dataHora);

            Compromisso novoCompromisso = new Compromisso(compromisso, data, local, afazeres);
            compromissos.add(novoCompromisso);
            System.out.println("Compromisso agendado com sucesso!");
        } catch (DateTimeParseException e) {
            throw new CustomException("Formato de data inválido, use o formato dd/MM/yyyy HH:mm");
        }
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }
}
