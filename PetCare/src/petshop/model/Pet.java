package petshop.model;

import java.util.ArrayList;
import java.util.List;

public class Pet {
    private String nome;
    private int idade;
    private char sexo;
    private double peso;
    private int codigo;
    private Cliente paiDePet;

    private List<HistoricoMedico> historicoMedico;

    public Pet(String nome, int idade, char sexo, double peso, Cliente paiDePet) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.peso = peso;
        this.paiDePet = paiDePet;
        this.historicoMedico = new ArrayList<>();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Cliente getPaiDePet() {
        return paiDePet;
    }

    public void setPaiDePet(Cliente paiDePet) {
        this.paiDePet = paiDePet;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void adicionarHistorico(HistoricoMedico historico) {
        historicoMedico.add(historico);
    }

    public void listarHistorico() {
        if (historicoMedico.isEmpty()) {
            System.out.println("Não há histórico médico registrado para este animal.");
        } else {
            for (HistoricoMedico historico : historicoMedico) {
                historico.exibirHistorico();
                System.out.println("----------------------------------------");
            }
        }
    }
}
