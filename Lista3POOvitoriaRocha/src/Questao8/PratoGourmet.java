package Questao8;

import java.util.List;
import java.util.ArrayList;

public class PratoGourmet extends Prato{

    private String chefResponsavel;

    public PratoGourmet(String nome, double preco, int tempoPreparo, String chefResponsavel) {
        super(nome, preco, tempoPreparo);
        this.chefResponsavel = chefResponsavel;
    }

    @Override
    public double calcularTaxaServico() {
        return this.preco * 0.15;
    }

    @Override
    public void exibirCardapio() {
        println("Prato Gourmet - Nome: " + nome + ", Preço: R$ " + preco + ", Tempo de Preparo: " + tempoPreparo + "min" + ", Chef: " + chefResponsavel +
                ", Taxa de Serviço: R$ " + calcularTaxaServico() + ", Preço Total: R$ " + calcularPrecoTotal());
        if (!ingredientes.isEmpty()) {
            println("  Ingredientes: " + String.join(", ", ingredientes));
        }
    }

    public String getChefResponsavel() { return chefResponsavel; }

}
