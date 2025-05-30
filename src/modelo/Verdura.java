package modelo;

import java.util.Date;

public class Verdura extends Produto {
    public Verdura(String nome, double preco, int quantidade, Date validade) {
        super(nome, preco, quantidade, validade);
    }

    @Override
    public String getTipo() {
        return "Verdura";
    }
}

