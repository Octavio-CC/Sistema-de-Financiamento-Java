package Main;

import Modelo.Financiamento;
import Util.interfaceUsuario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        interfaceUsuario interfaceUsuario = new interfaceUsuario();
        List<Financiamento> listaDeFinanciamentos = new ArrayList<Financiamento>();

        double somaValoresImoveis = 0;
        double somaTotalFinanciamentos = 0;

        for (int i = 1; i <= 4; i++) {
            System.out.println("\n --- Financiamento " + i + " ---");
            double taxaJuros = interfaceUsuario.pedirTaxaJuros();
            int prazoFinanciamentoEmAnos = interfaceUsuario.pedirPrazoFinanciamento();
            double valorImovel = interfaceUsuario.pedirValorImovel();


            Financiamento novoFinanciamento = new Financiamento(valorImovel, prazoFinanciamentoEmAnos, taxaJuros);
            listaDeFinanciamentos.add(novoFinanciamento);
            novoFinanciamento.mostrarDadosFinanciamento();

            somaValoresImoveis += valorImovel;
            somaTotalFinanciamentos += novoFinanciamento.calcularTotalPagamento();
        }

        System.out.println("\n=== Soma Final ===");
        System.out.printf("Total de todos os imóveis: R$ %.2f", somaValoresImoveis);
        System.out.printf("\nTotal de todos os financiamentos: R$ %.2f", somaTotalFinanciamentos);

    }
}