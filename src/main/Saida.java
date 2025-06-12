package main;

import modelo.OperacaoEstoque;
import modelo.Produto;
import utilis.Persistencia;

import static main.Mercado.menu;
import static main.cadastrarProduto.listaProdutos;

public class Saida extends OperacaoEstoque {
//polimorfismo
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
                Persistencia.salvarProdutos(listaProdutos);
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

