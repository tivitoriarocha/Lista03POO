package Questao4;

public class Imovel {

    protected String endereco;
    protected double area;
    protected int numeroQuartos;
    protected double preco;

    public static void println(String string) {
        System.out.println(string);
    }

    public Imovel(String endereco, double area, int numeroQuartos, double preco) {
        this.endereco = endereco;
        this.area = area;
        this.numeroQuartos = numeroQuartos;
        this.preco = preco;
    }

    public double calcularTaxaAdministracao() {
        return this.preco * 0.08;
    }

    public double calcularPrecoComTaxa() {
        return this.preco + calcularTaxaAdministracao();
    }

    public void exibirCaracteristicas() {
        println("Imóvel - Endereço: " + endereco + ", Área: " + area + "m²" + ", Quartos: " + numeroQuartos + ", Preço: R$ " + preco +
                ", Taxa: R$ " + calcularTaxaAdministracao() + ", Preço Total: R$ " + calcularPrecoComTaxa());
    }

    public String getEndereco() { return this.endereco; }
    public double getArea() { return this.area; }
    public int getNumeroQuartos() { return this.numeroQuartos; }
    public double getPreco() { return this.preco; }

}
