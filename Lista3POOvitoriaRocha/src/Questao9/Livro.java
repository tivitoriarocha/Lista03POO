package Questao9;

public class Livro {

    protected String titulo;
    protected String autor;
    protected int anoPublicacao;
    protected double preco;

    public static void println(String string) {
        System.out.println(string);
    }

    public Livro(String titulo, String autor, int anoPublicacao, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
    }

    public double calcularMultaAtraso(int diasAtraso) {
        return diasAtraso * 2.00;
    }

    public void exibirFichaCatalografica() {
        println("Livro - Título: " + titulo + ", Autor: " + autor + ", Ano: " + anoPublicacao + ", Preço: R$ " + preco + ", Multa/dia: R$ 2,00");
    }

    public String getTitulo() { return this.titulo; }
    public String getAutor() { return this.autor; }
    public int getAnoPublicacao() { return this.anoPublicacao; }
    public double getPreco() { return this.preco; }

}
