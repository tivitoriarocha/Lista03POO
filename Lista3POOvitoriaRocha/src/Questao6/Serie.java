package Questao6;

public class Serie extends Midia{

    private int numeroTemporadas;
    private int episodiosPorTemporada;

    public Serie(String titulo, int anoLancamento, int duracao, double preco, int numeroTemporadas, int episodiosPorTemporada) {
        super(titulo, anoLancamento, duracao, preco);
        this.numeroTemporadas = numeroTemporadas;
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    @Override
    public double calcularPrecoAluguel() {
        return this.preco * 0.12;
    }

    @Override
    public void exibirInfo() {
        int totalEpisodios = numeroTemporadas * episodiosPorTemporada;
        println("Série - Título: " + titulo + ", Ano: " + anoLancamento + ", Duração por episódio: " + duracao + "min" + ", Temporadas: " + numeroTemporadas +
                ", Episódios por temporada: " + episodiosPorTemporada + ", Total de episódios: " + totalEpisodios + ", Preço: R$ " + preco +
                ", Aluguel: R$ " + calcularPrecoAluguel() + ", Preço Total: R$ " + calcularPrecoTotal());
    }

    public int getNumeroTemporadas() { return numeroTemporadas; }
    public int getEpisodiosPorTemporada() { return episodiosPorTemporada; }

}
