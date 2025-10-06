package Questao8;

import java.util.List;
import java.util.ArrayList;

public class Prato {

    protected String nome;
    protected double preco;
    protected int tempoPreparo; // em minutos
    protected List<String> ingredientes;

    public static void println(String string) {
        System.out.println(string);
    }

    public Prato(String nome, double preco, int tempoPreparo) {
        this.nome = nome;
        this.preco = preco;
        this.tempoPreparo = tempoPreparo;
        this.ingredientes = new ArrayList<>();
    }

    public void adicionarIngrediente(String ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    public double calcularTaxaServico() {
        return this.preco * 0.10;
    }

    public double calcularPrecoTotal() {
        return this.preco + calcularTaxaServico();
    }

    // Método para exibir cardápio
    public void exibirCardapio() {
        println("Prato - Nome: " + nome + ", Preço: R$ " + preco + ", Tempo de Preparo: " + tempoPreparo + "min" + ", Taxa de Serviço: R$ " + calcularTaxaServico() +
                ", Preço Total: R$ " + calcularPrecoTotal());
        if (!ingredientes.isEmpty()) {
            println("  Ingredientes: " + String.join(", ", ingredientes));
        }
    }

    public String getNome() { return this.nome; }
    public double getPreco() { return this.preco; }
    public int getTempoPreparo() { return this.tempoPreparo; }
    public List<String> getIngredientes() { return this.ingredientes; }

}
