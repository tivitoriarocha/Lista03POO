package Questao3;

public class Curso {

    protected String nome;
    protected int cargaHoraria;
    protected double preco;
    protected String nivel; // Básico, Intermediário, Avançado

    public static void println(String string) {
        System.out.println(string);
    }

    public Curso(String nome, int cargaHoraria, double preco, String nivel) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.preco = preco;
        this.nivel = nivel;
    }

    public double calcularDesconto() {
        return this.preco * 0.10;
    }

    public double calcularPrecoComDesconto() {
        return this.preco - calcularDesconto();
    }

    public void exibirInformacoes() {
        println("Curso: " + nome + ", Carga Horária: " + cargaHoraria + "h" + ", Nível: " + nivel + ", Preço: R$ " + preco + ", Desconto: R$ " + calcularDesconto() + ", Preço com Desconto: R$ " + calcularPrecoComDesconto());
    }

    public String getNome() { return this.nome; }
    public int getCargaHoraria() { return this.cargaHoraria; }
    public double getPreco() { return this.preco; }
    public String getNivel() { return this.nivel; }


}
