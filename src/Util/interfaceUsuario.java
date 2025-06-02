package Util;

import java.util.Scanner;

class interfaceUsuario {
    private Scanner scanner;

    public interfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    // Métodos
    double pedirValorImovel() {
        System.out.print("Qual o valor do imovel? R$: ");
        double valor = scanner.nextDouble();
        return valor;
    }

    int pedirPrazoFinanciamento() {
        System.out.println("Qual o prazo do financiamento em anos? ");
        int prazo = scanner.nextInt();
        return prazo;
    }

    double pedirTaxaJuros() {
        System.out.println("Qual a taxa de juros anual (em %)? ");
        double taxa = scanner.nextDouble();
        return taxa;
    }
}
