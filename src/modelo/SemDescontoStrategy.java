package modelo;

import java.io.Serializable; // Importação da interface Serializable

public class SemDescontoStrategy implements CalculoPrecoStrategy, Serializable {
    // É uma boa prática adicionar um serialVersionUID
    private static final long serialVersionUID = 1L;

    @Override
    public double calcularPreco(double precoBase, int quantidade) {
        return precoBase * quantidade;
    }
}