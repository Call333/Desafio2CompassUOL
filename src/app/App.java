package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.entities.Alimento;
import model.entities.Centro;
import model.entities.ItemEstoque;
import model.entities.ProdutoHigiene;
import model.entities.Roupa;

public class App {
    public static void main(String[] args) {
        Centro centro01 = new Centro("Centro de Distribuição Esperança", "Av. Boqueirão, 2450 - Igara, Canoas - RS", "92032-420");
        
        Alimento i1 = new Alimento("Arroz", 64, 3, "5Kg", LocalDate.now());
        centro01.addAlimento(i1);
        Alimento l1 = new Alimento("Arroz", 40, 3, "1Kg", LocalDate.now());
        centro01.addAlimento(l1);
        Roupa i2 = new Roupa("Agasalho", 3, 1, "F", "G");
        centro01.addRoupa(i2);
        // Roupa i3 = new Roupa("Agasalho", 3, 1, "F", "G");
        // centro01.addRoupa(i3);
        // ProdutoHigiene i4 = new ProdutoHigiene("Escova Oral-B", 10, 1, "Escova");
        // centro01.addHigiene(i4);

        int qtdTotal = 0;
        for (ItemEstoque itemEstoque : centro01.getEstoque()) {
            // qtdTotal += itemEstoque.getQuantidade();
            System.out.println(itemEstoque);
        }
        // System.out.println(centro01.getEstoqueTotal());
        // System.out.println(centro01.getEstoqueAlimentos());
        // centro01.getEstoqueAlimentos().remove(1);
        System.out.println("QtdTotalDeItensDeAlimento = " + centro01.contabilizarTotalItensAlimento());
        
        System.out.println("QtdTotalDeItens = " + centro01.contabilizarTotalItens());
    }
}   