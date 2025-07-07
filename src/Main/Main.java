package Main;

import Modelo.Financiamento;
import Modelo.Casa;
import Modelo.Apartamento;
import Modelo.Terreno;
import Util.interfaceUsuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    private static final String ARQUIVO_TEXTO = "financiamentos.txt";
    private static final String ARQUIVO_SERIALIZADO = "financiamentos.ser";

    public static void main(String[] args) {

        interfaceUsuario interfaceUsuario = new interfaceUsuario();
        List<Financiamento> listaDeFinanciamentos = new ArrayList<>();

        double somaValoresImoveis = 0;
        double somaTotalFinanciamentos = 0;

        char adicionarMais;

        do {
            System.out.println("\n --- Novo Financiamento ---");
            System.out.println("Escolha o tipo de imóvel:");
            System.out.println("1. Casa\n2. Apartamento\n3. Terreno");
            int escolha = -1;
            while(true) {
                try {
                    System.out.print("Sua escolha: ");
                    escolha = interfaceUsuario.scanner.nextInt();
                    if (escolha >= 1 && escolha <= 3) {
                        break;
                    } else {
                        System.out.println("Opção inválida! Escolha 1, 2 ou 3.");
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada inválida! Digite um número inteiro.");
                    interfaceUsuario.scanner.next();
                }
            }
            interfaceUsuario.scanner.nextLine();

            double taxa = interfaceUsuario.pedirTaxaJuros();
            int prazo = interfaceUsuario.pedirPrazoFinanciamento();
            double valor = interfaceUsuario.pedirValorImovel();

            Financiamento financiamentoAtual = null;

            switch (escolha) {
                case 1:
                    double area = interfaceUsuario.pedirAreaConstruida();
                    double terreno = interfaceUsuario.pedirTamanhoTerreno();
                    financiamentoAtual = new Casa(valor, prazo, taxa, area, terreno);
                    break;
                case 2:
                    int vagas = interfaceUsuario.pedirVagasGaragem();
                    int andar = interfaceUsuario.pedirAndar();
                    financiamentoAtual = new Apartamento(valor, prazo, taxa, vagas, andar);
                    break;
                case 3:
                    String zona = interfaceUsuario.pedirZona();
                    financiamentoAtual = new Terreno(valor, prazo, taxa, zona);
                    break;
            }

            listaDeFinanciamentos.add(financiamentoAtual);
            financiamentoAtual.mostrarDadosFinanciamento();

            System.out.print("\nDeseja adicionar outro financiamento? (S/N): ");
            adicionarMais = interfaceUsuario.scanner.next().charAt(0);
            adicionarMais = Character.toUpperCase(adicionarMais);
            interfaceUsuario.scanner.nextLine();
        } while (adicionarMais == 'S');

        for (Financiamento f : listaDeFinanciamentos) {
            somaValoresImoveis += f.getValorImovel();
            somaTotalFinanciamentos += f.calcularTotalPagamento();
        }

        System.out.println("\n=== Resumo Final de Todos os Financiamentos ===");
        System.out.printf("Total dos imóveis financiados: R$ %.2f\n", somaValoresImoveis);
        System.out.printf("Soma total a pagar em todos os financiamentos: R$ %.2f\n", somaTotalFinanciamentos);

        salvarFinanciamentosEmTexto(listaDeFinanciamentos);

        lerFinanciamentosDoTexto();

        salvarFinanciamentosSerializados(listaDeFinanciamentos);

        lerFinanciamentosSerializados();

        interfaceUsuario.closeScanner();
        System.out.println("\nPrograma finalizado. Os dados foram salvos nos arquivos.");
    }

    private static void salvarFinanciamentosEmTexto(List<Financiamento> financiamentos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO_TEXTO))) {
            for (Financiamento f : financiamentos) {
                writer.write(f.toTextFileString());
                writer.newLine();
            }
            System.out.println("\nDados dos financiamentos salvos em: " + ARQUIVO_TEXTO);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados em arquivo de texto: " + e.getMessage());
        }
    }

    private static List<Financiamento> lerFinanciamentosDoTexto() {
        List<Financiamento> financiamentosLidos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO_TEXTO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                String tipo = dados[0];
                double valorImovel = Double.parseDouble(dados[1]);
                double taxaJuros = Double.parseDouble(dados[3]);
                int prazo = Integer.parseInt(dados[4]);

                switch (tipo) {
                    case "Casa":
                        double areaConstruida = Double.parseDouble(dados[5]);
                        double tamanhoTerreno = Double.parseDouble(dados[6]);
                        financiamentosLidos.add(new Casa(valorImovel, prazo, taxaJuros, areaConstruida, tamanhoTerreno));
                        break;
                    case "Apartamento":
                        int vagas = Integer.parseInt(dados[5]);
                        int andar = Integer.parseInt(dados[6]);
                        financiamentosLidos.add(new Apartamento(valorImovel, prazo, taxaJuros, vagas, andar));
                        break;
                    case "Terreno":
                        String zona = dados[5];
                        financiamentosLidos.add(new Terreno(valorImovel, prazo, taxaJuros, zona));
                        break;
                }
            }

            System.out.println("Comprovado: Arquivo de texto lido com sucesso. Financiamentos reconstruídos em memória.");
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de texto não encontrado. Nenhum financiamento lido.");
            return null;
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao ler dados do arquivo de texto: " + e.getMessage());
            System.err.println("Verifique a integridade do arquivo 'financiamentos.txt'.");
            return null;
        }
        return financiamentosLidos;
    }

    private static void salvarFinanciamentosSerializados(List<Financiamento> financiamentos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO_SERIALIZADO))) {
            oos.writeObject(financiamentos);
            System.out.println("Lista de financiamentos serializada e salva em: " + ARQUIVO_SERIALIZADO);
        } catch (IOException e) {
            System.err.println("Erro ao salvar financiamentos serializados: " + e.getMessage());
        }
    }

    private static List<Financiamento> lerFinanciamentosSerializados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO_SERIALIZADO))) {
            @SuppressWarnings("unchecked")
            List<Financiamento> financiamentos = (List<Financiamento>) ois.readObject();
            System.out.println("Comprovado: Arquivo serializado lido com sucesso. Financiamentos reconstruídos em memória.");
            return financiamentos;
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo serializado não encontrado. Nenhum financiamento lido.");
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao ler financiamentos serializados: " + e.getMessage());
            System.err.println("Verifique a integridade do arquivo 'financiamentos.ser'.");
            return null;
        }
    }
}