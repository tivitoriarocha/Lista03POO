package Questao3;

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
        List<Curso> cursos = new ArrayList<Curso>();

        do {
            print("""
                    \n=== Sistema de Cursos ===
                    
                    1 - Cadastrar Curso
                    2 - Listar Todos os Cursos
                    3 - Calcular Desconto de um Curso
                    0 - Sair
                    
                    Opção:\t""");

            opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    println("\n--- Cadastrar Curso ---");

                    print("Tipo de Curso (1-Regular, 2-Presencial, 3-Online): ");
                    int tipoCurso = input.nextInt();
                    input.nextLine();

                    print("Nome do curso: ");
                    String nome = input.nextLine();

                    print("Carga horária (h): ");
                    int cargaHoraria = input.nextInt();

                    print("Preço: R$ ");
                    double preco = input.nextDouble();
                    input.nextLine();

                    print("Nível (Básico/Intermediário/Avançado): ");
                    String nivel = input.nextLine();

                    Curso curso = null;

                    if (tipoCurso == 1) {
                        curso = new Curso(nome, cargaHoraria, preco, nivel);
                        println("Curso regular cadastrado com sucesso!");
                    }
                    else if (tipoCurso == 2) {
                        print("Local: ");
                        String local = input.nextLine();
                        curso = new CursoPresencial(nome, cargaHoraria, preco, nivel, local);
                        println("Curso presencial cadastrado com sucesso!");
                    }
                    else if (tipoCurso == 3) {
                        print("Plataforma: ");
                        String plataforma = input.nextLine();
                        curso = new CursoOnline(nome, cargaHoraria, preco, nivel, plataforma);
                        println("Curso online cadastrado com sucesso!");
                    }
                    else {
                        println("Tipo de curso inválido!");
                        break;
                    }

                    cursos.add(curso);
                    break;

                case 2:
                    if (!cursos.isEmpty()) {
                        println("\n=== Todos os Cursos Cadastrados ===");
                        for (Curso c : cursos) {
                            c.exibirInformacoes();
                        }
                    } else {
                        println("Nenhum curso cadastrado!");
                    }
                    break;

                case 3:
                    if (cursos.isEmpty()) {
                        println("Nenhum curso cadastrado!");
                        break;
                    }

                    println("\n--- Calcular Desconto de um Curso ---");
                    println("Cursos disponíveis:");
                    for (int i = 0; i < cursos.size(); i++) {
                        println((i + 1) + " - " + cursos.get(i).getNome());
                    }

                    print("Escolha o número do curso: ");
                    int numeroCurso = input.nextInt() - 1;

                    if (numeroCurso >= 0 && numeroCurso < cursos.size()) {
                        Curso cursoSelecionado = cursos.get(numeroCurso);

                        println("\n=== Cálculo de Desconto ===");
                        cursoSelecionado.exibirInformacoes();

                        double desconto = cursoSelecionado.calcularDesconto();
                        double precoOriginal = cursoSelecionado.getPreco();

                        println("\nDetalhes do Desconto:");
                        println("Preço original: R$ " + precoOriginal);
                        println("Valor do desconto: R$ " + desconto);
                        println("Preço final: R$ " + (precoOriginal - desconto));

                        // Mostrar tipo específico e percentual
                        if (cursoSelecionado instanceof CursoOnline) {
                            println("Tipo: Curso Online - 15% de desconto");
                        } else if (cursoSelecionado instanceof CursoPresencial) {
                            println("Tipo: Curso Presencial - 5% de desconto");
                        } else {
                            println("Tipo: Curso Regular - 10% de desconto");
                        }
                    } else {
                        println("Número de curso inválido!");
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
