package model.entities;

public class ItemEstoque {
    private Integer id;
    private String descricao;
    private Integer quantidade;
    private Integer centro_distruibuicao_id;

    public ItemEstoque(Integer id, String descricao, Integer quantidade, Integer centro_distruibuicao_id) {
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.centro_distruibuicao_id = centro_distruibuicao_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getCentro_distruibuicao_id() {
        return centro_distruibuicao_id;
    }

    public void setCentro_distruibuicao_id(Integer centro_distruibuicao_id) {
        this.centro_distruibuicao_id = centro_distruibuicao_id;
    }

}
