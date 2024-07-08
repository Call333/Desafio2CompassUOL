package model.entities;

public class ProdutoHigiene extends ItemEstoque {
    private String tipo;
    
    public ProdutoHigiene(String descricao, Integer quantidade, 
            Integer centro_distruibuicao_id, String tipo) {
        super(descricao, quantidade, centro_distruibuicao_id);
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
