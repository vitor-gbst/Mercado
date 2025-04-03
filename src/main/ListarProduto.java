package main;

import modelo.Produto;

import java.util.ArrayList;

import static main.cadastrarProduto.listaProdutos;

public class ListarProduto {
    static ArrayList<Produto>Listagem = listaProdutos;
    public static void listar(){
        System.out.println("Produtos");
        for(int i = 0; i <= Listagem.size(); i++){
        Produto produto = Listagem.get(i);
        System.out.println(produto);
        }
    }

}
