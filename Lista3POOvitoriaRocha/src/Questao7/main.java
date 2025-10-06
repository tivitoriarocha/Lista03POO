package Questao7;

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
        List<Esporte> esportes = new ArrayList<Esporte>();

        do {
            print("""
                    \n=== Sistema de Esportes ===
                    
                    1 - Cadastrar Esporte
                    2 - Listar Todos os Esportes
                    3 - Calcular Custo de Equipamento
                    0 - Sair
                    
                    Opção:\t""");

            opcao = input.nextInt();
            input.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    println("\n--- Cadastrar Esporte ---");

                    print("Tipo de Esporte (1-Esporte Comum, 2-Futebol, 3-Basquete): ");
                    int tipoEsporte = input.nextInt();
                    input.nextLine();

                    print("Nome do esporte: ");
                    String nome = input.nextLine();

                    print("Número de jogadores: ");
                    int jogadores = input.nextInt();

                    print("Duração da partida (minutos): ");
                    int duracao = input.nextInt();
                    input.nextLine();

                    print("Popularidade (Alta/Média/Baixa): ");
                    String popularidade = input.nextLine();

                    Esporte esporte = null;

                    if (tipoEsporte == 1) {
                        esporte = new Esporte(nome, jogadores, duracao, popularidade);
                        println("Esporte comum cadastrado com sucesso!");
                    }
                    else if (tipoEsporte == 2) {
                        print("Tamanho do campo (metros): ");
                        double tamanhoCampo = input.nextDouble();
                        input.nextLine();

                        esporte = new Futebol(nome, jogadores, duracao, popularidade, tamanhoCampo);
                        println("Futebol cadastrado com sucesso!");
                    }
                    else if (tipoEsporte == 3) {
                        print("Altura da cesta (metros): ");
                        double alturaCesta = input.nextDouble();
                        input.nextLine();

                        esporte = new Basquete(nome, jogadores, duracao, popularidade, alturaCesta);
                        println("Basquete cadastrado com sucesso!");
                    }
                    else {
                        println("Tipo de esporte inválido!");
                        break;
                    }

                    esportes.add(esporte);
                    break;

                case 2:
                    if (!esportes.isEmpty()) {
                        println("\n=== Todos os Esportes Cadastrados ===");
                        for (Esporte e : esportes) {
                            e.exibirRegras();
                        }
                    } else {
                        println("Nenhum esporte cadastrado!");
                    }
                    break;

                case 3:
                    if (esportes.isEmpty()) {
                        println("Nenhum esporte cadastrado!");
                        break;
                    }

                    println("\n--- Calcular Custo de Equipamento ---");
                    println("Esportes disponíveis:");
                    for (int i = 0; i < esportes.size(); i++) {
                        Esporte e = esportes.get(i);
                        println((i + 1) + " - " + e.getNome());
                    }

                    print("Escolha o número do esporte: ");
                    int numeroEsporte = input.nextInt() - 1;

                    if (numeroEsporte >= 0 && numeroEsporte < esportes.size()) {
                        Esporte esporteSelecionado = esportes.get(numeroEsporte);

                        println("\n=== Cálculo de Custo de Equipamento ===");
                        esporteSelecionado.exibirRegras();

                        double custo = esporteSelecionado.calcularCustoEquipamento();

                        println("\nDetalhes do Custo:");
                        println("Esporte: " + esporteSelecionado.getNome());
                        println("Custo do equipamento: R$ " + custo);

                        if (esporteSelecionado instanceof Futebol) {
                            println("Tipo: Futebol - Custo fixo: R$ 300,00");
                        } else if (esporteSelecionado instanceof Basquete) {
                            println("Tipo: Basquete - Custo fixo: R$ 400,00");
                        } else {
                            println("Tipo: Esporte Comum - Custo fixo: R$ 500,00");
                        }
                    } else {
                        println("Número de esporte inválido!");
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
