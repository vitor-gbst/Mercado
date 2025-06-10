package modelo;

import java.util.Date;

// Interface da Fábrica (Factory)
// Define o método abstrato para criar um Produto.
// As subclasses desta interface (FrutaFactory, VerduraFactory) serão responsáveis por implementar a lógica de criação
// de seus respectivos tipos de produtos.
public interface ProdutoFactory {
    Produto criarProduto(String nome, double preco, int quantidade, Date validade);
}