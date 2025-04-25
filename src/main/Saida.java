package main;

import modelo.OperacaoEstoque;
import modelo.Produto;

import static main.Mercado.menu;

public class Saida extends OperacaoEstoque {

    @Override
    public void executar() {
        System.out.println("Informe o ID do produto para saída de estoque:");
        int id = input.nextInt();

        Produto produto = buscarProdutoPorId(id);

        if (produto != null) {
            System.out.println("Informe a quantidade a ser retirada:");
            int qtd = input.nextInt();

            if (qtd > 0 && qtd <= produto.getQuantidade()) {
                produto.setQuantidade(produto.getQuantidade() - qtd);
                System.out.println("Estoque atualizado com sucesso!");
            } else {
                System.out.println("Quantidade inválida ou insuficiente em estoque.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }

        menu();
    }
}

