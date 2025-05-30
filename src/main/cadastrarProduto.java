package main;

import modelo.Fruta;
import modelo.Produto;
import modelo.Verdura;
import utilis.ValidarData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        Produto novoProduto;

        if (tipo == 1) {
            novoProduto = new Fruta(nome, preco, quantidade, validade);
        } else {
            novoProduto = new Verdura(nome, preco, quantidade, validade);
        }

        listaProdutos.add(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");

        menu();
    }
}
