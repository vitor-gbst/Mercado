package modelo;

public class DezPorcentoDescontoStrategy implements CalculoPrecoStrategy {
    @Override
    public double calcularPreco(double precoBase, int quantidade) {
        return precoBase * quantidade * 0.9;
    }
}
