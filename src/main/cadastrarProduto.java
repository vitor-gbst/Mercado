package main;

import modelo.*;
import utilis.Persistencia;
import utilis.ValidarData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static main.Mercado.menu;

public class cadastrarProduto {

    public static ArrayList<Produto> listaProdutos = Persistencia.carregarProdutos();

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

        // ✅ Solicita tipo do produto
        System.out.println("Informe o tipo do produto [1 - Fruta | 2 - Verdura]: ");
        int tipo = inputCadastro.nextInt();

        // 🟢 INÍCIO DA APLICAÇÃO DO PADRÃO FACTORY METHOD
        // Agora, a classe cadastrarProduto não instancia diretamente Fruta ou Verdura.
        // Em vez disso, ela usa uma "fábrica" para criar o produto.
        // Isso desacopla a lógica de criação da lógica de uso.
        ProdutoFactory factory; // Declara uma variável do tipo da interface da fábrica

        if (tipo == 1) {
            factory = new FrutaFactory(); // Se for Fruta, usa a Fábrica de Frutas
        } else {
            factory = new VerduraFactory(); // Caso contrário, usa a Fábrica de Verduras
        }

        // Delega a criação do produto para a fábrica selecionada.
        // A classe cadastrarProduto não sabe (e não precisa saber) como Fruta ou Verdura são construídas internamente.
        Produto novoProduto = factory.criarProduto(nome, preco, quantidade, validade);
        // 🟢 FIM DA APLICAÇÃO DO PADRÃO FACTORY METHOD
        if (novoProduto.getTipo().equals("Fruta")) {
            novoProduto.setCalculoPrecoStrategy(new DezPorcentoDescontoStrategy());
        } else {
            novoProduto.setCalculoPrecoStrategy(new SemDescontoStrategy());
        }

        listaProdutos.add(novoProduto);
        Persistencia.salvarProdutos(listaProdutos);
        System.out.println("Produto cadastrado com sucesso!");

    }
    public static void setListaProdutos(ArrayList<Produto> produtoExternos){
        listaProdutos = produtoExternos;
    }
}