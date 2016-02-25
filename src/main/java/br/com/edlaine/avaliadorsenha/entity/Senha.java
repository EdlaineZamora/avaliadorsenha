package br.com.edlaine.avaliadorsenha.entity;

import br.com.edlaine.avaliadorsenha.enumerations.Complexidade;

/**
 * Created by edlaine.zamora on 22/02/2016.
 */
public class Senha {

    private Complexidade complexidade;
    private String descricao;
    private Integer pontuacaoTotal;

    public Senha() {
        descricao = "";
        complexidade = Complexidade.MUITOCURTA;
        pontuacaoTotal = 0;
    }

    protected Senha(String valor, Complexidade complexidade, Integer pontuacao) {
        this.complexidade = calculaComplexidade(valor);
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

    public void setPontuacaoTotal(final Integer pontuacaoTotal) {
        this.pontuacaoTotal = pontuacaoTotal;
    }

    public Integer getPontuacaoTotal() {
        return pontuacaoTotal;
    }
}
