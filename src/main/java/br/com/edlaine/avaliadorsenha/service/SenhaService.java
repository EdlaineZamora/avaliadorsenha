package br.com.edlaine.avaliadorsenha.service;

import br.com.edlaine.avaliadorsenha.enumerations.Complexidade;

/**
 * Created by edlaine.zamora on 22/02/2016.
 */
public interface SenhaService {

    Complexidade gerarResultado(Integer resultado);

    Integer getQuantidadeDeCaracteres(String senha);

    Integer quantidadeLetrasMaiusculas(String senha);

    Integer getQuantidadeDeCaracteres(String senha, String expressaoRegular);

    Integer getQuantidadeLetrasMinusculas(String senha);

    Integer getQuantidadeNumeros(String senha);

    Integer getQuantidadeSimbolos(String senha);

    Integer getQuantidadeNumerosSimbolosNoMeio(String senha);

    Integer getQuantidadeRequerimentos(String senha);

    boolean isSoLetras(String senha);

    boolean isSoNumeros(String senha);

    Integer getQuantidadeCaracterRepetido(String senha);

    Integer getQuantidadeLetrasMaiusculasConsecutivas(String senha);

    Integer getQuantidadeLetrasMinusculasConsecutivas(String senha);

    Integer getQuantidadeNumerosConsecutivos(String senha);

    Integer getQuantidadeLetrasSequenciais(String senha);

    Integer getQuantidadeNumerosSequenciais(String senha);

    Integer getQuantidadeSequenciais(String senha, String expressaoRegular);

    Integer getQuantidadeConsecutivos(String senha, String expressaoRegular);

    Integer getQuantidadeSimbolosSequenciais(String senha);

    Integer getPontuacaoPositiva(String descricaoSenha);

    Integer getPontuacaoNegativa(String descricaoSenha);
}
