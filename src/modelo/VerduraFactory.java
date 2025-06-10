package modelo;

import java.util.Date;

// Fábrica Concreta para Verduras
// Implementa a interface ProdutoFactory e define como uma Verdura deve ser criada.
public class VerduraFactory implements ProdutoFactory {
    @Override
    public Produto criarProduto(String nome, double preco, int quantidade, Date validade) {
        // A lógica de criação de uma Verdura é encapsulada aqui.
        return new Verdura(nome, preco, quantidade, validade);
    }
}