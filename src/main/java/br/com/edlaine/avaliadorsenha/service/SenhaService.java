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

    /* Mínimo de 8 caracteres de tamanho
	   Conter 3/4 dos itens a seguir:
	   - Letras Maiúsculas
	   - Letras Minúsculas
	   - Números
	   - Símbolos
	 */
    Integer requerimentos(String senha);

    boolean isSoLetras(String senha);

    boolean isSoNumeros(String senha);

    /* Não entendi qual fórmula utilizar, pois não diz
	 * no site, está com um (-): "Repeat Characters (Case Insensitive) 	Comp 	-".
	 * Estou considerando a quantidadeDeCaracteres de caracteres repetidos para somar,
	 * porém, em alguns casos dá divergência.
	 */
    Integer isCaracterRepetido(String senha);

    Integer letrasMaiusculasConsecutivas(String senha);

    Integer letrasMinusculasConsecutivas(String senha);

    Integer numerosConsecutivos(String senha);

    Integer letrasSequenciais(String senha);

    Integer numerosSequenciais(String senha);

    Integer sequenciais(String senha, String expressaoRegular);

    Integer consecutivos(String senha, String expressaoRegular);


    /* Na regra de negócio passada como referência não consegui entender, pois
     * eu implementei seguindo a sequência da tabela ascii e não está
     * batendo com o site passado.
     * */
    Integer simbolosSequenciais(String senha);

}
