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

    /* Mínimo de 8 caracteres de tamanho
	   Conter 3/4 dos itens a seguir:
	   - Letras Maiúsculas
	   - Letras Minúsculas
	   - Números
	   - Símbolos
	 */
    Integer getQuantidadeRequerimentos(String senha);

    boolean isSoLetras(String senha);

    boolean isSoNumeros(String senha);

    /* Não entendi qual fórmula utilizar, pois não diz
	 * no site, está com um (-): "Repeat Characters (Case Insensitive) 	Comp 	-".
	 * Estou considerando a quantidadeDeCaracteres de caracteres repetidos para somar,
	 * porém, em alguns casos dá divergência.
	 */
    Integer getQuantidadeCaracterRepetido(String senha);

    Integer getQuantidadeLetrasMaiusculasConsecutivas(String senha);

    Integer getQuantidadeLetrasMinusculasConsecutivas(String senha);

    Integer getQuantidadeNumerosConsecutivos(String senha);

    Integer getQuantidadeLetrasSequenciais(String senha);

    Integer getQuantidadeNumerosSequenciais(String senha);

    Integer getQuantidadeSequenciais(String senha, String expressaoRegular);

    Integer getQuantidadeConsecutivos(String senha, String expressaoRegular);


    /* Na regra de negócio passada como referência não consegui entender, pois
     * eu implementei seguindo a sequência da tabela ascii e não está
     * batendo com o site passado.
     * */
    Integer getQuantidadeSimbolosSequenciais(String senha);

    Integer getPontuacaoPositiva(String descricaoSenha);

    Integer getPontuacaoNegativa(String descricaoSenha);
}
