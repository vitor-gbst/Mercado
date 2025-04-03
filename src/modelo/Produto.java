package modelo;

import jdk.jshell.execution.Util;
import utilis.Utilis;

public class Produto {
    private static int count = 1;
    private int id;
    private String nome;
    private Double preco;
    private int quantidade;

    public Produto(String nome, Double preco, int quantidade) {
        this.id = Produto.count;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        Produto.count += 1;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String toString(){
        return "Id: " + this.getId() +
                "\nNome: " + this.getNome()+
                "\nQuantidade: " + this.getQuantidade()+
                "\nPreço: " + Utilis.doubleToString(this.getPreco());
    }

}
