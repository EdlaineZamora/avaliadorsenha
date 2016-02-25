package br.com.edlaine.avaliadorsenha.entity;

import br.com.edlaine.avaliadorsenha.enumerations.Complexidade;
import br.com.edlaine.avaliadorsenha.service.SenhaService;

/**
 * Created by edlaine.zamora on 25/02/2016.
 */
public class SenhaFactory {

    private SenhaService senhaService;


    public Senha createSenha(String valor) {
        return new Senha(valor, Complexidade.BOA, 1);

    }

}
