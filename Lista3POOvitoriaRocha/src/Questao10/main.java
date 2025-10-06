package Questao10;

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
        List<Transporte> transportes = new ArrayList<Transporte>();

        do {
            print("""
                    \n=== Sistema de Transporte ===
                    
                    1 - Cadastrar Transporte
                    2 - Listar Todos os Transportes
                    3 - Calcular Custo de Viagem
                    0 - Sair
                    
                    Opção:\t""");

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    println("\n--- Cadastrar Transporte ---");

                    print("Tipo de Transporte (1-Transporte Comum, 2-Ônibus, 3-Metrô): ");
                    int tipoTransporte = input.nextInt();
                    input.nextLine();

                    print("Capacidade de passageiros: ");
                    int capacidade = input.nextInt();

                    print("Velocidade máxima (km/h): ");
                    double velocidade = input.nextDouble();

                    print("Consumo (km/l ou km/kWh): ");
                    double consumo = input.nextDouble();

                    print("Preço: R$ ");
                    double preco = input.nextDouble();
                    input.nextLine();

                    Transporte transporte = null;

                    if (tipoTransporte == 1) {
                        transporte = new Transporte(capacidade, velocidade, consumo, preco);
                        println("Transporte comum cadastrado com sucesso!");
                    }
                    else if (tipoTransporte == 2) {
                        print("Número de eixos: ");
                        int eixos = input.nextInt();
                        input.nextLine();

                        transporte = new Onibus(capacidade, velocidade, consumo, preco, eixos);
                        println("Ônibus cadastrado com sucesso!");
                    }
                    else if (tipoTransporte == 3) {
                        print("É elétrico? (1-Sim, 2-Não): ");
                        int eletricoOpcao = input.nextInt();
                        boolean eletrico = (eletricoOpcao == 1);
                        input.nextLine();

                        transporte = new Metro(capacidade, velocidade, consumo, preco, eletrico);
                        println("Metrô cadastrado com sucesso!");
                    }
                    else {
                        println("Tipo de transporte inválido!");
                        break;
                    }

                    transportes.add(transporte);
                    break;

                case 2:
                    if (!transportes.isEmpty()) {
                        println("\n=== Frota de Transportes ===");
                        for (Transporte t : transportes) {
                            t.exibirDados();
                        }
                    } else {
                        println("Nenhum transporte cadastrado!");
                    }
                    break;

                case 3:
                    if (transportes.isEmpty()) {
                        println("Nenhum transporte cadastrado!");
                        break;
                    }

                    println("\n--- Calcular Custo de Viagem ---");
                    println("Transportes disponíveis:");
                    for (int i = 0; i < transportes.size(); i++) {
                        Transporte t = transportes.get(i);
                        println((i + 1) + " - " + t.getCapacidadePassageiros() +
                                " passageiros, " + t.getVelocidadeMaxima() + " km/h");
                    }

                    print("Escolha o número do transporte: ");
                    int numeroTransporte = input.nextInt() - 1;

                    print("Distância da viagem (km): ");
                    double distancia = input.nextDouble();

                    if (numeroTransporte >= 0 && numeroTransporte < transportes.size() && distancia > 0) {
                        Transporte transporteSelecionado = transportes.get(numeroTransporte);

                        println("\n=== Cálculo de Custo de Viagem ===");
                        transporteSelecionado.exibirDados();

                        double custo = transporteSelecionado.calcularCustoViagem(distancia);
                        double custoSemDesconto = (distancia / transporteSelecionado.getConsumo()) * 5.50;

                        println("\nDetalhes da Viagem:");
                        println("Distância: " + distancia + " km");
                        println("Custo base (sem desconto): R$ " + String.format("%.2f", custoSemDesconto));
                        println("Custo final: R$ " + String.format("%.2f", custo));

                        if (transporteSelecionado instanceof Onibus) {
                            println("Tipo: Ônibus - 20% de desconto aplicado");
                            println("Economia: R$ " + String.format("%.2f", (custoSemDesconto - custo)));
                        } else if (transporteSelecionado instanceof Metro) {
                            println("Tipo: Metrô - 30% de desconto aplicado");
                            println("Economia: R$ " + String.format("%.2f", (custoSemDesconto - custo)));
                        } else {
                            println("Tipo: Transporte Comum - Sem desconto");
                        }
                    } else {
                        println("Número de transporte ou distância inválidos!");
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
