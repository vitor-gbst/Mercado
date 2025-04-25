package main;

import modelo.Fruta;
import modelo.Produto;
import modelo.Verdura;

import java.util.ArrayList;
import java.util.Scanner;

import static main.Mercado.menu;

public class cadastrarProduto {

    public static ArrayList<Produto> listaProdutos = new ArrayList<>();

    public static void cadastrar(){
        Scanner inputCadastro = new Scanner(System.in);

        System.out.println("Informe o nome do produto: ");
        String nome = inputCadastro.nextLine();

        double preco = 0.0;
        boolean precoValido = false;

        while (!precoValido) {
            System.out.println("Informe o preço do produto: ");
            String precoStr = inputCadastro.nextLine();
            try {
                preco = Double.parseDouble(precoStr.replace(",", "."));
                precoValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Preço inválido. Tente novamente.");
            }
        }

        System.out.println("Informe a quantidade: ");
        int quantidade = inputCadastro.nextInt();
        inputCadastro.nextLine(); // Limpa o buffer

        // ✅ Solicita tipo do produto
        System.out.println("Informe o tipo do produto [1 - Fruta | 2 - Verdura]: ");
        int tipo = inputCadastro.nextInt();

        Produto novoProduto;

        if (tipo == 1) {
            novoProduto = new Fruta(nome, preco, quantidade);
        } else {
            novoProduto = new Verdura(nome, preco, quantidade);
        }

        listaProdutos.add(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");

        menu();
    }
}
