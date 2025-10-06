package Questao7;

public class Esporte {

    protected String nome;
    protected int numeroJogadores;
    protected int duracaoPartida; // em minutos
    protected String popularidade; // Alta, Média, Baixa

    public static void println(String string) {
        System.out.println(string);
    }

    public Esporte(String nome, int numeroJogadores, int duracaoPartida, String popularidade) {
        this.nome = nome;
        this.numeroJogadores = numeroJogadores;
        this.duracaoPartida = duracaoPartida;
        this.popularidade = popularidade;
    }

    public double calcularCustoEquipamento() {
        return 500.00;
    }

    public void exibirRegras() {
        println("Esporte: " + nome + ", Jogadores: " + numeroJogadores + ", Duração: " + duracaoPartida + "min" + ", Popularidade: " + popularidade +
                ", Custo Equipamento: R$ " + calcularCustoEquipamento());
    }

    public String getNome() { return this.nome; }
    public int getNumeroJogadores() { return this.numeroJogadores; }
    public int getDuracaoPartida() { return this.duracaoPartida; }
    public String getPopularidade() { return this.popularidade; }

}
