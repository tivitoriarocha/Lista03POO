package Questao8;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void print(String string) {
        System.out.print(string);
    }

    public static void println(String string) {
        System.out.println(string);
    }

    public static void main(String[] args) {
        boolean continuar = true;
        int opcao = 0;
        Scanner input = new Scanner(System.in);
        List<Prato> pratos = new ArrayList<Prato>();

        do {
            print("""
                    \n=== Sistema de Restaurante ===
                    
                    1 - Cadastrar Prato
                    2 - Listar Todos os Pratos
                    3 - Calcular Taxa de Serviço de um Prato
                    0 - Sair
                    
                    Opção:\t""");

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    println("\n--- Cadastrar Prato ---");

                    print("Tipo de Prato (1-Prato Comum, 2-Prato Vegano, 3-Prato Gourmet): ");
                    int tipoPrato = input.nextInt();
                    input.nextLine();

                    print("Nome do prato: ");
                    String nome = input.nextLine();

                    print("Preço: R$ ");
                    double preco = input.nextDouble();

                    print("Tempo de preparo (minutos): ");
                    int tempoPreparo = input.nextInt();
                    input.nextLine();

                    Prato prato = null;

                    if (tipoPrato == 1) {
                        prato = new Prato(nome, preco, tempoPreparo);
                        println("Prato comum cadastrado com sucesso!");
                    }
                    else if (tipoPrato == 2) {
                        print("Certificação vegana: ");
                        String certificacao = input.nextLine();
                        prato = new PratoVegano(nome, preco, tempoPreparo, certificacao);
                        println("Prato vegano cadastrado com sucesso!");
                    }
                    else if (tipoPrato == 3) {
                        print("Chef responsável: ");
                        String chef = input.nextLine();
                        prato = new PratoGourmet(nome, preco, tempoPreparo, chef);
                        println("Prato gourmet cadastrado com sucesso!");
                    }
                    else {
                        println("Tipo de prato inválido!");
                        break;
                    }

                    println("\nAdicionar ingredientes (digite 'fim' para terminar):");
                    while (true) {
                        print("Ingrediente: ");
                        String ingrediente = input.nextLine();
                        if (ingrediente.equalsIgnoreCase("fim")) {
                            break;
                        }
                        prato.adicionarIngrediente(ingrediente);
                    }

                    pratos.add(prato);
                    break;

                case 2:
                    // LISTAGEM SIMPLES
                    if (!pratos.isEmpty()) {
                        println("\n=== Cardápio Completo ===");
                        for (Prato p : pratos) {
                            p.exibirCardapio();
                            println(""); // buffer
                        }
                    } else {
                        println("Nenhum prato cadastrado!");
                    }
                    break;

                case 3:
                    if (pratos.isEmpty()) {
                        println("Nenhum prato cadastrado!");
                        break;
                    }

                    println("\n--- Calcular Taxa de Serviço de um Prato ---");
                    println("Pratos disponíveis:");
                    for (int i = 0; i < pratos.size(); i++) {
                        Prato p = pratos.get(i);
                        println((i + 1) + " - " + p.getNome() + " (R$ " + p.getPreco() + ")");
                    }

                    print("Escolha o número do prato: ");
                    int numeroPrato = input.nextInt() - 1;

                    if (numeroPrato >= 0 && numeroPrato < pratos.size()) {
                        Prato pratoSelecionado = pratos.get(numeroPrato);

                        println("\n=== Cálculo de Taxa de Serviço ===");
                        pratoSelecionado.exibirCardapio();

                        double taxa = pratoSelecionado.calcularTaxaServico();
                        double precoOriginal = pratoSelecionado.getPreco();

                        println("\nDetalhes da Taxa:");
                        println("Prato: " + pratoSelecionado.getNome());
                        println("Preço base: R$ " + precoOriginal);
                        println("Taxa de serviço: R$ " + taxa);
                        println("Preço total: R$ " + (precoOriginal + taxa));

                        if (pratoSelecionado instanceof PratoVegano) {
                            println("Tipo: Prato Vegano - 5% de taxa de serviço");
                        } else if (pratoSelecionado instanceof PratoGourmet) {
                            println("Tipo: Prato Gourmet - 15% de taxa de serviço");
                        } else {
                            println("Tipo: Prato Comum - 10% de taxa de serviço");
                        }
                    } else {
                        println("Número de prato inválido!");
                    }
                    break;

                case 0:
                    println("Saindo do sistema...");
                    continuar = false;
                    break;

                default:
                    println("Opção inválida!");
            }
        } while (continuar);
        input.close();
    }

}
