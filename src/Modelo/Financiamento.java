package Modelo;

public class Financiamento {

    // Atributos
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    // Getter
    public double getValorImovel() {
        return this.valorImovel;
    }

    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    // Construtor
    public Financiamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        this.valorImovel = valorDesejadoImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }
    // Métodos
    public double calcularPagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual/12));
    }

    public double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento;
    }

    public void mostrarDadosFinanciamento() {
        System.out.println("\n=== Dados do Financiamento ===");
        System.out.printf("Valor do Imóvel: R$ %.2f\n", this.valorImovel);
        System.out.printf("Prazo: %d anos\n", this.prazoFinanciamento);
        System.out.printf("Taxa de Juros Anual: %.2f%%\n", this.taxaJurosAnual);
        System.out.printf("Pagamento Mensal Aproximado: R$ %.2f\n", this.calcularPagamentoMensal());
        System.out.printf("Total a Pagar ao final do financiamento: R$ %.2f\n", this.calcularTotalPagamento());
    }
}

