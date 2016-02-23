package br.com.edlaine.avaliadorsenha.entity;

import br.com.edlaine.avaliadorsenha.enumerations.Complexidade;

/**
 * Created by edlaine.zamora on 22/02/2016.
 */
public class Senha {

    private Complexidade complexidade;
    private String descricao;

    public Senha() {
        descricao = "";
        complexidade = Complexidade.MUITOCURTA;
    }

    public Complexidade getComplexidade() {
        return complexidade;
    }

    public void setComplexidade(final Complexidade complexidade) {
        this.complexidade = complexidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(final String descricao) {
        this.descricao = descricao;
    }
}
