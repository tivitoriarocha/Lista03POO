package Questao3;

public class CursoOnline extends Curso{

    private String plataforma;

    public CursoOnline(String nome, int cargaHoraria, double preco, String nivel, String plataforma) {
        super(nome, cargaHoraria, preco, nivel); // Chama construtor da classe pai
        this.plataforma = plataforma;
    }

    // Sobrescreve calcularDesconto() - 15% para cursos online
    @Override
    public double calcularDesconto() {
        return this.preco * 0.15;
    }

    // Sobrescreve exibirInformacoes() para incluir plataforma
    @Override
    public void exibirInformacoes() {
        println("Curso Online - " + nome +
                ", Carga Horária: " + cargaHoraria + "h" +
                ", Nível: " + nivel +
                ", Plataforma: " + plataforma +
                ", Preço: R$ " + preco +
                ", Desconto: R$ " + calcularDesconto() +
                ", Preço com Desconto: R$ " + calcularPrecoComDesconto());
    }

    public String getPlataforma() {
        return plataforma;
    }

}
