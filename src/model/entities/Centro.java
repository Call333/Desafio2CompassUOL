package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Centro {
    private String nome;
    private String endereco;
    private String cep;

    private List<ItemEstoque> estoqueTotal = new ArrayList<>();

    private List<Roupa> estoqueRoupas = new ArrayList<>();
    private List<Alimento> estoqueAlimentos = new ArrayList<>();
    private List<ProdutoHigiene> estoqueHigiene = new ArrayList<>();

    public Centro(String nome, String endereco, String cep) {
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
    }

    public void addRoupa(Roupa i) {
        estoqueRoupas.add(i);
        int qi = i.getQuantidade();
        int h = contabilizarTotalItensRoupa();
        Roupa n1 = null;
        if (h > 1000) {
            for (int j = 0; j < (contabilizarTotalItensRoupa() - 1000); j++) {
                qi -= 1;
                n1 = new Roupa(i.getDescricao(), qi,
                        i.getCentro_distruibuicao_id(), i.getGenero(), i.getTamanho());
            }
            estoqueRoupas.remove(i);
            estoqueRoupas.add(n1);
            System.out.println("Agora o estoque de roupas do centro de distribuição está cheio.");
        }
        if (n1 != null) {
            estoqueTotal.add(n1);
        } else {
            estoqueTotal.add(i);
        }
    }

    // public void addAlimento(Alimento i) { /// Alimento, contabilizar itens me retorne 999 + 5 = 1000, tira 4
    //     estoqueAlimentos.add(i);
    //     int qi = i.getQuantidade();
    //     int h = contabilizarTotalItensAlimento();
    //     Alimento n1 = null;
    //     if (h > 1000) {
    //         for (int j = 0; j < (contabilizarTotalItensAlimento() - 1000); j++) {
    //             qi -= 1;
    //             n1 = new Alimento(i.getDescricao(), qi,
    //                     i.getCentro_distruibuicao_id(), i.getUnidade_medida(), i.getValidade());
    //         }
    //         estoqueAlimentos.remove(i);
    //         estoqueAlimentos.add(n1);
    //         System.out.println("Agora o estoque de alimentos do centro de distribuição está cheio.");
    //     }
    //     if (n1 != null) {
    //         estoqueTotal.add(n1);
    //     } else {
    //         estoqueTotal.add(i);
    //     }
    // }

    public void addAlimento(Alimento i) { /// Alimento, contabilizar itens me retorne 999 + 5 = 1000, tira 4
        int qtd = i.getQuantidade();
        for (int j = 0; j < qtd; j++) { // j representa a quantidade de arroz q será add no estoque.
            estoqueAlimentos.add(new Alimento(i.getDescricao(), 1, 
            i.getCentro_distruibuicao_id(), i.getUnidade_medida(), i.getValidade()));
            estoqueTotal.add(new Alimento(i.getDescricao(), 1, 
            i.getCentro_distruibuicao_id(), i.getUnidade_medida(), i.getValidade()));
        }
        System.out.println(estoqueAlimentos.size());
        int limite = 100; // Limite tem q estar em 100
        if(estoqueAlimentos.size()> limite){ // 10
            while (estoqueAlimentos.size() > limite) {
                estoqueAlimentos.remove(estoqueAlimentos.size() - 1);
                estoqueTotal.remove(estoqueTotal.size() - 1);
            }
        }
    }

    public void addHigiene(ProdutoHigiene i) {
        estoqueHigiene.add(i);
        int qi = i.getQuantidade();
        int h = contabilizarTotalItensHigiene();
        ProdutoHigiene n1 = null;
        if (h > 1000) {
            for (int j = 0; j < (contabilizarTotalItensHigiene() - 1000); j++) {
                qi -= 1;
                n1 = new ProdutoHigiene(i.getDescricao(), qi,
                        i.getCentro_distruibuicao_id(), i.getTipo());
            }
            estoqueHigiene.remove(i);
            estoqueHigiene.add(n1);
            System.out.println("Agora o estoque de produtos de higiene centro de distribuição está cheio.");
        }
        if (n1 != null) {
            estoqueTotal.add(n1);
        } else {
            estoqueTotal.add(i);
        }
    }

    public void remove(Roupa i) {
        estoqueRoupas.remove(i);
        estoqueTotal.remove(i);
    }

    public void remove(Alimento i) {
        estoqueAlimentos.remove(i);
        estoqueTotal.remove(i);
    }

    public void remove(ProdutoHigiene i) {
        estoqueHigiene.remove(i);
        estoqueTotal.remove(i);
    }

    public int contabilizarTotalItens() {
        int qtdTotal = 0;
        for (ItemEstoque itemEstoque : getEstoqueTotal()) {
            qtdTotal += itemEstoque.getQuantidade();
        }
        return qtdTotal;
    }

    public int contabilizarTotalItensHigiene() {
        int qtdTotal = 0;
        for (ProdutoHigiene itemEstoque : getEstoqueHigiene()) {
            qtdTotal += itemEstoque.getQuantidade();
        }
        return qtdTotal;
    }

    public int contabilizarTotalItensAlimento() {
        int qtdTotal = 0;
        for (Alimento itemEstoque : getEstoqueAlimentos()) {
            qtdTotal += itemEstoque.getQuantidade();
        }
        return qtdTotal;
    }

    public int contabilizarTotalItensRoupa() {
        int qtdTotal = 0;
        for (Roupa itemEstoque : getEstoqueRoupas()) {
            qtdTotal += itemEstoque.getQuantidade();
        }
        return qtdTotal;
    }

    public List<ItemEstoque> getEstoque() {
        return estoqueTotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<ItemEstoque> getEstoqueTotal() {
        return estoqueTotal;
    }

    public List<Roupa> getEstoqueRoupas() {
        return estoqueRoupas;
    }

    public List<Alimento> getEstoqueAlimentos() {
        return estoqueAlimentos;
    }

    public List<ProdutoHigiene> getEstoqueHigiene() {
        return estoqueHigiene;
    }

    public String toString() {
        return "Centro -> [ Nome: " + nome + ", " + endereco + ", " + cep + " ]";
    }
}
