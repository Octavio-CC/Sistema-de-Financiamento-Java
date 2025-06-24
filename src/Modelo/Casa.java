package Modelo;

public class Casa extends Financiamento {
    public Casa(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        super(valorDesejadoImovel, prazoFinanciamentoAnos, taxaJurosAnual);
    }

    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() + 80;
    }
}