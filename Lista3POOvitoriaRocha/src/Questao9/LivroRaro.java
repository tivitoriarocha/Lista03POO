package Questao9;

public class LivroRaro extends Livro{

    private boolean edicaoLimitada;

    public LivroRaro(String titulo, String autor, int anoPublicacao, double preco, boolean edicaoLimitada) {
        super(titulo, autor, anoPublicacao, preco);
        this.edicaoLimitada = edicaoLimitada;
    }

    @Override
    public double calcularMultaAtraso(int diasAtraso) {
        return diasAtraso * 5.00;
    }

    @Override
    public void exibirFichaCatalografica() {
        String edicaoStr = edicaoLimitada ? "Sim" : "Não";
        println("Livro Raro - Título: " + titulo + ", Autor: " + autor + ", Ano: " + anoPublicacao + ", Edição Limitada: " + edicaoStr +
                ", Preço: R$ " + preco + ", Multa/dia: R$ 5,00");
    }

    public boolean isEdicaoLimitada() { return edicaoLimitada; }

}
