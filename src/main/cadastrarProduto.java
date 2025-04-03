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

        System.out.println("Informe o preço do produto: ");
        Double preco = inputCadastro.nextDouble();

        System.out.println("Informe a quantidade: ");
        int quantidade = inputCadastro.nextInt();

        Produto novoProduto = new Produto(nome, preco, quantidade);
        listaProdutos.add(novoProduto);

        System.out.println("Produto cadastrado com sucesso!");
        inputCadastro.close();
        menu();
    }
}
