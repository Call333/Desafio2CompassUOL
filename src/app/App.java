package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            System.out.println("Digite a opção desejada: "
                    + "\n1 - Registro de doacoes"
                    + "\n2 - Registro de abrigos"
                    + "\n3 - Ordem de pedido"
                    + "\n4 - Checkout de itens"
                    + "\n5 - Transferência de doações");

            int resp = sc.nextInt();

            if (resp == 1) { // Resp da Linha 41
                System.out.println("O que deseja fazer?"
                        + "\n1 - Cadastrar um item"
                        + "\n2 - Consultar os itens no estoque"
                        + "\n3 - Editar um item"
                        + "\n4 - Excluir um item");
                resp = sc.nextInt();
                // IF de cadastro por CSV ou Terminal.
                if (resp == 1) {
                    resp = 0;
                    System.out.println(
                            "Você deseja cadastrar um item via:"
                                    + "\n1 - Arquivo .csv"
                                    + "\n2 - Diretamente pelo terminal.");
                    resp = sc.nextInt();
                    if (resp == 1) {
                        resp = 0;
                        // System.out.println("Digite o caminho do arquivo: ");
                        // String path = sc.next();

                        File sourcePath = new File("C:\\temp\\in.csv");

                        try (BufferedReader br = new BufferedReader(new FileReader(sourcePath))) {
                            String doacaoCsv = br.readLine();
                            while (doacaoCsv != null) {
                                String[] campos = doacaoCsv.split(",");
                                String tipoDoItem = campos[0];
                                Integer id = null; // Integer.parseInt(campos[1]);
                                String descricao = campos[2];
                                Integer quantidade = Integer.parseInt(campos[3]);
                                int id_centro = Integer.parseInt(campos[4]);
                                if (tipoDoItem.equals("Alimento:")) {
                                    String peso = campos[5];
                                    LocalDate validade = LocalDate.parse(campos[6], dtf);
                                    Alimento alm = new Alimento(id, descricao, quantidade,
                                            id_centro, peso, validade);
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
                                if (tipoDoItem.equals("Roupa:")) {
                                    String genero = campos[5];
                                    String tamanho = campos[6];
                                    Roupa roupa = new Roupa(id, descricao, quantidade,
                                            id_centro, genero, tamanho);
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
                                if (tipoDoItem.equals("Higiene:")) {
                                    String tipo = campos[5];
                                    ProdutoHigiene produtoHigiene = new ProdutoHigiene(id, descricao,
                                            quantidade, id_centro, tipo);
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

                                doacaoCsv = br.readLine();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
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
                            Alimento alm = new Alimento(null, descricao, quantidade, id_centro, peso, validade);
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

                            Roupa roupa = new Roupa(null, descricao, quantidade, id_centro, genero, tamanho);
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
                            ProdutoHigiene produtoHigiene = new ProdutoHigiene(null, descricao, quantidade,
                                    id_centro, tipo);
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
                }
                // IF de consulta dos itens por centro.
                if (resp == 2) { // Resp da Linha 31
                    resp = 0;
                    System.out.println("Quantidade de itens no centro 1: ");
                    if (centro01.getEstoque().isEmpty()) {
                        System.out.println("O estoque está vázio");
                    } else {
                        for (ItemEstoque item : centro01.getEstoque()) {
                            System.out.println(item);
                        }
                    }
                    System.out.println("Quantidade de itens no centro 2: ");
                    if (centro02.getEstoque().isEmpty()) {
                        System.out.println("O estoque está vázio");
                    } else {
                        for (ItemEstoque item : centro02.getEstoque()) {
                            System.out.println(item);
                        }
                    }
                    System.out.println("Quantidade de itens no centro 3");
                    if (centro03.getEstoque().isEmpty()) {
                        System.out.println("O estoque está vázio");
                    } else {
                        for (ItemEstoque item : centro03.getEstoque()) {
                            System.out.println(item);
                        }
                    }
                }
                if (resp == 3) {
                    resp = 0;
                }
                if (resp == 4) {
                    resp = 0;
                    System.out.println("De o número do centro ao qual centro você deseja excluir os itens: "
                            + "\n1 - Centro 01 = " + centro01.getNome()
                            + "\n2 - Centro 02 = " + centro02.getNome()
                            + "\n3 - Centro 03 = " + centro03.getNome());
                    resp = sc.nextInt();
                    if (resp == 1) {
                        resp = 0;
                        System.out.print("Digite o ID do item que deseja excluir: ");
                        int id_procurado = sc.nextInt();
                        ItemEstoque exclu = null;
                        for (ItemEstoque item : centro01.getEstoque()) {
                            if(item.getId() == id_procurado){
                                exclu = item;
                            }
                        }
                        centro01.getEstoque().remove(exclu);
                        
                    }
                    if (resp == 2) {
                        resp = 0;
                        System.out.print("Digite o ID do item que deseja excluir: ");
                        int id_procurado = sc.nextInt();
                        ItemEstoque exclu = null;
                        for (ItemEstoque item : centro02.getEstoque()) {
                            if(item.getId() == id_procurado){
                                exclu = item;
                            }
                        }
                        centro02.getEstoque().remove(exclu);
                    }
                    if (resp == 3) {
                        resp = 0;
                        System.out.print("Digite o ID do item que deseja excluir: ");
                        int id_procurado = sc.nextInt();
                        ItemEstoque exclu = null;
                        for (ItemEstoque item : centro03.getEstoque()) {
                            if(item.getId() == id_procurado){
                                exclu = item;
                            }
                        }
                        centro03.getEstoque().remove(exclu);
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