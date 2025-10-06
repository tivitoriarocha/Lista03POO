package Questao9;

public class LivroDidatico extends Livro{

    private String disciplina;

    public LivroDidatico(String titulo, String autor, int anoPublicacao, double preco, String disciplina) {
        super(titulo, autor, anoPublicacao, preco);
        this.disciplina = disciplina;
    }


    @Override
    public double calcularMultaAtraso(int diasAtraso) {
        return diasAtraso * 1.00;
    }

    @Override
    public void exibirFichaCatalografica() {
        println("Livro Didático - Título: " + titulo + ", Autor: " + autor + ", Ano: " + anoPublicacao + ", Disciplina: " + disciplina +
                ", Preço: R$ " + preco + ", Multa/dia: R$ 1,00");
    }

    public String getDisciplina() { return disciplina; }

}
