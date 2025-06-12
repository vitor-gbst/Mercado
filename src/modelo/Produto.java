package modelo;

import utilis.Utilis;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Produto implements Serializable {
    private static final long serialVersionUID = 1L;

    private static int count;
    private int id;
    private String nome;
    private Double preco;
    private int quantidade;
    private Date validade;
    private CalculoPrecoStrategy calculoPrecoStrategy;

    public Produto(String nome, Double preco, int quantidade, Date validade) {
        // Atribui o ID e incrementa o contador estático.
        // O valor inicial de 'count' será definido por Persistencia.
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

    public abstract String getTipo();

    public void setCalculoPrecoStrategy(CalculoPrecoStrategy strategy) {
        this.calculoPrecoStrategy = strategy;
    }

    public double getPrecoCalculado() {
        // Garante que a estratégia não seja nula antes de calcular.
        if (this.calculoPrecoStrategy == null) {
            this.calculoPrecoStrategy = new SemDescontoStrategy(); // Estratégia padrão se não definida
        }
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

    // 🟢 NOVO MÉTODO: Para permitir que Persistencia atualize o 'count' estático.
    public static void setNextId(int nextId) {
        Produto.count = nextId;
    }
}