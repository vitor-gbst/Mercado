package modelo;

import java.util.Date;

public class Verdura extends Produto {
    private static final long serialVersionUID = 1L;
    public Verdura(String nome, double preco, int quantidade, Date validade) {
        super(nome, preco, quantidade, validade);
    }

    @Override
    public String getTipo() {
        return "Verdura";
    }
}

