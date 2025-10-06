package Questao10;

public class Metro extends Transporte{

    private boolean eletrico;

    public Metro(int capacidadePassageiros, double velocidadeMaxima, double consumo, double preco, boolean eletrico) {
        super(capacidadePassageiros, velocidadeMaxima, consumo, preco);
        this.eletrico = eletrico;
    }

    @Override
    public double calcularCustoViagem(double distancia) {
        double custoBase = super.calcularCustoViagem(distancia);
        return custoBase * 0.70; // 30% de desconto
    }

    @Override
    public void exibirDados() {
        String tipoEnergia = eletrico ? "Elétrico" : "Diesel";
        println("Metrô - Capacidade: " + capacidadePassageiros + " passageiros" + ", Velocidade Máxima: " + velocidadeMaxima + " km/h" +
                ", Consumo: " + consumo + " km/kWh" + ", Tipo: " + tipoEnergia + ", Preço: R$ " + preco +
                ", Custo/km: R$ " + String.format("%.2f", (5.50 / consumo) * 0.70) + " (com 30% de desconto)");
    }

    public boolean isEletrico() { return eletrico; }

}
