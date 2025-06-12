package modelo;

import java.util.Date;

public class Fruta extends Produto {
    private static final long serialVersionUID = 1L;
    public Fruta(String nome, double preco, int quantidade, Date validade) {
        super(nome, preco, quantidade, validade);
    }

    @Override
    public String getTipo() {
        return "Fruta";
    }
}