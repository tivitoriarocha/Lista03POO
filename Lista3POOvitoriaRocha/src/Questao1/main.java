package Questao1;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void print(String string) {
        System.out.print(string);
    }

    public static void main(String[] args) {
        boolean continuar = true;
        int opcao = 0;
        Scanner input = new Scanner(System.in);
        List<Veiculo> veiculos = new ArrayList<Veiculo>();

        do {
            print("""
                    Sistema de Veículos
                    
                    1 - Adicionar Veículo Comum
                    2 - Adicionar Moto
                    3 - Adicionar Caminhão
                    4 - Listar Veículos
                    5 - Calcular IPVA de Todos
                    0 - Sair
                    
                    Opção:\t""");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    print("Adicionando Veículo Comum\n");
                    print("Marca: ");
                    String marca = input.next();
                    print("Modelo: ");
                    String modelo = input.next();
                    print("Ano: ");
                    int ano = input.nextInt();
                    print("Preço: R$ ");
                    double preco = input.nextDouble();
                    Veiculo veiculo = new Veiculo(marca, modelo, ano, preco);
                    veiculos.add(veiculo);
                    print("Veículo comum adicionado!\n");
                    break;

                case 2:
                    print("Adicionando Moto\n");
                    print("Marca: ");
                    String marcaMoto = input.next();
                    print("Modelo: ");
                    String modeloMoto = input.next();
                    print("Ano: ");
                    int anoMoto = input.nextInt();
                    print("Preço: R$ ");
                    double precoMoto = input.nextDouble();
                    print("Cilindrada (cc): ");
                    int cilindrada = input.nextInt();
                    Moto moto = new Moto(marcaMoto, modeloMoto, anoMoto, precoMoto, cilindrada);
                    veiculos.add(moto);
                    print("Moto adicionada!\n");
                    break;

                case 3:
                    print("Adicionando Caminhão\n");
                    print("Marca: ");
                    String marcaCaminhao = input.next();
                    print("Modelo: ");
                    String modeloCaminhao = input.next();
                    print("Ano: ");
                    int anoCaminhao = input.nextInt();
                    print("Preço: R$ ");
                    double precoCaminhao = input.nextDouble();
                    print("Capacidade (toneladas): ");
                    double capacidade = input.nextDouble();
                    Caminhao caminhao = new Caminhao(marcaCaminhao, modeloCaminhao, anoCaminhao, precoCaminhao, capacidade);
                    veiculos.add(caminhao);
                    print("Caminhão adicionado!\n");
                    break;

                case 4:
                    if (!veiculos.isEmpty()) {
                        print("\n=== Veículos Cadastrados ===\n");
                        for (Veiculo v : veiculos) {
                            v.exibirDetalhes();
                        }
                        print("Total de veículos: " + Veiculo.qtdVeiculos + "\n");
                    } else {
                        print("Nenhum veículo cadastrado!\n");
                    }
                    break;

                case 5:
                    if (!veiculos.isEmpty()) {
                        print("\n=== Cálculo de IPVA ===\n");
                        double totalIpva = 0;
                        for (Veiculo v : veiculos) {
                            double ipva = v.calcularIpva();
                            print(v.getMarca() + " " + v.getModelo() + ": R$ " + ipva + "\n");
                            totalIpva += ipva;
                        }
                        print("Total de IPVA: R$ " + totalIpva + "\n");
                    } else {
                        print("Nenhum veículo cadastrado!\n");
                    }
                    break;

                case 0:
                    print("Saindo ...");
                    continuar = false;
                    break;

                default:
                    print("Opção inválida!\n");
            }
        } while (continuar);
        input.close();
    }

}
