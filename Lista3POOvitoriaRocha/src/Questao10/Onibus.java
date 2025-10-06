package Questao10;

public class Onibus extends Transporte{

    private int numeroEixos;

    public Onibus(int capacidadePassageiros, double velocidadeMaxima, double consumo, double preco, int numeroEixos) {
        super(capacidadePassageiros, velocidadeMaxima, consumo, preco);
        this.numeroEixos = numeroEixos;
    }

    @Override
    public double calcularCustoViagem(double distancia) {
        double custoBase = super.calcularCustoViagem(distancia);
        return custoBase * 0.80; // 20% de desconto
    }

    @Override
    public void exibirDados() {
        println("Ônibus - Capacidade: " + capacidadePassageiros + " passageiros" + ", Velocidade Máxima: " + velocidadeMaxima + " km/h" +
                ", Consumo: " + consumo + " km/l" + ", Eixos: " + numeroEixos + ", Preço: R$ " + preco +
                ", Custo/km: R$ " + String.format("%.2f", (5.50 / consumo) * 0.80) + " (com 20% de desconto)");
    }

    public int getNumeroEixos() { return numeroEixos; }

}
