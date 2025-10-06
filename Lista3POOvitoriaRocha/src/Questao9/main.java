package Questao9;

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
        List<Livro> livros = new ArrayList<Livro>();

        do {
            print("""
                    \n=== Sistema de Biblioteca ===
                    
                    1 - Cadastrar Livro
                    2 - Listar Todos os Livros
                    3 - Calcular Multa por Atraso
                    0 - Sair
                    
                    Opção:\t""");

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    println("\n--- Cadastrar Livro ---");

                    print("Tipo de Livro (1-Livro Comum, 2-Livro Didático, 3-Livro Raro): ");
                    int tipoLivro = input.nextInt();
                    input.nextLine();

                    print("Título: ");
                    String titulo = input.nextLine();

                    print("Autor: ");
                    String autor = input.nextLine();

                    print("Ano de publicação: ");
                    int anoPublicacao = input.nextInt();

                    print("Preço: R$ ");
                    double preco = input.nextDouble();
                    input.nextLine();

                    Livro livro = null;

                    if (tipoLivro == 1) {
                        livro = new Livro(titulo, autor, anoPublicacao, preco);
                        println("Livro comum cadastrado com sucesso!");
                    }
                    else if (tipoLivro == 2) {
                        print("Disciplina: ");
                        String disciplina = input.nextLine();
                        livro = new LivroDidatico(titulo, autor, anoPublicacao, preco, disciplina);
                        println("Livro didático cadastrado com sucesso!");
                    }
                    else if (tipoLivro == 3) {
                        print("Edição limitada? (1-Sim, 2-Não): ");
                        int edicaoOpcao = input.nextInt();
                        boolean edicaoLimitada = (edicaoOpcao == 1);
                        input.nextLine();

                        livro = new LivroRaro(titulo, autor, anoPublicacao, preco, edicaoLimitada);
                        println("Livro raro cadastrado com sucesso!");
                    }
                    else {
                        println("Tipo de livro inválido!");
                        break;
                    }

                    livros.add(livro);
                    break;

                case 2:
                    if (!livros.isEmpty()) {
                        println("\n=== Acervo da Biblioteca ===");
                        for (Livro l : livros) {
                            l.exibirFichaCatalografica();
                        }
                    } else {
                        println("Nenhum livro cadastrado!");
                    }
                    break;

                case 3:
                    if (livros.isEmpty()) {
                        println("Nenhum livro cadastrado!");
                        break;
                    }

                    println("\n--- Calcular Multa por Atraso ---");
                    println("Livros disponíveis:");
                    for (int i = 0; i < livros.size(); i++) {
                        Livro l = livros.get(i);
                        println((i + 1) + " - " + l.getTitulo() + " (" + l.getAutor() + ")");
                    }

                    print("Escolha o número do livro: ");
                    int numeroLivro = input.nextInt() - 1;

                    print("Dias de atraso: ");
                    int diasAtraso = input.nextInt();

                    if (numeroLivro >= 0 && numeroLivro < livros.size() && diasAtraso >= 0) {
                        Livro livroSelecionado = livros.get(numeroLivro);

                        println("\n=== Cálculo de Multa por Atraso ===");
                        livroSelecionado.exibirFichaCatalografica();

                        double multa = livroSelecionado.calcularMultaAtraso(diasAtraso);

                        println("\nDetalhes da Multa:");
                        println("Livro: " + livroSelecionado.getTitulo());
                        println("Dias de atraso: " + diasAtraso);
                        println("Valor da multa: R$ " + multa);

                        if (livroSelecionado instanceof LivroDidatico) {
                            println("Tipo: Livro Didático - R$ 1,00 por dia");
                        } else if (livroSelecionado instanceof LivroRaro) {
                            println("Tipo: Livro Raro - R$ 5,00 por dia");
                        } else {
                            println("Tipo: Livro Comum - R$ 2,00 por dia");
                        }
                    } else {
                        println("Número de livro ou dias de atraso inválidos!");
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
