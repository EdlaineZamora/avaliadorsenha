package br.com.edlaine.avaliadorsenha.service;

import br.com.edlaine.avaliadorsenha.enumerations.Complexidade;

/**
 * Created by edlaine.zamora on 22/02/2016.
 */
public interface SenhaService {

    Complexidade gerarResultado(Integer resultado);

    Integer quantidadeDeCaracteres(String senha);

    Integer quantidadeLetrasMaiusculas(String senha);

    Integer quantidadeDeCaracteres(String senha, String expressaoRegular);

    Integer letrasMinusculas(String senha);

    Integer numeros(String senha);

    Integer simbolos(String senha);

    Integer numerosSimbolosNoMeio(String senha);

    /* M�nimo de 8 caracteres de tamanho
	   Conter 3/4 dos itens a seguir:
	   - Letras Mai�sculas
	   - Letras Min�sculas
	   - N�meros
	   - S�mbolos
	 */
    Integer requerimentos(String senha);

    boolean isSoLetras(String senha);

    boolean isSoNumeros(String senha);

    /* N�o entendi qual f�rmula utilizar, pois n�o diz
	 * no site, est� com um (-): "Repeat Characters (Case Insensitive) 	Comp 	-".
	 * Estou considerando a quantidadeDeCaracteres de caracteres repetidos para somar,
	 * por�m, em alguns casos d� diverg�ncia.
	 */
    Integer isCaracterRepetido(String senha);

    Integer letrasMaiusculasConsecutivas(String senha);

    Integer letrasMinusculasConsecutivas(String senha);

    Integer numerosConsecutivos(String senha);

    Integer letrasSequenciais(String senha);

    Integer numerosSequenciais(String senha);

    Integer sequenciais(String senha, String expressaoRegular);

    Integer consecutivos(String senha, String expressaoRegular);


    /* Na regra de neg�cio passada como refer�ncia n�o consegui entender, pois
     * eu implementei seguindo a sequ�ncia da tabela ascii e n�o est�
     * batendo com o site passado.
     * */
    Integer simbolosSequenciais(String senha);

}
