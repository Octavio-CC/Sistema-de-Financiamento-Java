package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class interfaceUsuario {
    public Scanner scanner;

    public interfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public double pedirValorImovel() {
        double valor = 0;
        while (true) {
            try {
                System.out.print("Qual o valor do imovel? R$: ");
                valor = scanner.nextDouble();
                if (valor > 0 && valor <= 1_000_000_000) break;
                else System.out.println("Valor inválido!");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número decimal.");
                scanner.next();
            }
        }
        return valor;
    }

    public int pedirPrazoFinanciamento() {
        int prazo = 0;
        while (true) {
            try {
                System.out.print("Prazo do financiamento (anos): ");
                prazo = scanner.nextInt();
                if (prazo > 0 && prazo <= 50) break;
                else System.out.println("Prazo inválido!");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número inteiro.");
                scanner.next();
            }
        }
        return prazo;
    }

    public double pedirTaxaJuros() {
        double taxa = 0;
        while (true) {
            try {
                System.out.print("Taxa de juros anual (%): ");
                taxa = scanner.nextDouble();
                if (taxa > 0 && taxa <= 100) break;
                else System.out.println("Taxa inválida!");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite um número decimal.");
                scanner.next();
            }
        }
        return taxa;
    }

    public double pedirAreaConstruida() {
        double area = 0;
        while (true) {
            try {
                System.out.print("Área construída (m²): ");
                area = scanner.nextDouble();
                if (area > 0) break;
                else System.out.println("Área inválida!");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida!");
                scanner.next();
            }
        }
        return area;
    }

    public double pedirTamanhoTerreno() {
        double tamanho = 0;
        while (true) {
            try {
                System.out.print("Tamanho do terreno (m²): ");
                tamanho = scanner.nextDouble();
                if (tamanho > 0) break;
                else System.out.println("Tamanho inválido!");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida!");
                scanner.next();
            }
        }
        return tamanho;
    }

    public int pedirVagasGaragem() {
        int vagas = 0;
        while (true) {
            try {
                System.out.print("Vagas na garagem: ");
                vagas = scanner.nextInt();
                if (vagas >= 0) break;
                else System.out.println("Número inválido!");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida!");
                scanner.next();
            }
        }
        return vagas;
    }

    public int pedirAndar() {
        int andar = 0;
        while (true) {
            try {
                System.out.print("Número do andar: ");
                andar = scanner.nextInt();
                if (andar >= 0) break;
                else System.out.println("Andar inválido!");
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida!");
                scanner.next();
            }
        }
        return andar;
    }

    public String pedirZona() {
        String zona;
        while (true) {
            try {
                System.out.print("Zona (residencial/comercial): ");
                zona = scanner.next();
                if (!zona.trim().isEmpty()) break;
                else System.out.println("Zona inválida!");
            } catch (Exception e) {
                System.out.println("Erro ao ler a zona.");
                scanner.next();
            }
        }
        return zona;
    }

    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}