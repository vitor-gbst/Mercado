package main;

import modelo.Produto;

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
//Tratamento de ERROS
            try {
                preco = Double.parseDouble(precoStr.replace(",", "."));
                precoValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Preço inválido. Tente novamente.");
            }
        }

        System.out.println("Informe a quantidade: ");
        int quantidade = inputCadastro.nextInt();

        Produto novoProduto = new Produto(nome, preco, quantidade);
        listaProdutos.add(novoProduto);

        System.out.println("Produto cadastrado com sucesso!");
        menu();
    }
}
