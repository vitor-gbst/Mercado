package main;

import modelo.OperacaoEstoque;
import modelo.Produto;

import java.util.ArrayList;
import java.util.Scanner;

import utilis.Persistencia;

public class Mercado {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList <Produto> produtos; // Agregação: Mercado "tem" produtos, mas eles existem independentemente
    //Dependência
    // Mercado "agrega" os produtos, mas os produtos não são destruídos quando o Mercado é destruído.
    public static void main(String[] args) {
        produtos = Persistencia.carregarProdutos();
        cadastrarProduto.setListaProdutos(produtos);
        menu();
    }
    public static void menu(){
        int option;

        while (true){
            System.out.println("-------------------------------------");
            System.out.println("--------Bem-vindo ao sistema!--------");
            System.out.println("-------------------------------------");
            System.out.println("*** Selecione a operação desejada ***");
            System.out.println(" ___________________________________ ");
            System.out.println("|      Opção [1] - Cadastrar        |");
            System.out.println("|      Opção [2] - Listar           |");
            System.out.println("|      Opção [3] - Entrada Produtos |");
            System.out.println("|      Opção [4] - Saída Produtos   |");
            System.out.println("|      Opção [5] - Sair             |");
            System.out.println(" ----------------------------------- ");
            System.out.println("Escolher: ");
// Tratamento de erro: garante que a entrada seja um número válido
            if (input.hasNextInt()){
                option = input.nextInt();
                input.nextLine();

                switch (option){
                    case 1:
                        cadastrarProduto.cadastrar();
                        break;
                    case 2:
                        ListarProduto.listar();
                        break;
                    case 3:
                        OperacaoEstoque entrada = new Entrada();
                        entrada.executar();
                        break;
                    case 4:
                        OperacaoEstoque saida = new Saida();
                        saida.executar();
                        break;

                    case 5:
                        System.out.println("Obrigado pela preferência!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Erro: Digite uma das 5 opções.");
                }
            }else {
                System.out.println("Erro, digite um valor válido.");
                input.nextLine();
            }



        }
    }
}
