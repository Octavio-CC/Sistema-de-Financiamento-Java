import java.util.Scanner;

class Financiamento {

    // Atributos
    double valorImovel;
    int prazoFinanciamento;
    double taxaJurosAnual;

    // Construtor
    Financiamento(double valorDesejadoImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        this.valorImovel = valorDesejadoImovel;
        this.prazoFinanciamento = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
        }
    // Métodos
    double calcularPagamentoMensal() {
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual/12));
    }

    double calcularTotalPagemento() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento;
        }
    }


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

public class Main {
    public static void main(String[] args) {

        interfaceUsuario interfaceUsuario = new interfaceUsuario();
        double taxaJuros = interfaceUsuario.pedirTaxaJuros();
        int prazoFinanciamentoEmAnos = interfaceUsuario.pedirPrazoFinanciamento();
        double valorImovel = interfaceUsuario.pedirValorImovel();

        Financiamento novoFinanciamento = new Financiamento(valorImovel, prazoFinanciamentoEmAnos, taxaJuros);
    }
}