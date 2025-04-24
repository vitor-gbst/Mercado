package modelo;

import java.util.Scanner;

import static main.cadastrarProduto.listaProdutos;

public abstract class OperacaoEstoque {
    protected Scanner input = new Scanner(System.in);
// Método abstrato para ser sobrescrito (polimorfismo)
    public abstract void executar();
// Método comum para buscar produto — reutilizado pelas subclasses
    protected Produto buscarProdutoPorId(int id) {
        for (Produto p : listaProdutos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
