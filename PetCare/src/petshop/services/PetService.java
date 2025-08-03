package petshop.services;

import petshop.model.Cliente;
import petshop.model.Pet;

import java.util.ArrayList;
import java.util.List;

public class PetService {
    public static final PetService INSTANCE = new PetService();

    private final List<Pet> pets = new ArrayList<>();

    public void cadastrarPet(String nomeAnimal, int idadeAnimal, char sexoAnimal, double pesoAnimal, Cliente clienteLogado) {
        Pet novoPet = new Pet(nomeAnimal, idadeAnimal, sexoAnimal, pesoAnimal, clienteLogado);
        clienteLogado.adicionarPet(novoPet);
        pets.add(novoPet);
        System.out.println("Pet cadastrado com sucesso!");
    }

    public void listarPets() {
        if (pets.isEmpty()) {
            System.out.println("Nenhum pet cadastrado.");
        } else {
            System.out.println("\nLista de Pets Cadastrados:");
            for (Pet p : pets) {
                System.out.println("Código: " + p.getCodigo() + " | Nome: " + p.getNome() +
                        " | Idade: " + p.getIdade() + " | Sexo: " + p.getSexo() +
                        " | Peso: " + p.getPeso() + " | Proprietário: " + p.getPaiDePet().getNome());
            }
        }
    }

    public List<Pet> getPets() {
        return pets;
    }
}
