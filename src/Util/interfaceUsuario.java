package Util;

import java.util.Scanner;

public class interfaceUsuario {
     public Scanner scanner;

    public interfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    // Métodos
    public double pedirValorImovel() {
        System.out.print("Qual o valor do imovel? R$: ");
        double valor = scanner.nextDouble();

        while (valor <= 0 || valor > 1_000_000_000) {
            System.out.println("Valor inválido! Tente novamente.");
            System.out.println("Qual o valor do imovel? R$:");
            valor = scanner.nextDouble();
        }
        return valor;
    }

    public int pedirPrazoFinanciamento() {
        System.out.println("Qual o prazo do financiamento em anos? ");
        int prazo = scanner.nextInt();

        while (prazo <= 0 || prazo > 50) {
            System.out.println("Prazo inválido! Tente novamente.");
            System.out.println("Qual o prazo do financiamento em anos? ");
            prazo = scanner.nextInt();
        }
        return prazo;
    }

    public double pedirTaxaJuros() {
        System.out.println("Qual a taxa de juros anual (em %)? ");
        double taxa = scanner.nextDouble();

        while (taxa <= 0 || taxa > 100) {
            System.out.println("Taxa de juros inválida! Tente novamente.");
            System.out.println("Qual a taxa de juros anual (em %)? ");
            taxa = scanner.nextDouble();
        }
        return taxa;
    }
}
