package Main;

import Modelo.Financiamento;
import Modelo.Casa;
import Modelo.Apartamento;
import Modelo.Terreno;
import Util.interfaceUsuario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        interfaceUsuario interfaceUsuario = new interfaceUsuario();
        List<Financiamento> listaDeFinanciamentos = new ArrayList<>();

        double somaValoresImoveis = 0;
        double somaTotalFinanciamentos = 0;

        // Financiamento 1: Pedir dados do usuário
        System.out.println("\n --- Financiamento 1 (Entrada do Usuário) ---");
        double taxaJurosUser = interfaceUsuario.pedirTaxaJuros();
        int prazoFinanciamentoUser = interfaceUsuario.pedirPrazoFinanciamento();
        double valorImovelUser = interfaceUsuario.pedirValorImovel();

        // Exemplo: Criar uma Casa com os dados do usuário
        Financiamento financiamentoUsuario = new Casa(valorImovelUser, prazoFinanciamentoUser, taxaJurosUser);
        listaDeFinanciamentos.add(financiamentoUsuario);
        financiamentoUsuario.mostrarDadosFinanciamento();

        // Financiamentos pré-definidos (para facilitar testes)
        // Casa 1
        System.out.println("\n --- Financiamento 2 (Casa Pré-definida) ---");
        Financiamento casa1 = new Casa(500000.00, 10, 10.0);
        listaDeFinanciamentos.add(casa1);
        casa1.mostrarDadosFinanciamento();

        // Casa 2
        System.out.println("\n --- Financiamento 3 (Casa Pré-definida) ---");
        Financiamento casa2 = new Casa(300000.00, 15, 8.5);
        listaDeFinanciamentos.add(casa2);
        casa2.mostrarDadosFinanciamento();

        // Apartamento 1
        System.out.println("\n --- Financiamento 4 (Apartamento Pré-definido) ---");
        Financiamento apartamento1 = new Apartamento(400000.00, 12, 9.0);
        listaDeFinanciamentos.add(apartamento1);
        apartamento1.mostrarDadosFinanciamento();

        // Apartamento 2
        System.out.println("\n --- Financiamento 5 (Apartamento Pré-definido) ---");
        Financiamento apartamento2 = new Apartamento(250000.00, 20, 7.5);
        listaDeFinanciamentos.add(apartamento2);
        apartamento2.mostrarDadosFinanciamento();

        // Terreno 1
        System.out.println("\n --- Financiamento 6 (Terreno Pré-definido) ---");
        Financiamento terreno1 = new Terreno(150000.00, 8, 11.0);
        listaDeFinanciamentos.add(terreno1);
        terreno1.mostrarDadosFinanciamento();

        // Calcular e exibir as somas
        for (Financiamento f : listaDeFinanciamentos) {
            somaValoresImoveis += f.getValorImovel();
            somaTotalFinanciamentos += f.calcularTotalPagamento();
        }

        System.out.println("\n=== Soma Final ===");
        System.out.printf("Total de todos os imóveis: R$ %.2f", somaValoresImoveis);
        System.out.printf("\nTotal de todos os financiamentos: R$ %.2f", somaTotalFinanciamentos);

        interfaceUsuario.scanner.close(); // Fechar o scanner ao final do programa
    }
}