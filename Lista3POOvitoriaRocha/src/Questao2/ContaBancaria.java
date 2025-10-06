package Questao2;

public class ContaBancaria {

    protected String numeroConta;
    protected double saldo;
    protected String titular;

    public static void println(String string) {
        System.out.println(string);
    }

    public ContaBancaria(String numeroConta, double saldo, String titular) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.titular = titular;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            println("Valor de depósito inválido!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= this.saldo) {
            this.saldo -= valor;
            println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            println("Saldo insuficiente ou valor inválido!");
        }
    }

    public void consultarSaldo() {
        println("Titular: " + titular + ", Conta: " + numeroConta + ", Saldo: R$ " + saldo);
    }

    public String getNumeroConta() { return this.numeroConta; }
    public double getSaldo() { return this.saldo; }
    public String getTitular() { return this.titular; }

}
