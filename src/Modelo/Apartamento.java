package Modelo;

import java.io.Serializable;
import java.util.Locale;

public class Apartamento extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private int vagasGaragem;
    private int andar;

    public Apartamento(double valor, int prazo, double juros, int vagasGaragem, int andar) {
        super(valor, prazo, juros);
        this.vagasGaragem = vagasGaragem;
        this.andar = andar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12;
        int meses = getPrazoFinanciamento() * 12;

        if (taxaMensal == 0) return getValorImovel() / meses;

        double numerador = getValorImovel() * taxaMensal * Math.pow((1 + taxaMensal), meses);
        double denominador = Math.pow((1 + taxaMensal), meses) - 1;
        return numerador / denominador;
    }

    @Override
    public void mostrarDadosFinanciamento() {
        super.mostrarDadosFinanciamento();
        System.out.println("Vagas de Garagem: " + vagasGaragem);
        System.out.println("Andar: " + andar);
    }

    @Override
    public String toTextFileString() {
        return String.format(Locale.US, "Apartamento;%.2f;%.2f;%.2f;%d;%d;%d",
                getValorImovel(), calcularTotalPagamento(), getTaxaJurosAnual() * 100, getPrazoFinanciamento(),
                vagasGaragem, andar);
    }
}