package Questao4;

public class Casa extends Imovel{

    private double areaQuintal;
    private boolean temPiscina;

    public Casa(String endereco, double area, int numeroQuartos, double preco, double areaQuintal, boolean temPiscina) {
        super(endereco, area, numeroQuartos, preco);
        this.areaQuintal = areaQuintal;
        this.temPiscina = temPiscina;
    }

    @Override
    public double calcularTaxaAdministracao() {
        return this.preco * 0.10;
    }

    @Override
    public void exibirCaracteristicas() {
        String piscinaStr = temPiscina ? "Sim" : "Não";
        println("Casa - Endereço: " + endereco + ", Área: " + area + "m²" + ", Quartos: " + numeroQuartos + ", Quintal: " + areaQuintal + "m²" +
                ", Piscina: " + piscinaStr + ", Preço: R$ " + preco + ", Taxa: R$ " + calcularTaxaAdministracao() + ", Preço Total: R$ " + calcularPrecoComTaxa());
    }

    public double getAreaQuintal() { return areaQuintal; }
    public boolean isTemPiscina() { return temPiscina; }

}
