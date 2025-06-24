package Util;

import java.util.Scanner;

public class interfaceUsuario {
    public Scanner scanner;

    public interfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    // Métodos
    public double pedirValorImovel() {
        double valor;
        while (true) {
            System.out.print("Qual o valor do imovel? R$: ");
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                if (valor > 0 && valor <= 1_000_000_000) {
                    break;
                } else {
                    System.out.println("Valor inválido! O valor deve ser maior que 0 e menor ou igual a 1.000.000.000. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scanner.next(); // Consumir a entrada inválida
            }
        }
        return valor;
    }

    public int pedirPrazoFinanciamento() {
        int prazo;
        while (true) {
            System.out.print("Qual o prazo do financiamento em anos? ");
            if (scanner.hasNextInt()) {
                prazo = scanner.nextInt();
                if (prazo > 0 && prazo <= 50) {
                    break;
                } else {
                    System.out.println("Prazo inválido! O prazo deve ser maior que 0 e menor ou igual a 50 anos. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
                scanner.next(); // Consumir a entrada inválida
            }
        }
        return prazo;
    }

    public double pedirTaxaJuros() {
        double taxa;
        while (true) {
            System.out.print("Qual a taxa de juros anual (em %)? ");
            if (scanner.hasNextDouble()) {
                taxa = scanner.nextDouble();
                if (taxa > 0 && taxa <= 100) {
                    break;
                } else {
                    System.out.println("Taxa de juros inválida! A taxa deve ser maior que 0 e menor ou igual a 100. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida! Por favor, digite um número.");
                scanner.next(); // Consumir a entrada inválida
            }
        }
        return taxa;
    }
}