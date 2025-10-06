package Questao3;

public class CursoPresencial extends Curso{

    private String local;

    public CursoPresencial(String nome, int cargaHoraria, double preco, String nivel, String local) {
        super(nome, cargaHoraria, preco, nivel);
        this.local = local;
    }

    @Override
    public double calcularDesconto() {
        return this.preco * 0.05;
    }

    @Override
    public void exibirInformacoes() {
        println("Curso Presencial - " + nome + ", Carga Horária: " + cargaHoraria + "h" + ", Nível: " + nivel + ", Local: " + local + ", Preço: R$ " + preco + ", Desconto: R$ " + calcularDesconto() + ", Preço com Desconto: R$ " + calcularPrecoComDesconto());
    }

    public String getLocal() {
        return local;
    }

}
