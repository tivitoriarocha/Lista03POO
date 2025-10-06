package Questao5;

public class Smartphone extends ProdutoEletronico{

    private double tamanhoTela;
    private int capacidadeBateria;

    public Smartphone(String marca, String modelo, double preco, int voltagem, double tamanhoTela, int capacidadeBateria) {
        super(marca, modelo, preco, voltagem);
        this.tamanhoTela = tamanhoTela;
        this.capacidadeBateria = capacidadeBateria;
    }

    @Override
    public double calcularGarantiaEstendida() {
        return this.preco * 0.20;
    }

    @Override
    public void exibirEspecificacoes() {
        println("Smartphone - Marca: " + marca + ", Modelo: " + modelo + ", Tela: " + tamanhoTela + " polegadas" +
                ", Bateria: " + capacidadeBateria + "mAh" + ", Voltagem: " + voltagem + "V" + ", Preço: R$ " + preco +
                ", Garantia Estendida: R$ " + calcularGarantiaEstendida() + ", Preço Total: R$ " + calcularPrecoComGarantia());
    }

    public double getTamanhoTela() { return tamanhoTela; }
    public int getCapacidadeBateria() { return capacidadeBateria; }

}
