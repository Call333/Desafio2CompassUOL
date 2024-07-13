package model.entities;

import java.time.LocalDate;

public class Alimento extends ItemEstoque {
    private String unidade_medida;
    private LocalDate validade;

    public Alimento(Integer id, String descricao, Integer quantidade, Integer centro_distruibuicao_id,
            String unidade_medida, LocalDate validade) {
        super(id, descricao, quantidade, centro_distruibuicao_id);
        this.unidade_medida = unidade_medida;
        this.validade = validade;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }
    
    public String toString() {
        return "Alimento: [ Id: "+ getId() + ", Desc.: " + getDescricao() + ", Medida: "
                + getUnidade_medida() + ", Qtd: " + getQuantidade() + ", Validade:"
                + getValidade() + ", Id_centro: " + getCentro_distruibuicao_id() + "]";
    }
}
