package main;

import modelo.OperacaoEstoque;
import modelo.Produto;

import static main.Mercado.menu;

public class Entrada extends OperacaoEstoque {
//Polimorfismo (sobrescrita do método abstrato executar() )
    @Override
    public void executar() {
        System.out.println("Informe o ID do produto para entrada de estoque:");
        int id = input.nextInt();

        Produto produto = buscarProdutoPorId(id);// Busca o produto na lista (composição)

        if (produto != null) {
            System.out.println("Informe a quantidade a ser adicionada:");
            int qtd = input.nextInt();

            if (qtd > 0) {
                produto.setQuantidade(produto.getQuantidade() + qtd);// Atualiza quantidade
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
