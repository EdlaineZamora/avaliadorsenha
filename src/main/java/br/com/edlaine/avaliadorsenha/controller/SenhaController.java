package br.com.edlaine.avaliadorsenha.controller;

import br.com.edlaine.avaliadorsenha.entity.Senha;
import br.com.edlaine.avaliadorsenha.enumerations.Complexidade;
import br.com.edlaine.avaliadorsenha.service.SenhaService;
import br.com.edlaine.avaliadorsenha.service.impl.SenhaServiceImpl;
import org.springframework.stereotype.Component;

@Component("senhaController")
public class SenhaController {


    public static final int PONTUACAO_MINIMA = 0;
    public static final int PONTUACAO_MAXIMA = 100;
    private boolean visualizarSenha = true;
    private Senha senha;
    private SenhaService senhaService;

    public SenhaController() {
        senhaService = new SenhaServiceImpl();
        senha = new Senha();
    }

    public void calcularComplexidadeDaSenha() {
        Integer total = 0;

        total += senhaService.getPontuacaoPositiva(senha.getDescricao());
        total -= senhaService.getPontuacaoNegativa(senha.getDescricao());

        if (total < PONTUACAO_MINIMA) {
            total = PONTUACAO_MINIMA;
        }

        if (total > PONTUACAO_MAXIMA) {
            total = PONTUACAO_MAXIMA;
        }

        this.senha.setPontuacaoTotal(total);
        this.senha.setComplexidade(senhaService.gerarResultado(total));
    }

    public boolean isComplexidadeMuitoCurta() {
        return senha.getComplexidade() == Complexidade.MUITOCURTA;
    }

    public boolean isComplexidadeMuitoFraca() {
        return senha.getComplexidade() == Complexidade.MUITOFRACA;
    }

    public boolean isComplexidadeFraca() {
        return senha.getComplexidade() == Complexidade.FRACA;
    }

    public boolean isComplexidadeBoa() {
        return senha.getComplexidade() == Complexidade.BOA;
    }

    public boolean isComplexidadeForte() {
        return senha.getComplexidade() == Complexidade.FORTE;
    }

    public boolean isComplexidadeMuitoForte() {
        return senha.getComplexidade() == Complexidade.MUITOFORTE;
    }

    public boolean isVisualizarSenha() {
        return visualizarSenha;
    }

    public void setVisualizarSenha(boolean visualizarSenha) {
        this.visualizarSenha = visualizarSenha;
    }


    public Senha getSenha() {
        return senha;
    }

    public void setSenha(final Senha senha) {
        this.senha = senha;
    }
}
