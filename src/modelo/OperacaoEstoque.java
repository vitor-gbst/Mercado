package modelo;

import java.util.Scanner;

import static main.cadastrarProduto.listaProdutos;

public abstract class OperacaoEstoque {
    protected Scanner input = new Scanner(System.in);

    public abstract void executar();

    protected Produto buscarProdutoPorId(int id) {
        for (Produto p : listaProdutos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
