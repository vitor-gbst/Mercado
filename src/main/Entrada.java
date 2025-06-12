package main;

import modelo.OperacaoEstoque;
import modelo.Produto;
import utilis.Persistencia;

// 🟢 CORREÇÃO 3: Removida a importação estática de Mercado.menu.
// import static main.Mercado.menu;
import static main.cadastrarProduto.listaProdutos;

public class Entrada extends OperacaoEstoque {
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
                Persistencia.salvarProdutos(listaProdutos); // Salva após a alteração
                System.out.println("Estoque atualizado com sucesso!");
            } else {
                System.out.println("Quantidade inválida.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }


    }
}