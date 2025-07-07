package Modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual / 100.0; // de % para decimal
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }

    public void mostrarDadosFinanciamento() {
        System.out.println("\n=== Dados do Financiamento ===");
        System.out.printf("Valor do Imóvel: R$ %.2f\n", valorImovel);
        System.out.printf("Prazo: %d anos\n", prazoFinanciamento);
        System.out.printf("Taxa de Juros Anual: %.2f%%\n", taxaJurosAnual * 100);
        System.out.printf("Pagamento Mensal: R$ %.2f\n", calcularPagamentoMensal());
        System.out.printf("Total a pagar: R$ %.2f\n", calcularTotalPagamento());
    }

    // Método para formatar os dados para o arquivo de texto
    public abstract String toTextFileString();
}