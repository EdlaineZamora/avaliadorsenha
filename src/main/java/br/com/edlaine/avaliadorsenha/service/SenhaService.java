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

    /* M�nimo de 8 caracteres de tamanho
	   Conter 3/4 dos itens a seguir:
	   - Letras Mai�sculas
	   - Letras Min�sculas
	   - N�meros
	   - S�mbolos
	 */
    Integer getQuantidadeRequerimentos(String senha);

    boolean isSoLetras(String senha);

    boolean isSoNumeros(String senha);

    /* N�o entendi qual f�rmula utilizar, pois n�o diz
	 * no site, est� com um (-): "Repeat Characters (Case Insensitive) 	Comp 	-".
	 * Estou considerando a quantidadeDeCaracteres de caracteres repetidos para somar,
	 * por�m, em alguns casos d� diverg�ncia.
	 */
    Integer getQuantidadeCaracterRepetido(String senha);

    Integer getQuantidadeLetrasMaiusculasConsecutivas(String senha);

    Integer getQuantidadeLetrasMinusculasConsecutivas(String senha);

    Integer getQuantidadeNumerosConsecutivos(String senha);

    Integer getQuantidadeLetrasSequenciais(String senha);

    Integer getQuantidadeNumerosSequenciais(String senha);

    Integer getQuantidadeSequenciais(String senha, String expressaoRegular);

    Integer getQuantidadeConsecutivos(String senha, String expressaoRegular);


    /* Na regra de neg�cio passada como refer�ncia n�o consegui entender, pois
     * eu implementei seguindo a sequ�ncia da tabela ascii e n�o est�
     * batendo com o site passado.
     * */
    Integer getQuantidadeSimbolosSequenciais(String senha);

    Integer getPontuacaoPositiva(String descricaoSenha);

    Integer getPontuacaoNegativa(String descricaoSenha);
}
