package Modelo;

public class Apartamento extends Financiamento {
    public Apartamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
    }

    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12; // Taxa anual já convertida em decimal no construtor de Financiamento
        int meses = getPrazoFinanciamento() * 12;

        if (taxaMensal == 0) { // Evitar divisão por zero caso a taxa de juros seja 0
            return getValorImovel() / meses;
        }

        // Fórmula PRICE
        double numerador = getValorImovel() * taxaMensal * Math.pow((1 + taxaMensal), meses);
        double denominador = Math.pow((1 + taxaMensal), meses) - 1;
        return numerador / denominador;
    }
}