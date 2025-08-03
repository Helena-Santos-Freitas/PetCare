package petshop.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String email;
    private String cpf;
    private String senha;
    private List<Pet> pets;

    public Cliente(String nome, String email, String cpf, String senha) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.pets = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean temAnimais() {
        return !pets.isEmpty();
    }

    public void adicionarPet(Pet animal) {
        this.pets.add(animal);
    }

    public List<Pet> getPets() {
        return pets;
    }

    public Pet buscarAnimalPorNome(String nome) {
        for (Pet p : pets) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        return null;
    }
}
