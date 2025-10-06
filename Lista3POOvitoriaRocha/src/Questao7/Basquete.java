package Questao7;

public class Basquete extends Esporte{

    private double alturaCesta; // em metros

    public Basquete(String nome, int numeroJogadores, int duracaoPartida, String popularidade, double alturaCesta) {
        super(nome, numeroJogadores, duracaoPartida, popularidade);
        this.alturaCesta = alturaCesta;
    }

    @Override
    public double calcularCustoEquipamento() {
        return 400.00;
    }

    @Override
    public void exibirRegras() {
        println("Basquete - Esporte: " + nome + ", Jogadores: " + numeroJogadores + ", Duração: " + duracaoPartida + "min" + ", Popularidade: " + popularidade +
                ", Altura da Cesta: " + alturaCesta + "m" + ", Custo Equipamento: R$ " + calcularCustoEquipamento());
    }

    public double getAlturaCesta() { return alturaCesta; }

}
