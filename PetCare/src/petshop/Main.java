package petshop;

import petshop.model.Cliente;
import petshop.model.Compromisso;
import petshop.model.HistoricoMedico;
import petshop.model.Pet;
import petshop.services.CompromissoService;
import petshop.services.PetService;
import petshop.services.UsuarioService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsuarioService usuarioService = UsuarioService.INSTANCE;
        PetService petService = PetService.INSTANCE;
        CompromissoService compromissoService = CompromissoService.INSTANCE;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Sistema de Login =====");
            System.out.println("1. Cadastrar Conta");
            System.out.println("2. Fazer Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: {
                    System.out.print("Digite o seu nome: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o seu email: ");
                    String emailCliente = scanner.nextLine();
                    System.out.print("Digite o seu CPF: ");
                    String cpfCliente = scanner.nextLine();
                    System.out.print("Digite a sua senha: ");
                    String senhaCliente = scanner.nextLine();

                    usuarioService.cadastrar(nomeCliente, emailCliente, cpfCliente, senhaCliente);
                    break;
                }

                case 2: {
                    System.out.print("Digite o email para login: ");
                    String emailCliente = scanner.nextLine();
                    System.out.print("Digite a senha para login: ");
                    String senhaCliente = scanner.nextLine();

                    Cliente clienteLogado = usuarioService.login(emailCliente, senhaCliente);

                    if (clienteLogado != null) {
                        while (true) {
                            System.out.println("\n===== Sistema de Animais =====");
                            System.out.println("1. Cadastrar Animal");
                            System.out.println("2. Listar Animais");
                            System.out.println("3. Agendar Compromisso");
                            System.out.println("4. Listar Compromissos");
                            System.out.println("5. Adicionar Histórico Médico");
                            System.out.println("6. Listar Histórico Médico");
                            System.out.println("7. Sair");
                            System.out.print("Escolha uma opção: ");
                            int opcaoAnimal = scanner.nextInt();
                            scanner.nextLine();

                            switch (opcaoAnimal) {
                                case 1: {
                                    System.out.print("Digite o nome do animal: ");
                                    String nomeAnimal = scanner.nextLine();
                                    System.out.print("Digite a idade do animal: ");
                                    int idadeAnimal = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.print("Digite o sexo do animal (M/F): ");
                                    char sexoAnimal = scanner.nextLine().charAt(0);
                                    System.out.print("Digite o peso do animal: ");
                                    double pesoAnimal = scanner.nextDouble();
                                    scanner.nextLine();

                                    petService.cadastrarPet(nomeAnimal, idadeAnimal, sexoAnimal, pesoAnimal, clienteLogado);
                                    break;
                                }

                                case 2: {
                                    List<Pet> animais = clienteLogado.getPets();
                                    if (animais.isEmpty()) {
                                        System.out.println("Este cliente não tem animais cadastrados.");
                                    } else {
                                        for (Pet p : animais) {
                                            System.out.println("Nome do animal: " + p.getNome());
                                        }
                                    }
                                    break;
                                }

                                case 3: {
                                    System.out.print("Digite o nome do compromisso: ");
                                    String compromisso = scanner.nextLine();
                                    System.out.print("Digite a data e hora do compromisso (ex: 2025-03-28T15:00): ");
                                    String dataHora = scanner.nextLine();
                                    System.out.print("Digite o local do evento: ");
                                    String local = scanner.nextLine();
                                    System.out.print("Digite os afazeres para o compromisso: ");
                                    String afazeres = scanner.nextLine();

                                    compromissoService.cadastrarCompromisso(compromisso, dataHora, local, afazeres);
                                    break;
                                }

                                case 4: {
                                    List<Compromisso> compromissos = compromissoService.getCompromissos();

                                    if (compromissos.isEmpty()) {
                                        System.out.println("Nenhum compromisso agendado.");
                                    } else {
                                        System.out.println("\nLista de Compromissos:");
                                        for (Compromisso c : compromissos) {
                                            System.out.println("Compromisso: " + c.getCompromisso() +
                                                    " | Data: " + c.getDataHora() +
                                                    " | Local: " + c.getLocal() +
                                                    " | Afazeres: " + c.getAfazeres());
                                        }
                                    }
                                    break;
                                }

                                case 5: {
                                    System.out.print("Digite o nome do animal para adicionar o histórico médico: ");
                                    String nomeAnimalHistorico = scanner.nextLine().trim();

                                    if (clienteLogado.getPets().isEmpty()) {
                                        System.out.println("Este cliente não tem animais cadastrados.");
                                        break;
                                    } else {
                                        System.out.println("Animais cadastrados para o cliente " + clienteLogado.getNome() + ":");
                                        for (Pet p : clienteLogado.getPets()) {
                                            System.out.println(p.getNome());
                                        }
                                    }

                                    Pet petEncontrado = null;
                                    for (Pet p : clienteLogado.getPets()) {
                                        if (p.getNome().equalsIgnoreCase(nomeAnimalHistorico)) {
                                            petEncontrado = p;
                                            break;
                                        }
                                    }

                                    if (petEncontrado != null) {
                                        System.out.print("Digite o motivo da consulta: ");
                                        String motivo = scanner.nextLine();
                                        System.out.print("Digite o diagnóstico: ");
                                        String diagnostico = scanner.nextLine();
                                        System.out.print("Digite os tratamentos realizados: ");
                                        String tratamentos = scanner.nextLine();
                                        System.out.print("Digite as vacinas aplicadas: ");
                                        String vacinas = scanner.nextLine();
                                        System.out.print("Digite as prescrições médicas: ");
                                        String prescricoes = scanner.nextLine();
                                        System.out.print("Digite observações adicionais: ");
                                        String observacoes = scanner.nextLine();

                                        HistoricoMedico historico = new HistoricoMedico(motivo, diagnostico, tratamentos, vacinas, prescricoes, observacoes);
                                        petEncontrado.adicionarHistorico(historico);
                                        System.out.println("Histórico médico adicionado com sucesso!");
                                    } else {
                                        System.out.println("Animal não encontrado.");
                                    }
                                }


                                case 6: {
                                    System.out.print("Digite o nome do animal para listar o histórico: ");
                                    String nomeAnimalListar = scanner.nextLine();
                                    Pet petParaListarHistorico = null;

                                    for (Pet p : clienteLogado.getPets()) {
                                        if (p.getNome().equalsIgnoreCase(nomeAnimalListar)) {
                                            petParaListarHistorico = p;
                                            break;
                                        }
                                    }

                                    if (petParaListarHistorico != null) {
                                        petParaListarHistorico.listarHistorico();
                                    } else {
                                        System.out.println("Animal não encontrado.");
                                    }
                                    break;
                                }

                                case 7: {
                                    System.out.println("Saindo...");
                                    return;
                                }

                                default:
                                    System.out.println("Opção inválida. Tente novamente.");
                            }
                        }
                    } else {
                        System.out.println("Login ou senha incorretos.");
                    }
                    break;
                }

                case 3:
                    System.out.println("Saindo... Até logo!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
