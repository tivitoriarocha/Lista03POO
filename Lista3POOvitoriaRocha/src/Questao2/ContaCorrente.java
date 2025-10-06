package Questao2;

public class ContaCorrente extends ContaBancaria{

    private double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, double saldo, String titular, double limiteChequeEspecial) {
        super(numeroConta, saldo, titular); // Chama construtor da classe pai
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= (this.saldo + this.limiteChequeEspecial)) {
            this.saldo -= valor;
            println("Saque de R$ " + valor + " realizado com sucesso!");
            if (this.saldo < 0) {
                println("Atenção: Você está usando o cheque especial! Saldo negativo: R$ " + this.saldo);
            }
        } else {
            println("Limite insuficiente! Saldo: R$ " + this.saldo + ", Limite cheque especial: R$ " + this.limiteChequeEspecial);
        }
    }

    @Override
    public void consultarSaldo() {
        println("Conta Corrente - Titular: " + titular + ", Conta: " + numeroConta + ", Saldo: R$ " + saldo + ", Limite Cheque Especial: R$ " + limiteChequeEspecial + ", Saldo Disponível: R$ " + (saldo + limiteChequeEspecial));
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

}
