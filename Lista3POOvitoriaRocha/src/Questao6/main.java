package Questao6;

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
        List<Midia> midias = new ArrayList<Midia>();

        do {
            print("""
                    \n=== Sistema de Entretenimento ===
                    
                    1 - Cadastrar Mídia
                    2 - Listar Todas as Mídias
                    3 - Calcular Aluguel de uma Mídia
                    0 - Sair
                    
                    Opção:\t""");

            opcao = input.nextInt();
            input.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    println("\n--- Cadastrar Mídia ---");

                    print("Tipo de Mídia (1-Mídia Comum, 2-Filme, 3-Série): ");
                    int tipoMidia = input.nextInt();
                    input.nextLine();

                    print("Título: ");
                    String titulo = input.nextLine();

                    print("Ano de lançamento: ");
                    int anoLancamento = input.nextInt();

                    print("Duração (minutos): ");
                    int duracao = input.nextInt();

                    print("Preço: R$ ");
                    double preco = input.nextDouble();
                    input.nextLine();

                    Midia midia = null;

                    if (tipoMidia == 1) {
                        midia = new Midia(titulo, anoLancamento, duracao, preco);
                        println("Mídia comum cadastrada com sucesso!");
                    }
                    else if (tipoMidia == 2) {
                        print("Diretor: ");
                        String diretor = input.nextLine();
                        print("Gênero: ");
                        String genero = input.nextLine();

                        midia = new Filme(titulo, anoLancamento, duracao, preco, diretor, genero);
                        println("Filme cadastrado com sucesso!");
                    }
                    else if (tipoMidia == 3) {
                        print("Número de temporadas: ");
                        int temporadas = input.nextInt();
                        print("Episódios por temporada: ");
                        int episodios = input.nextInt();
                        input.nextLine();

                        midia = new Serie(titulo, anoLancamento, duracao, preco, temporadas, episodios);
                        println("Série cadastrada com sucesso!");
                    }
                    else {
                        println("Tipo de mídia inválido!");
                        break;
                    }

                    midias.add(midia);
                    break;

                case 2:
                    if (!midias.isEmpty()) {
                        println("\n=== Todas as Mídias Cadastradas ===");
                        for (Midia m : midias) {
                            m.exibirInfo();
                        }
                    } else {
                        println("Nenhuma mídia cadastrada!");
                    }
                    break;

                case 3:
                    if (midias.isEmpty()) {
                        println("Nenhuma mídia cadastrada!");
                        break;
                    }

                    println("\n--- Calcular Aluguel de uma Mídia ---");
                    println("Mídias disponíveis:");
                    for (int i = 0; i < midias.size(); i++) {
                        Midia m = midias.get(i);
                        println((i + 1) + " - " + m.getTitulo() + " (" + m.getAnoLancamento() + ")");
                    }

                    print("Escolha o número da mídia: ");
                    int numeroMidia = input.nextInt() - 1;

                    if (numeroMidia >= 0 && numeroMidia < midias.size()) {
                        Midia midiaSelecionada = midias.get(numeroMidia);

                        println("\n=== Cálculo de Aluguel ===");
                        midiaSelecionada.exibirInfo();

                        double aluguel = midiaSelecionada.calcularPrecoAluguel();
                        double precoOriginal = midiaSelecionada.getPreco();

                        println("\nDetalhes do Aluguel:");
                        println("Preço de compra: R$ " + precoOriginal);
                        println("Valor do aluguel: R$ " + aluguel);
                        println("Preço total (compra + aluguel): R$ " + (precoOriginal + aluguel));

                        if (midiaSelecionada instanceof Filme) {
                            println("Tipo: Filme - 15% de aluguel");
                        } else if (midiaSelecionada instanceof Serie) {
                            println("Tipo: Série - 12% de aluguel");
                        } else {
                            println("Tipo: Mídia Comum - 10% de aluguel");
                        }
                    } else {
                        println("Número de mídia inválido!");
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
