package Questao2;

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
        List<ContaBancaria> contas = new ArrayList<ContaBancaria>();

        do {
            print("""
                    \n=== Sistema Bancário ===
                    
                    1 - Abrir Conta Corrente
                    2 - Abrir Conta Poupança
                    3 - Depositar
                    4 - Sacar
                    5 - Consultar Saldo
                    6 - Aplicar Rendimento (Poupança)
                    7 - Listar Todas as Contas
                    0 - Sair
                    
                    Opção:\t""");

            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    print("\n--- Abrir Conta Corrente ---\n");
                    print("Número da conta: ");
                    String numCC = input.next();
                    print("Titular: ");
                    String titularCC = input.next();
                    print("Saldo inicial: R$ ");
                    double saldoCC = input.nextDouble();
                    print("Limite cheque especial: R$ ");
                    double limite = input.nextDouble();

                    ContaCorrente cc = new ContaCorrente(numCC, saldoCC, titularCC, limite);
                    contas.add(cc);
                    print("Conta corrente criada com sucesso!\n");
                    break;

                case 2:
                    print("\n--- Abrir Conta Poupança ---\n");
                    print("Número da conta: ");
                    String numCP = input.next();
                    print("Titular: ");
                    String titularCP = input.next();
                    print("Saldo inicial: R$ ");
                    double saldoCP = input.nextDouble();
                    print("Taxa de rendimento (%): ");
                    double taxa = input.nextDouble();

                    ContaPoupanca cp = new ContaPoupanca(numCP, saldoCP, titularCP, taxa);
                    contas.add(cp);
                    print("Conta poupança criada com sucesso!\n");
                    break;

                case 3:
                    print("\n--- Depositar ---\n");
                    print("Número da conta: ");
                    String numDeposito = input.next();
                    print("Valor: R$ ");
                    double valorDeposito = input.nextDouble();

                    boolean contaEncontradaDep = false;
                    for (ContaBancaria conta : contas) {
                        if (conta.getNumeroConta().equals(numDeposito)) {
                            conta.depositar(valorDeposito);
                            contaEncontradaDep = true;
                            break;
                        }
                    }
                    if (!contaEncontradaDep) {
                        print("Conta não encontrada!\n");
                    }
                    break;

                case 4:
                    print("\n--- Sacar ---\n");
                    print("Número da conta: ");
                    String numSaque = input.next();
                    print("Valor: R$ ");
                    double valorSaque = input.nextDouble();

                    boolean contaEncontradaSaq = false;
                    for (ContaBancaria conta : contas) {
                        if (conta.getNumeroConta().equals(numSaque)) {
                            conta.sacar(valorSaque);
                            contaEncontradaSaq = true;
                            break;
                        }
                    }
                    if (!contaEncontradaSaq) {
                        print("Conta não encontrada!\n");
                    }
                    break;

                case 5:
                    print("\n--- Consultar Saldo ---\n");
                    print("Número da conta: ");
                    String numConsulta = input.next();

                    boolean contaEncontradaCons = false;
                    for (ContaBancaria conta : contas) {
                        if (conta.getNumeroConta().equals(numConsulta)) {
                            conta.consultarSaldo();
                            contaEncontradaCons = true;
                            break;
                        }
                    }
                    if (!contaEncontradaCons) {
                        print("Conta não encontrada!\n");
                    }
                    break;

                case 6:
                    print("\n--- Aplicar Rendimento (Poupança) ---\n");
                    print("Número da conta poupança: ");
                    String numRendimento = input.next();

                    boolean contaEncontradaRen = false;
                    for (ContaBancaria conta : contas) {
                        if (conta instanceof ContaPoupanca && conta.getNumeroConta().equals(numRendimento)) {
                            ((ContaPoupanca) conta).aplicarRendimento();
                            contaEncontradaRen = true;
                            break;
                        }
                    }
                    if (!contaEncontradaRen) {
                        print("Conta poupança não encontrada!\n");
                    }
                    break;

                case 7:
                    if (!contas.isEmpty()) {
                        print("\n=== Todas as Contas ===\n");
                        for (ContaBancaria conta : contas) {
                            conta.consultarSaldo();
                        }
                    } else {
                        print("Nenhuma conta cadastrada!\n");
                    }
                    break;

                case 0:
                    print("Saindo do sistema bancário...\n");
                    continuar = false;
                    break;

                default:
                    print("Opção inválida!\n");
            }
        } while (continuar);
        input.close();
    }

}
