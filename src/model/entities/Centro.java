package model.entities;

import java.util.ArrayList;
import java.util.List;

public class Centro {
    private Integer id;
    private String nome;
    private String endereco;
    private String cep;

    private List<ItemEstoque> estoqueTotal = new ArrayList<>();

    private List<Roupa> estoqueRoupas = new ArrayList<>();
    private List<Alimento> estoqueAlimentos = new ArrayList<>();
    private List<ProdutoHigiene> estoqueHigiene = new ArrayList<>();

    public Centro(Integer id,String nome, String endereco, String cep) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
    }

    public void addRoupa(Roupa i) {
        int qtd = i.getQuantidade();
        for (int j = 0; j < qtd; j++) { // j representa a quantidade q será add no estoque.
            estoqueRoupas.add(new Roupa(i.getDescricao(), 1,
                    i.getCentro_distruibuicao_id(), i.getGenero(), i.getTamanho()));
            estoqueTotal.add(new Roupa(i.getDescricao(), 1,
                    i.getCentro_distruibuicao_id(), i.getGenero(), i.getTamanho()));
        }
        int limite = 1000; // Limite tem q estar em 100
        if (estoqueRoupas.size() > limite) {
            while (estoqueRoupas.size() > limite) {
                estoqueRoupas.remove(estoqueRoupas.size() - 1);
                estoqueTotal.remove(estoqueTotal.size() - 1);
            }
        }
    }

    public void addAlimento(Alimento i) { /// Alimento, contabilizar itens me retorne 999 + 5 = 1000, tira 4
        int qtd = i.getQuantidade();
        for (int j = 0; j < qtd; j++) { // j representa a quantidade q será add no estoque.
            estoqueAlimentos.add(new Alimento(i.getDescricao(), 1,
                    i.getCentro_distruibuicao_id(), i.getUnidade_medida(), i.getValidade()));
            estoqueTotal.add(new Alimento(i.getDescricao(), 1,
                    i.getCentro_distruibuicao_id(), i.getUnidade_medida(), i.getValidade()));
        }
        int limite = 1000; // Limite tem q estar em 100
        if (estoqueAlimentos.size() > limite) {
            while (estoqueAlimentos.size() > limite) {
                estoqueAlimentos.remove(estoqueAlimentos.size() - 1);
                estoqueTotal.remove(estoqueTotal.size() - 1);
            }
        }
    }

    public void addHigiene(ProdutoHigiene i) {
        int qtd = i.getQuantidade();
        for (int j = 0; j < qtd; j++) { // j representa a quantidade q será add no estoque.
            estoqueHigiene.add(new ProdutoHigiene(i.getDescricao(), 1,
                    i.getCentro_distruibuicao_id(), i.getTipo()));
            estoqueTotal.add(new ProdutoHigiene(i.getDescricao(), 1,
                    i.getCentro_distruibuicao_id(), i.getTipo()));
        }
        int limite = 1000; // Limite tem q estar em 100
        if (estoqueHigiene.size() > limite) { // 10
            while (estoqueHigiene.size() > limite) {
                estoqueHigiene.remove(estoqueHigiene.size() - 1);
                estoqueTotal.remove(estoqueTotal.size() - 1);
            }
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
