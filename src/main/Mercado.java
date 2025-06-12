package main;

import modelo.OperacaoEstoque;
import modelo.Produto; // Certifique-se de que Produto está importado
import java.util.ArrayList;
import java.util.Scanner;

import utilis.Persistencia;

public class Mercado {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // O carregamento e a sincronização do ID já são feitos em Persistencia.carregarProdutos().
        // Apenas precisamos passar a lista carregada para cadastrarProduto.
        ArrayList<Produto> produtosCarregados = Persistencia.carregarProdutos();
        cadastrarProduto.setListaProdutos(produtosCarregados);

        menu();
    }

    // O restante do método menu() permanece inalterado como na sua última correção.
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
            System.out.print("Escolher: ");

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
                        Persistencia.salvarProdutos(cadastrarProduto.listaProdutos);
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