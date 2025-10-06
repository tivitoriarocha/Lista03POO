package Questao1;

public class Moto extends Veiculo {

    private int cilindrada;

    public Moto(String marca, String modelo, int ano, double preco, int cilindrada) {
        super(marca, modelo, ano, preco);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularIpva() {
        return this.preco * 0.02;
    }

    @Override
    public void exibirDetalhes() {
        println("Moto - Marca: " + marca + ", Modelo: " + modelo +
                ", Ano: " + ano + ", Preço: R$ " + preco +
                ", Cilindrada: " + cilindrada + "cc" +
                ", IPVA: R$ " + calcularIpva());
    }

    public int getCilindrada() {
        return cilindrada;
    }

}
