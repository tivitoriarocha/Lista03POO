package Questao4;

public class Apartamento extends Imovel{

    private int andar;
    private double valorCondominio;

    public Apartamento(String endereco, double area, int numeroQuartos, double preco, int andar, double valorCondominio) {
        super(endereco, area, numeroQuartos, preco);
        this.andar = andar;
        this.valorCondominio = valorCondominio;
    }

    @Override
    public double calcularTaxaAdministracao() {
        return this.preco * 0.06;
    }

    @Override
    public void exibirCaracteristicas() {
        println("Apartamento - Endereço: " + endereco + ", Área: " + area + "m²" + ", Quartos: " + numeroQuartos + ", Andar: " + andar +
                ", Condomínio: R$ " + valorCondominio + ", Preço: R$ " + preco + ", Taxa: R$ " + calcularTaxaAdministracao() +
                ", Preço Total: R$ " + calcularPrecoComTaxa());
    }

    public int getAndar() { return andar; }
    public double getValorCondominio() { return valorCondominio; }

}
