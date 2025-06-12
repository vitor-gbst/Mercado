package modelo;

import utilis.Utilis;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int count = 1;
    private int id;//associação com ListarProduto, essa associação e unidirecional visto que a lista de produtos associa produto pelo id e produto nao associa lista de produtos de nenhuma forma por isso é unidirecional
    private String nome;
    private Double preco;
    private int quantidade;
    private Date validade;
    private CalculoPrecoStrategy calculoPrecoStrategy;

    public Produto(String nome, Double preco, int quantidade, Date validade) {
        this.id = Produto.count++;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.validade = validade;
        this.calculoPrecoStrategy = new SemDescontoStrategy();
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

    //  MÉTODO ABSTRATO A SER IMPLEMENTADO POR FRUTA E VERDURA
    public abstract String getTipo();

    // NOVOS métodos para usar a estratégia de cálculo de preço
    public void setCalculoPrecoStrategy(CalculoPrecoStrategy strategy) {
        this.calculoPrecoStrategy = strategy;
    }

    public double getPrecoCalculado() {
        return calculoPrecoStrategy.calcularPreco(this.preco, this.quantidade);
    }

    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "|  Id: [" + this.getId() + "]\n"+
                "|  Nome: [" + this.getNome() + "]\n"+
                "|  Quantidade: [" + this.getQuantidade() + "]\n" +
                "|  Preço Unitário: [" + Utilis.doubleToString(this.getPreco()) + "]\n" +
                "|  Preço Total com desconto: [" + Utilis.doubleToString(this.getPrecoCalculado()) + "]\n" +
                "|  Tipo: [" + this.getTipo() + "]\n" +
                "|  Validade: [" + sdf.format(this.getValidade()) + "]";
    }
}
