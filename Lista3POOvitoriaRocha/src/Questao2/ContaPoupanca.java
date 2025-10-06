package Questao2;

public class ContaPoupanca extends ContaBancaria{

    private double taxaRendimento;

    public ContaPoupanca(String numeroConta, double saldo, String titular, double taxaRendimento) {
        super(numeroConta, saldo, titular); // Chama construtor da classe pai
        this.taxaRendimento = taxaRendimento;
    }

    public void aplicarRendimento() {
        double rendimento = this.saldo * (taxaRendimento / 100);
        this.saldo += rendimento;
        println("Rendimento aplicado! Taxa: " + taxaRendimento + "%, Valor: R$ " + rendimento + ", Novo saldo: R$ " + this.saldo);
    }

    @Override
    public void consultarSaldo() {
        println("Conta Poupança - Titular: " + titular + ", Conta: " + numeroConta + ", Saldo: R$ " + saldo + ", Taxa Rendimento: " + taxaRendimento + "%");
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

}
