package modelo;

public class SemDescontoStrategy implements CalculoPrecoStrategy {
    @Override
    public double calcularPreco(double precoBase, int quantidade) {
        return precoBase * quantidade;
    }
}
