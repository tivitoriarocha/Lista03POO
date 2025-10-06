package Questao5;

public class Notebook extends ProdutoEletronico{

    private String processador;
    private int memoriaRAM;

    public Notebook(String marca, String modelo, double preco, int voltagem, String processador, int memoriaRAM) {
        super(marca, modelo, preco, voltagem);
        this.processador = processador;
        this.memoriaRAM = memoriaRAM;
    }

    @Override
    public double calcularGarantiaEstendida() {
        return this.preco * 0.25;
    }

    @Override
    public void exibirEspecificacoes() {
        println("Notebook - Marca: " + marca + ", Modelo: " + modelo + ", Processador: " + processador + ", Memória RAM: " + memoriaRAM + "GB" +
                ", Voltagem: " + voltagem + "V" + ", Preço: R$ " + preco + ", Garantia Estendida: R$ " + calcularGarantiaEstendida() +
                ", Preço Total: R$ " + calcularPrecoComGarantia());
    }

    public String getProcessador() { return processador; }
    public int getMemoriaRAM() { return memoriaRAM; }

}
