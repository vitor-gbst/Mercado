package main;

import modelo.Produto;

import java.util.ArrayList;

import static main.Mercado.menu;
import static main.cadastrarProduto.listaProdutos;

public class ListarProduto {

    public static void listar(){
        System.out.println(" ___________________________________ ");
        System.out.println("|-------Produtos Cadastrados--------|");
        System.out.println(" ___________________________________ ");

        if (listaProdutos.isEmpty()){
            System.out.println("|-----Nenhum produto cadastrado!----|");
            System.out.println(" ___________________________________ ");
            menu();
        }

        for(int i = 0; i < listaProdutos.size(); i++){
            Produto produto = listaProdutos.get(i);
            System.out.println(produto);
            System.out.println(" ___________________________________ \n");
        }
        menu();
    }

}
