package Questao7;

public class Futebol extends Esporte {

    private double tamanhoCampo; // em metros

    public Futebol(String nome, int numeroJogadores, int duracaoPartida, String popularidade, double tamanhoCampo) {
        super(nome, numeroJogadores, duracaoPartida, popularidade);
        this.tamanhoCampo = tamanhoCampo;
    }

    @Override
    public double calcularCustoEquipamento() {
        return 300.00;
    }

    @Override
    public void exibirRegras() {
        println("Futebol - Esporte: " + nome + ", Jogadores: " + numeroJogadores + ", Duração: " + duracaoPartida + "min" + ", Popularidade: " + popularidade +
                ", Tamanho do Campo: " + tamanhoCampo + "m" + ", Custo Equipamento: R$ " + calcularCustoEquipamento());
    }

    public double getTamanhoCampo() { return tamanhoCampo; }

}
