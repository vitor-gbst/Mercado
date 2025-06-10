package modelo;

import java.util.Date;

// Fábrica Concreta para Frutas
// Implementa a interface ProdutoFactory e define como uma Fruta deve ser criada.
public class FrutaFactory implements ProdutoFactory {
    @Override
    public Produto criarProduto(String nome, double preco, int quantidade, Date validade) {
        // A lógica de criação de uma Fruta é encapsulada aqui.
        return new Fruta(nome, preco, quantidade, validade);
    }
}