package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.Alimento;
import model.entities.Centro;
import model.entities.ItemEstoque;
import model.entities.ProdutoHigiene;
import model.entities.Roupa;

public class App {
    public static void main(String[] args) {

        Centro centro01 = new Centro(1, "Centro de Distribuição Esperança",
                "Av. Boqueirão, 2450 - Igara, Canoas - RS", "92032-420");
        Centro centro02 = new Centro(2, "Centro de Distribuicao Prosperidade",
                "Av. Borges de Medeiros, 1501 - Cidade Baixa, Porto Alegre - RS", "90119-900");
        Centro centro03 = new Centro(3, "Centro de Distribuição Reconstrução",
                "R. Dr. Décio Martins Costa, 312 - Vila Eunice Nova, Cachoeirinha - RS", "90119-900");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu");

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--- Sistema de distruibuicao de doacoes --- ");
            System.out.print("Digite a opção desejada: ");
            int resp = sc.nextInt();
            
            if (resp == 1) {
                System.out.println(
                        "Você deseja cadastrar um item via:"
                                + "\n1 - Arquivo .csv"
                                + "\n2 - Diretamente pelo terminal.");

                resp = sc.nextInt();
                if (resp == 1) {
                    resp = 0;
                    System.out.println("Digite o caminho do arquivo: ");
                    String path = sc.next();

                    
                }
                if (resp == 2) {
                    resp = 0;
                    sc.nextLine();
                    System.out.println(" ---- Formulário de cadastro de itens ---- ");
                    System.out.print("Descricao: ");
                    String descricao = sc.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();
                    System.out.print("Id do centro de distruibuicao: ");
                    int id_centro = sc.nextInt();
                    System.out.println("Qual vai ser o tipo de produto cadastrado? ");
                    System.out.println("1 - Alimento\n2 - Roupas\n3 - Produtos de Higiene");
                    resp = sc.nextInt();
                    sc.nextLine();
                    if (resp == 1) {
                        resp = 0;
                        System.out.print("Peso: ");
                        String peso = sc.next();
                        System.out.print("Validade: ");
                        LocalDate validade = LocalDate.parse(sc.next(), dtf);
                        Alimento alm = new Alimento(descricao, quantidade, id_centro, peso, validade);
                        if (centro01.getId() == id_centro) {
                            centro01.addAlimento(alm);
                        }
                        if (centro02.getId() == id_centro) {
                            centro02.addAlimento(alm);
                        }
                        if (centro03.getId() == id_centro) {
                            centro03.addAlimento(alm);
                        }
                    }

                    if (resp == 2) {
                        resp = 0;
                        System.out.print("Genero: ");
                        String genero = sc.next();
                        System.out.print("Tamanho: ");
                        String tamanho = sc.next();
                        
                        Roupa roupa = new Roupa(descricao, quantidade, id_centro, genero, tamanho);
                        if (centro01.getId() == id_centro) {
                            centro01.addRoupa(roupa);
                        }
                        if (centro02.getId() == id_centro) {
                            centro02.addRoupa(roupa);
                        }
                        if (centro03.getId() == id_centro) {
                            centro03.addRoupa(roupa);
                        }
                    }
                    if (resp == 3) {
                        resp = 0;
                        System.out.print("Tipo: ");
                        String tipo = sc.nextLine();
                        ProdutoHigiene produtoHigiene = new ProdutoHigiene(descricao, quantidade, id_centro, tipo);
                        if (centro01.getId() == id_centro) {
                            centro01.addHigiene(produtoHigiene);
                        }
                        if (centro02.getId() == id_centro) {
                            centro02.addHigiene(produtoHigiene);
                        }
                        if (centro03.getId() == id_centro) {
                            centro03.addHigiene(produtoHigiene);
                        }
                    }
                }
                // Alimento i1 = new Alimento("Arroz", 64, centro01.getId(), "5Kg",
                // LocalDate.now());
                // centro01.addAlimento(i1);
                // Alimento l1 = new Alimento("Arroz", 40, centro01.getId(), "1Kg",
                // LocalDate.now());
                // centro01.addAlimento(l1);
                // Roupa i2 = new Roupa("Agasalho", 3, centro01.getId(), "F", "G");
                // centro01.addRoupa(i2);
                // Roupa i3 = new Roupa("Casaco", 3, centro01.getId(), "M", "GG");
                // centro01.addRoupa(i3);
                // ProdutoHigiene i4 = new ProdutoHigiene("Escova Oral-B", 10, centro01.getId(),
                // "Escova");
                // centro01.addHigiene(i4);

                // for (ItemEstoque itemEstoque : centro01.getEstoque()) {
                // System.out.println(itemEstoque);
                // }

                // System.out.println("Total de Alimentos = " +
                // centro01.contabilizarTotalItensAlimento());
                // System.out.println("Total de Roupas = " +
                // centro01.contabilizarTotalItensRoupa());
                // System.out.println("Total de Higiene = " +
                // centro01.contabilizarTotalItensHigiene());

                // System.out.println("Total de Itens = " + centro01.contabilizarTotalItens());
            }
            if (resp == 2) {
                System.out.println("Quantidade de itens no centro 1");
                if(centro01.getEstoque().isEmpty()){
                    System.out.println("O estoque está vázio");
                }else {
                    for (ItemEstoque item : centro01.getEstoque()) {
                        System.out.println(item);
                    }
                }
                System.out.println("Quantidade de itens no centro 2");
                if(centro02.getEstoque().isEmpty()){
                    System.out.println("O estoque está vázio");
                }else {
                    for (ItemEstoque item : centro02.getEstoque()) {
                        System.out.println(item);
                    }
                }
                
                System.out.println("Quantidade de itens no centro 3");
                if(centro03.getEstoque().isEmpty()){
                    System.out.println("O estoque está vázio");
                }else {
                    for (ItemEstoque item : centro03.getEstoque()) {
                        System.out.println(item);
                    }
                }
            }


            if (resp == 5) {
                sc.close();
                System.out.println("Encerrando o programa.");
                break;
            }
        }

    }
}