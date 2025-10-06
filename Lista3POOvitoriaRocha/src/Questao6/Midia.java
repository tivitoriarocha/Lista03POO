package Questao6;

public class Midia {

    protected String titulo;
    protected int anoLancamento;
    protected int duracao; // em minutos
    protected double preco;

    public static void println(String string) {
        System.out.println(string);
    }

    public Midia(String titulo, int anoLancamento, int duracao, double preco) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.duracao = duracao;
        this.preco = preco;
    }

    public double calcularPrecoAluguel() {
        return this.preco * 0.10;
    }

    public double calcularPrecoTotal() {
        return this.preco + calcularPrecoAluguel();
    }

    public void exibirInfo() {
        println("Mídia - Título: " + titulo + ", Ano: " + anoLancamento + ", Duração: " + duracao + "min" + ", Preço: R$ " + preco +
                ", Aluguel: R$ " + calcularPrecoAluguel() + ", Preço Total: R$ " + calcularPrecoTotal());
    }

    public String getTitulo() { return this.titulo; }
    public int getAnoLancamento() { return this.anoLancamento; }
    public int getDuracao() { return this.duracao; }
    public double getPreco() { return this.preco; }

}
