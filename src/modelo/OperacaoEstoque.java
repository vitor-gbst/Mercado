package modelo;

import java.util.Scanner;

import static main.cadastrarProduto.listaProdutos;

public abstract class OperacaoEstoque {
    protected Scanner input = new Scanner(System.in);

    public abstract void executar();
    protected Produto buscarProdutoPorId(int id) {// Dependência: Operação de estoque depende de Produto para buscar o produto na lista
// Entrada e Saída de produtos têm uma associação com Produto, interagindo com os objetos Produto sem alterar seu ciclo de vida.

        for (Produto p : listaProdutos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
