package utilis;

import modelo.Produto;

import java.io.*;
import java.util.ArrayList;

public class Persistencia {
    private static final String CAMINHO_ARQUIVO = "produtos.dat";

    public static void salvarProdutos(ArrayList<Produto> produtos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CAMINHO_ARQUIVO))) {
            oos.writeObject(produtos);
            // System.out.println("Dados salvos com sucesso em " + CAMINHO_ARQUIVO); // Pode descomentar para debug
        } catch (IOException e) {
            System.out.println("Erro ao salvar os produtos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Produto> carregarProdutos() {
        ArrayList<Produto> produtos = new ArrayList<>();
        File arquivo = new File(CAMINHO_ARQUIVO);

        if (!arquivo.exists() || arquivo.length() == 0) {
            // Se o arquivo não existe ou está vazio, retorna uma lista vazia e reseta o ID inicial.
            // 🟢 CORREÇÃO: Inicializa o contador de IDs da classe Produto para 1 se não houver produtos.
            Produto.setNextId(1);
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            produtos = (ArrayList<Produto>) ois.readObject();
            // System.out.println("Dados carregados com sucesso de " + CAMINHO_ARQUIVO); // Pode descomentar para debug

            //  Após carregar os produtos, encontramos o maior ID e atualizamos o contador estático.
            int maxId = 0;
            if (!produtos.isEmpty()) {
                for (Produto p : produtos) {
                    if (p.getId() > maxId) {
                        maxId = p.getId();
                    }
                }
            }
            // Define o próximo ID disponível como o maior ID encontrado + 1.
            Produto.setNextId(maxId + 1);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar os produtos: " + e.getMessage());
            //  Em caso de erro ao carregar, ainda precisamos resetar o ID para 1.
            Produto.setNextId(1);
            return new ArrayList<>();
        }
        return produtos;
    }
}