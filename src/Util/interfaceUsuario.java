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

        while (valor <= 0) {
            System.out.println("O valor não pode ser igual ou menor que 0! Tente novamente.");
            System.out.println("Qual o valor do imovel? R$:");
            valor = scanner.nextDouble();
        }
        return valor;
    }

    public int pedirPrazoFinanciamento() {
        System.out.println("Qual o prazo do financiamento em anos? ");
        int prazo = scanner.nextInt();

        while (prazo <= 0) {
            System.out.println("O prazo não pode ser igual ou menor que 0! Tente novamente.");
            System.out.println("Qual o prazo do financiamento em anos? ");
            prazo = scanner.nextInt();
        }
        return prazo;
    }

    public double pedirTaxaJuros() {
        System.out.println("Qual a taxa de juros anual (em %)? ");
        double taxa = scanner.nextDouble();

        while (taxa <= 0) {
            System.out.println("A taxa de juros não pode ser igual ou menor que 0! Tente novamente.");
            System.out.println("Qual a taxa de juros anual (em %)? ");
            taxa = scanner.nextDouble();
        }
        return taxa;
    }
}
