package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entities.Alimento;
import model.entities.ItemEstoque;
import model.entities.ProdutoHigiene;
import model.entities.Roupa;

public class App {
    public static void main(String[] args) {
        List<ItemEstoque> itens = new ArrayList<>();

        ItemEstoque i1 = new Alimento("Arroz", 12, 3, "Kg", LocalDate.now());
        itens.add(i1);
        i1 = new Roupa("Agasalho", 3, 1, "F", "G");
        itens.add(i1);
        i1 = new ProdutoHigiene("Escova Oral-B", 10, 1, "Escova");
        itens.add(i1);

        int qtdSoma = 0;
        for (ItemEstoque itemEstoque : itens) {
            qtdSoma += itemEstoque.getQuantidade();
            System.out.println(itemEstoque);
        }
        System.out.println("QtdTotalDeItens = " + qtdSoma);
    }
}   