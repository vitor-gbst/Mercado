package main;

import modelo.*;
import utilis.Persistencia;
import utilis.ValidarData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



public class cadastrarProduto {


    public static ArrayList<Produto> listaProdutos;


    /*
    static {
        listaProdutos = Persistencia.carregarProdutos();
    }
    */

    public static void cadastrar(){
        Scanner inputCadastro = new Scanner(System.in);

        System.out.println("Informe o nome do produto: ");
        String nome = inputCadastro.nextLine();

        double preco = 0.0;
        boolean precoValido = false;

        Date validade = null;
        boolean dataValida = false;

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

        while (!dataValida) {
            System.out.println("Informe a validade (dd/mm/aaaa): ");
            String inputValidade = inputCadastro.nextLine();

            try {
                validade = ValidarData.parse(inputValidade);
                dataValida = true;
            } catch (Exception e) {
                System.out.println("Data inválida! Formato correto: dd/mm/aaaa");
            }
        }

        System.out.println("Informe o tipo do produto [1 - Fruta | 2 - Verdura]: ");
        int tipo = inputCadastro.nextInt();

        ProdutoFactory factory;

        if (tipo == 1) {
            factory = new FrutaFactory();
        } else {
            factory = new VerduraFactory();
        }

        Produto novoProduto = factory.criarProduto(nome, preco, quantidade, validade);

        if (novoProduto.getTipo().equals("Fruta")) {
            novoProduto.setCalculoPrecoStrategy(new DezPorcentoDescontoStrategy());
        } else {
            novoProduto.setCalculoPrecoStrategy(new SemDescontoStrategy());
        }

        // Garante que listaProdutos não seja nula quando um produto é cadastrado pela primeira vez
        // (embora com as mudanças no Mercado.main isso deve ser garantido)
        if (listaProdutos == null) {
            listaProdutos = new ArrayList<>();
        }
        listaProdutos.add(novoProduto);
        Persistencia.salvarProdutos(listaProdutos); // Salva após cada cadastro
        System.out.println("Produto cadastrado com sucesso!");


    }

    public static void setListaProdutos(ArrayList<Produto> produtoExternos){

        listaProdutos = produtoExternos;
    }
}