package Questao1;

public class Veiculo {

    protected String marca;
    protected String modelo;
    protected int ano;
    protected double preco;

    public static int qtdVeiculos = 0;

    public static void println(String string) {
        System.out.println(string);
    }

    public Veiculo(String marca, String modelo, int ano, double preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
        qtdVeiculos++;
    }

    public double calcularIpva() {
        return this.preco * 0.04;
    }

    public void exibirDetalhes() {
        println("Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano + ", Preço: R$ " + preco + ", IPVA: R$ " + calcularIpva());
    }


    public String getMarca() {return this.marca;}
    public String getModelo() { return this.modelo; }
    public int getAno() { return this.ano; }
    public double getPreco() { return this.preco; }

}
