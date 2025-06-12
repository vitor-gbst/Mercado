package main;

import modelo.OperacaoEstoque;
import modelo.Produto;
import utilis.Persistencia;

import static main.Mercado.menu;
import static main.cadastrarProduto.listaProdutos;

public class Entrada extends OperacaoEstoque {
    // Entrada e Saída de produtos têm uma associação com Produto, interagindo com os objetos Produto sem alterar seu ciclo de vida.
//Polimorfismo
    @Override
    public void executar() {
        System.out.println("Informe o ID do produto para entrada de estoque:");
        int id = input.nextInt();

        Produto produto = buscarProdutoPorId(id);

        if (produto != null) {
            System.out.println("Informe a quantidade a ser adicionada:");
            int qtd = input.nextInt();

            if (qtd > 0) {
                produto.setQuantidade(produto.getQuantidade() + qtd);
                Persistencia.salvarProdutos(listaProdutos);
                System.out.println("Estoque atualizado com sucesso!");
            } else {
                System.out.println("Quantidade inválida.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }

        menu();
    }
}
