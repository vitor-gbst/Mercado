package main;

import modelo.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// 🟢 CORREÇÃO 3: Removida a importação estática de Mercado.menu.
// import static main.Mercado.menu;
import static main.cadastrarProduto.listaProdutos;

public class ListarProduto {

    public static void listar() {
        Scanner input = new Scanner(System.in);
        int opcao;

        while (true) {
            System.out.println(" __________________________________________ ");
            System.out.println("|------------- Menu de Listagem ------------|");
            System.out.println("| 1 - Listar (do primeiro ao último)        |");
            System.out.println("| 2 - Listar (do último ao primeiro)        |");
            System.out.println("| 3 - Produto mais caro / mais barato       |");
            System.out.println("| 4 - Produto com maior / menor quantidade  |");
            System.out.println("| 5 - Produto com validade mais próxima     |");
            System.out.println("| 6 - Listar ordenado por nome           |");
            System.out.println("| 7 - Voltar ao menu principal              |");
            System.out.println(" ------------------------------------------ ");
            System.out.print("Escolha uma opção: ");

            if (!input.hasNextInt()) {
                System.out.println("Entrada inválida! Digite um número.");
                input.nextLine(); // Limpa entrada inválida
                continue;
            }

            opcao = input.nextInt();
            input.nextLine(); // Limpa o buffer

            if (opcao == 7) {

                return;
            }

            // Adicionado null check para listaProdutos para maior robustez
            if (listaProdutos == null || listaProdutos.isEmpty()) {
                System.out.println("Nenhum produto cadastrado.");
                continue;
            }

            switch (opcao) {
                case 1:
                    listarOrdemNormal();
                    break;
                case 2:
                    listarOrdemReversa();
                    break;
                case 3:
                    mostrarMaisCaroMaisBarato();
                    break;
                case 4:
                    mostrarMaiorMenorQuantidade();
                    break;
                case 5:
                    mostrarValidadeMaisProxima();
                    break;
                case 6:
                    listarOrdenadoPorNome();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void listarOrdemNormal() {
        System.out.println("---- Lista de produtos (ordem de cadastro) ----");
        for (Produto p : listaProdutos) {
            System.out.println(p);
            System.out.println(" ___________________________________ \n");
        }
    }

    private static void listarOrdemReversa() {
        System.out.println("---- Lista de produtos (ordem inversa) ----");
        ArrayList<Produto> copia = new ArrayList<>(listaProdutos);
        Collections.reverse(copia);
        for (Produto p : copia) {
            System.out.println(p);
            System.out.println(" ___________________________________ \n");
        }
    }

    private static void mostrarMaisCaroMaisBarato() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto para comparar.");
            return;
        }
        Produto maisCaro = Collections.max(listaProdutos, Comparator.comparing(Produto::getPreco));
        Produto maisBarato = Collections.min(listaProdutos, Comparator.comparing(Produto::getPreco));

        System.out.println("---- Produto mais caro ----");
        System.out.println(maisCaro);
        System.out.println("---- Produto mais barato ----");
        System.out.println(maisBarato);
    }

    private static void mostrarMaiorMenorQuantidade() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto para comparar.");
            return;
        }
        Produto maiorQtd = Collections.max(listaProdutos, Comparator.comparing(Produto::getQuantidade));
        Produto menorQtd = Collections.min(listaProdutos, Comparator.comparing(Produto::getQuantidade));

        System.out.println("---- Produto com MAIOR quantidade ----");
        System.out.println(maiorQtd);
        System.out.println("---- Produto com MENOR quantidade ----");
        System.out.println(menorQtd);
    }

    private static void mostrarValidadeMaisProxima() {
        if (listaProdutos.isEmpty()) {
            System.out.println("Nenhum produto para comparar.");
            return;
        }
        Produto validadeMaisProxima = Collections.min(listaProdutos, Comparator.comparing(Produto::getValidade));

        System.out.println("---- Produto com validade mais próxima ----");
        System.out.println(validadeMaisProxima);
    }
    private static void listarOrdenadoPorNome() {
        ArrayList<Produto> copia = new ArrayList<>(listaProdutos);
        Collections.sort(copia, Comparator.comparing(Produto::getNome, String.CASE_INSENSITIVE_ORDER));

        System.out.println("---- Produtos ordenados por NOME (A-Z) ----");
        for (Produto p : copia) {
            System.out.println(p);
            System.out.println(" ___________________________________ \n");
        }
    }
}