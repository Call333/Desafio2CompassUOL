package model.entities;

public class Roupa extends ItemEstoque {

    private String genero;
    private String tamanho;

    public Roupa(Integer id, String descricao, Integer quantidade, Integer centro_distruibuicao_id,
            String genero, String tamanho) {
        super(id, descricao, quantidade, centro_distruibuicao_id);
        this.genero = genero;
        this.tamanho = tamanho;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String toString() {
        return "Roupa: [ Id: " + getId() + ", Desc.: " +  getDescricao() + ", Tamanho: "
                + getTamanho() + ", Genero: " + getGenero() + ", Qtd: " + getQuantidade() + 
                ", Id_centro: " + getCentro_distruibuicao_id() + "]";
    }
}
