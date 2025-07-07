package Modelo;

import java.io.Serializable;
import java.util.Locale;

public class Terreno extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private String zona;

    public Terreno(double valor, int prazo, double juros, String zona) {
        super(valor, prazo, juros);
        this.zona = zona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12;
        int meses = getPrazoFinanciamento() * 12;

        if (taxaMensal == 0) return getValorImovel() / meses;

        double numerador = getValorImovel() * taxaMensal * Math.pow((1 + taxaMensal), meses);
        double denominador = Math.pow((1 + taxaMensal), meses) - 1;
        return (numerador / denominador) * 1.02; // +2% de acréscimo para terrenos
    }

    @Override
    public void mostrarDadosFinanciamento() {
        super.mostrarDadosFinanciamento();
        System.out.println("Zona do Terreno: " + zona);
    }

    @Override
    public String toTextFileString() {
        return String.format(Locale.US, "Terreno;%.2f;%.2f;%.2f;%d;%s",
                getValorImovel(), calcularTotalPagamento(), getTaxaJurosAnual() * 100, getPrazoFinanciamento(),
                zona);
    }
}