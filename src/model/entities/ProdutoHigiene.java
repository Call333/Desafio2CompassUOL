package model.entities;

public class ProdutoHigiene extends ItemEstoque {
    private String tipo;
    
    public ProdutoHigiene(Integer id, String descricao, Integer quantidade, 
            Integer centro_distruibuicao_id, String tipo) {
        super(id, descricao, quantidade, centro_distruibuicao_id);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String toString() {
        return "Produto de Higiene: [" + getDescricao() + ", "
                + getTipo() + ", " + getQuantidade() + ", "
                + getCentro_distruibuicao_id() + "]";
    }
}
