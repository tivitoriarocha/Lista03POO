package Questao4;

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
        List<Imovel> imoveis = new ArrayList<Imovel>();

        do {
            print("""
                    \n=== Sistema de Imóveis ===
                    
                    1 - Cadastrar Imóvel
                    2 - Listar Todos os Imóveis
                    3 - Calcular Taxa de um Imóvel
                    0 - Sair
                    
                    Opção:\t""");

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    println("\n--- Cadastrar Imóvel ---");

                    print("Tipo de Imóvel (1-Comum, 2-Apartamento, 3-Casa): ");
                    int tipoImovel = input.nextInt();
                    input.nextLine();

                    print("Endereço: ");
                    String endereco = input.nextLine();

                    print("Área (m²): ");
                    double area = input.nextDouble();

                    print("Número de quartos: ");
                    int quartos = input.nextInt();

                    print("Preço: R$ ");
                    double preco = input.nextDouble();
                    input.nextLine();

                    Imovel imovel = null;

                    if (tipoImovel == 1) {
                        imovel = new Imovel(endereco, area, quartos, preco);
                        println("Imóvel comum cadastrado com sucesso!");
                    }
                    else if (tipoImovel == 2) {
                        print("Andar: ");
                        int andar = input.nextInt();
                        print("Valor do condomínio: R$ ");
                        double condominio = input.nextDouble();
                        input.nextLine();

                        imovel = new Apartamento(endereco, area, quartos, preco, andar, condominio);
                        println("Apartamento cadastrado com sucesso!");
                    }
                    else if (tipoImovel == 3) {
                        print("Área do quintal (m²): ");
                        double areaQuintal = input.nextDouble();
                        input.nextLine();
                        print("Tem piscina? (1-Sim, 2-Não): ");
                        int piscinaOpcao = input.nextInt();
                        boolean temPiscina = (piscinaOpcao == 1);

                        imovel = new Casa(endereco, area, quartos, preco, areaQuintal, temPiscina);
                        println("Casa cadastrada com sucesso!");
                    }
                    else {
                        println("Tipo de imóvel inválido!");
                        break;
                    }

                    imoveis.add(imovel);
                    break;

                case 2:
                    if (!imoveis.isEmpty()) {
                        println("\n=== Todos os Imóveis Cadastrados ===");
                        for (Imovel i : imoveis) {
                            i.exibirCaracteristicas();
                        }
                    } else {
                        println("Nenhum imóvel cadastrado!");
                    }
                    break;

                case 3:
                    if (imoveis.isEmpty()) {
                        println("Nenhum imóvel cadastrado!");
                        break;
                    }

                    println("\n--- Calcular Taxa de um Imóvel ---");
                    println("Imóveis disponíveis:");
                    for (int i = 0; i < imoveis.size(); i++) {
                        println((i + 1) + " - " + imoveis.get(i).getEndereco());
                    }

                    print("Escolha o número do imóvel: ");
                    int numeroImovel = input.nextInt() - 1;

                    if (numeroImovel >= 0 && numeroImovel < imoveis.size()) {
                        Imovel imovelSelecionado = imoveis.get(numeroImovel);

                        println("\n=== Cálculo de Taxa ===");
                        imovelSelecionado.exibirCaracteristicas();

                        double taxa = imovelSelecionado.calcularTaxaAdministracao();
                        double precoOriginal = imovelSelecionado.getPreco();

                        println("\nDetalhes da Taxa:");
                        println("Preço original: R$ " + precoOriginal);
                        println("Valor da taxa: R$ " + taxa);
                        println("Preço total: R$ " + (precoOriginal + taxa));

                        // Mostrar tipo específico e percentual
                        if (imovelSelecionado instanceof Apartamento) {
                            println("Tipo: Apartamento - 6% de taxa");
                        } else if (imovelSelecionado instanceof Casa) {
                            println("Tipo: Casa - 10% de taxa");
                        } else {
                            println("Tipo: Imóvel Comum - 8% de taxa");
                        }
                    } else {
                        println("Número de imóvel inválido!");
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
