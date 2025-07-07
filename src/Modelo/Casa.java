package Modelo;

import Util.AumentoMaiorDoQueJurosException;
import java.io.Serializable;
import java.util.Locale;

public class Casa extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valor, int prazo, double juros, double areaConstruida, double tamanhoTerreno) {
        super(valor, prazo, juros);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double baseMensal = super.getValorImovel() / (super.getPrazoFinanciamento() * 12);
        double jurosMensal = baseMensal * (super.getTaxaJurosAnual() / 12);
        double acrescimo = 80.0;

        try {
            if (acrescimo > (jurosMensal / 2)) {
                throw new AumentoMaiorDoQueJurosException("O acréscimo de R$ 80,00 é maior que a metade dos juros mensais.");
            }
        } catch (AumentoMaiorDoQueJurosException e) {
            System.out.println("⚠️ Atenção: " + e.getMessage());
        }

        return baseMensal + jurosMensal + acrescimo;
    }

    @Override
    public void mostrarDadosFinanciamento() {
        super.mostrarDadosFinanciamento();
        System.out.printf("Área Construída: %.2f m²\n", areaConstruida);
        System.out.printf("Tamanho do Terreno: %.2f m²\n", tamanhoTerreno);
    }

    // Implementação para arquivo de texto
    @Override
    public String toTextFileString() {
        return String.format(Locale.US, "Casa;%.2f;%.2f;%.2f;%d;%.2f;%.2f",
                getValorImovel(), calcularTotalPagamento(), getTaxaJurosAnual() * 100, getPrazoFinanciamento(),
                areaConstruida, tamanhoTerreno);
    }
}