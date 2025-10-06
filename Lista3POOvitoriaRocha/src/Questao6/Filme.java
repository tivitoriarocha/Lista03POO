package Questao6;

public class Filme extends Midia{

    private String diretor;
    private String genero;

    public Filme(String titulo, int anoLancamento, int duracao, double preco, String diretor, String genero) {
        super(titulo, anoLancamento, duracao, preco);
        this.diretor = diretor;
        this.genero = genero;
    }

    @Override
    public double calcularPrecoAluguel() {
        return this.preco * 0.15;
    }

    @Override
    public void exibirInfo() {
        println("Filme - Título: " + titulo + ", Ano: " + anoLancamento + ", Duração: " + duracao + "min" + ", Diretor: " + diretor +
                ", Gênero: " + genero + ", Preço: R$ " + preco + ", Aluguel: R$ " + calcularPrecoAluguel() + ", Preço Total: R$ " + calcularPrecoTotal());
    }

    public String getDiretor() { return diretor; }
    public String getGenero() { return genero; }

}
