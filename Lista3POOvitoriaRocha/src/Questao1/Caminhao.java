package Questao1;

public class Caminhao extends Veiculo{

    private double capacidadeCarga;

    public Caminhao(String marca, String modelo, int ano, double preco, double capacidadeCarga) {
        super(marca, modelo, ano, preco);
        this.capacidadeCarga = capacidadeCarga;
    }

    @Override
    public double calcularIpva() {
        return this.preco * 0.015;
    }

    @Override
    public void exibirDetalhes() {
        println("Caminhão - Marca: " + marca + ", Modelo: " + modelo +
                ", Ano: " + ano + ", Preço: R$ " + preco +
                ", Capacidade: " + capacidadeCarga + " toneladas" +
                ", IPVA: R$ " + calcularIpva());
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

}
