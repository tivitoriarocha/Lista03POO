package Questao10;

public class Transporte {

    protected int capacidadePassageiros;
    protected double velocidadeMaxima;
    protected double consumo; // km/l ou km/kWh
    protected double preco;

    public static void println(String string) {
        System.out.println(string);
    }

    public Transporte(int capacidadePassageiros, double velocidadeMaxima, double consumo, double preco) {
        this.capacidadePassageiros = capacidadePassageiros;
        this.velocidadeMaxima = velocidadeMaxima;
        this.consumo = consumo;
        this.preco = preco;
    }

    public double calcularCustoViagem(double distancia) {
        return (distancia / consumo) * 5.50;
    }

    public void exibirDados() {
        println("Transporte - Capacidade: " + capacidadePassageiros + " passageiros" + ", Velocidade Máxima: " + velocidadeMaxima + " km/h" +
                ", Consumo: " + consumo + " km/l" + ", Preço: R$ " + preco + ", Custo/km: R$ " + String.format("%.2f", (5.50 / consumo)));
    }

    public int getCapacidadePassageiros() { return this.capacidadePassageiros; }
    public double getVelocidadeMaxima() { return this.velocidadeMaxima; }
    public double getConsumo() { return this.consumo; }
    public double getPreco() { return this.preco; }

}
