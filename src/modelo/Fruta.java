package modelo;

public class Fruta extends Produto {
    public Fruta(String nome, double preco, int quantidade) {
        super(nome, preco, quantidade);
    }

    @Override
    public String getTipo() {
        return "Fruta";
    }
}