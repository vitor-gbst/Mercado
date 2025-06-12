package utilis;

import modelo.Produto;
import java.io.*;
import java.util.ArrayList;

public class Persistencia {
    private static final String CAMINHO_ARQUIVO = "produtos.dat";

    public static void salvarProdutos(ArrayList<Produto> produtos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CAMINHO_ARQUIVO))) {
            oos.writeObject(produtos);
        } catch (IOException e) {
            System.out.println("Erro ao salvar os produtos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Produto> carregarProdutos() {
        File arquivo = new File(CAMINHO_ARQUIVO);
        if (!arquivo.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            return (ArrayList<Produto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os produtos: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}