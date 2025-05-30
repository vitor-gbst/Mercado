package modelo;

import utilis.Utilis;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Produto {
    private static int count = 1;
    private int id;//associação com ListarProduto, essa associação e unidirecional visto que a lista de produtos associa produto pelo id e produto nao associa lista de produtos de nenhuma forma por isso é unidirecional
    private String nome;
    private Double preco;
    private int quantidade;
    private Date validade;

    public Produto(String nome, Double preco, int quantidade, Date validade) {
        this.id = Produto.count++;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.validade = validade;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade){
        this.validade = validade;
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

    // ✅ MÉTODO ABSTRATO A SER IMPLEMENTADO POR FRUTA E VERDURA
    public abstract String getTipo();

    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "|  Id: [" + this.getId() + "]\n"+
                "|  Nome: [" + this.getNome() + "]\n"+
                "|  Quantidade: [" + this.getQuantidade() + "]\n" +
                "|  Preço: [" + Utilis.doubleToString(this.getPreco()) + "]\n" +
                "|  Tipo: [" + this.getTipo() + "]\n" +
                "|  Validade: [" + sdf.format(this.getValidade()) + "]";
    }
}
