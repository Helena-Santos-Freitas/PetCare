package petshop.services;

import petshop.exceptions.CustomException;
import petshop.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {
    public static final UsuarioService INSTANCE = new UsuarioService();

    private final List<Cliente> clientes = new ArrayList<>();

    private Cliente clienteLogado = new Cliente("test", "test", "test", "123");

    public void cadastrar(String nome, String email, String cpf, String senha) {
        clientes.add(new Cliente(nome, email, cpf, senha));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    public Cliente login(String email, String senha) {
        for (Cliente c : clientes) {
            if (c.getEmail().equals(email) && c.getSenha().equals(senha)) {
                clienteLogado = c;
                System.out.println("Cliente logado com sucesso!");
                return c;
            }
        }

        System.out.println("Email ou senha incorretos.");
        throw new CustomException("Email ou senha incorretos.");
    }

    public Cliente buscarPorNome(String nome) {
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                return c;
            }
        }
        return null;
    }

    public Cliente getClienteLogado() {
        return clienteLogado;
    }

}
