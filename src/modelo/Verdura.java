package modelo;

public class Verdura extends Produto {
    public Verdura(String nome, double preco, int quantidade) {
        super(nome, preco, quantidade);
    }

    @Override
    public String getTipo() {
        return "Verdura";
    }
}

