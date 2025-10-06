package Questao8;

import java.util.List;
import java.util.ArrayList;

public class PratoVegano extends Prato{

    private String certificacaoVegan;

    public PratoVegano(String nome, double preco, int tempoPreparo, String certificacaoVegan) {
        super(nome, preco, tempoPreparo);
        this.certificacaoVegan = certificacaoVegan;
    }

    @Override
    public double calcularTaxaServico() {
        return this.preco * 0.05;
    }

    @Override
    public void exibirCardapio() {
        println("Prato Vegano - Nome: " + nome + ", Preço: R$ " + preco + ", Tempo de Preparo: " + tempoPreparo + "min" + ", Certificação: " + certificacaoVegan +
                ", Taxa de Serviço: R$ " + calcularTaxaServico() + ", Preço Total: R$ " + calcularPrecoTotal());
        if (!ingredientes.isEmpty()) {
            println("  Ingredientes: " + String.join(", ", ingredientes));
        }
    }

    public String getCertificacaoVegan() { return certificacaoVegan; }

}
