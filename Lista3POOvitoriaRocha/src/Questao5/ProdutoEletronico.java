package Questao5;

public class ProdutoEletronico {

    protected String marca;
    protected String modelo;
    protected double preco;
    protected int voltagem;

    public static void println(String string) {
        System.out.println(string);
    }

    public ProdutoEletronico(String marca, String modelo, double preco, int voltagem) {
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.voltagem = voltagem;
    }

    public double calcularGarantiaEstendida() {
        return this.preco * 0.15;
    }

    public double calcularPrecoComGarantia() {
        return this.preco + calcularGarantiaEstendida();
    }

    public void exibirEspecificacoes() {
        println("Produto Eletrônico - Marca: " + marca + ", Modelo: " + modelo + ", Voltagem: " + voltagem + "V" + ", Preço: R$ " + preco +
                ", Garantia Estendida: R$ " + calcularGarantiaEstendida() + ", Preço Total: R$ " + calcularPrecoComGarantia());
    }

    public String getMarca() { return this.marca; }
    public String getModelo() { return this.modelo; }
    public double getPreco() { return this.preco; }
    public int getVoltagem() { return this.voltagem; }

}
