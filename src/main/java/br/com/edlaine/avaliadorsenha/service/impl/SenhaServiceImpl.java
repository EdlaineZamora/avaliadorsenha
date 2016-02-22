package br.com.edlaine.avaliadorsenha.service.impl;

import br.com.edlaine.avaliadorsenha.enumerations.Complexidade;
import br.com.edlaine.avaliadorsenha.service.SenhaService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by edlaine.zamora on 22/02/2016.
 */
public class SenhaServiceImpl implements SenhaService {

    public static final String EXPRESSAO_REGULAR_LETRAS_MAIUSCULAS = "[A-Z]+";
    public static final String EXPRESSAO_REGULAR_LETRAS_MINUSCULAS = "[a-z]+";
    public static final String EXPRESSAO_REGULAR_NUMEROS = "[0-9]+";
    public static final String EXPRESSAO_REGULAR_SIMBOLOS = "[^a-zA-Z0-9\\s]";
    public static final String EXPRESSAO_REGULAR_SO_LETRAS = "[a-zA-Z]+";

    public Complexidade gerarResultado(final Integer resultado) {
        Complexidade complexidade = Complexidade.FORTE;

        if (resultado == 0) {
            complexidade = Complexidade.MUITOCURTA;
        } else if (resultado > 0 && resultado <= 20) {
            complexidade = Complexidade.MUITOFRACA;
        } else if (resultado > 20 && resultado <= 40) {
            complexidade = Complexidade.FRACA;
        } else if (resultado > 40 && resultado <= 60) {
            complexidade = Complexidade.BOA;
        } else if (resultado > 60 && resultado <= 80) {
            complexidade = Complexidade.FORTE;
        } else if (resultado > 80) {
            complexidade = Complexidade.MUITOFORTE;
        }

        return complexidade;
    }

    public Integer quantidadeDeCaracteres(String senha) {
        return senha.length();
    }

    public Integer quantidadeLetrasMaiusculas(String senha) {
        return quantidadeDeCaracteres(senha, EXPRESSAO_REGULAR_LETRAS_MAIUSCULAS);
    }

    public Integer quantidadeDeCaracteres(String senha, String expressaoRegular) {
        Integer contador = 0;
        for (int i=0; i < senha.length();i++) {
            if (String.valueOf(senha.charAt(i)).matches(expressaoRegular)) {
                contador++;
            }
        }
        return contador;
    }

    public Integer letrasMinusculas(String senha) {
        return quantidadeDeCaracteres(senha, EXPRESSAO_REGULAR_LETRAS_MINUSCULAS);
    }

    public Integer numeros(String senha){
        return quantidadeDeCaracteres(senha, EXPRESSAO_REGULAR_NUMEROS);
    }

    public Integer simbolos(String senha){
        return quantidadeDeCaracteres(senha, EXPRESSAO_REGULAR_SIMBOLOS);
    }

    public Integer numerosSimbolosNoMeio(String senha) {

        Integer contador = 0;

        if (senha.length() < 3) {
            return contador;
        }

        String caracterInicial = String.valueOf(senha.charAt(0));
        String caracterFinal = String.valueOf(senha.charAt(senha.length()-1));

        contador += simbolos(senha);
        contador += numeros(senha);

        if (caracterInicial.matches(EXPRESSAO_REGULAR_NUMEROS) || caracterInicial.matches(EXPRESSAO_REGULAR_SIMBOLOS)){
            contador -= 1;
        }

        if (caracterFinal.matches(EXPRESSAO_REGULAR_NUMEROS) || caracterFinal.matches(EXPRESSAO_REGULAR_SIMBOLOS)){
            contador -= 1;
        }

        return contador;
    }

    public Integer requerimentos(String senha) {

        Integer contador = 0;
        if (quantidadeLetrasMaiusculas(senha) > 0) {
            contador++;
        }
        if (letrasMinusculas(senha) > 0) {
            contador++;
        }
        if (numeros(senha) > 0) {
            contador++;
        }
        if (simbolos(senha) > 0) {
            contador++;
        }
        if (contador >= 3) {
            Integer quantidade = senha.length();
            if (quantidade >= 8) {
                contador++;
            }
            return contador;
        } else {
            return 0;
        }
    }

    public boolean isSoLetras(String senha) {
        return senha.matches(EXPRESSAO_REGULAR_SO_LETRAS);
    }

    public boolean isSoNumeros(String senha) {
        return senha.matches(EXPRESSAO_REGULAR_NUMEROS);
    }

    public Integer isCaracterRepetido(String senha) {
        Integer contador = 0;
        HashMap<String, Integer> colecao = new HashMap<String, Integer>();

        for(int i=0; i<senha.length();i++) {
            String chave = String.valueOf(senha.charAt(i));
            if (colecao.containsKey(chave)) {
                colecao.put(chave, colecao.get(chave)+1);
            } else {
                colecao.put(chave, 1);
            }
        }

        Iterator<Map.Entry<String, Integer>> colecaoCaracteres = colecao.entrySet().iterator();
        while (colecaoCaracteres.hasNext()){
            Map.Entry<String,Integer> par = (Map.Entry<String, Integer>) colecaoCaracteres.next();
            if (par.getValue() > 1) {
                contador = contador + par.getValue();
            }
        }
        return contador;
    }

    public Integer letrasMaiusculasConsecutivas(String senha) {
        return consecutivos(senha, EXPRESSAO_REGULAR_LETRAS_MAIUSCULAS);
    }

    public Integer letrasMinusculasConsecutivas(String senha) {
        return consecutivos(senha, EXPRESSAO_REGULAR_LETRAS_MINUSCULAS);
    }

    public Integer numerosConsecutivos(String senha) {
        return consecutivos(senha, EXPRESSAO_REGULAR_NUMEROS);
    }

    public Integer letrasSequenciais(String senha) {
        return sequenciais(senha.toUpperCase(), EXPRESSAO_REGULAR_SO_LETRAS);
    }

    public Integer numerosSequenciais(String senha) {
        return sequenciais(senha, EXPRESSAO_REGULAR_NUMEROS);
    }

    public Integer sequenciais(String senha, String expressaoRegular) {
        Integer contador = 0;

        for(int i=0; i<senha.length()-1;i++) {
            if (i+2 < senha.length()) {
                Integer codigoAscPrimeiraLetra = (int) senha.charAt(i);
                Integer codigoAscSegundaLetra = (int) senha.charAt(i+1);
                Integer codigoAscTerceiraLetra = (int) senha.charAt(i+2);

                if ((codigoAscPrimeiraLetra+1 == codigoAscSegundaLetra) && (codigoAscSegundaLetra+1 == codigoAscTerceiraLetra)
                        && (String.valueOf(senha.charAt(i)).matches(expressaoRegular))
                        && (String.valueOf(senha.charAt(i+1)).matches(expressaoRegular))
                        && (String.valueOf(senha.charAt(i+2)).matches(expressaoRegular))) {
                    contador++;
                }
            }
        }
        return contador;
    }


    public Integer consecutivos(String senha, String expressaoRegular) {
        Integer contador = 0;

        for(int i=0; i<senha.length()-1;i++) {
            String letraAtual = String.valueOf(senha.charAt(i));
            String proximaLetra = String.valueOf(senha.charAt(i+1));
            if (letraAtual.matches(expressaoRegular) && proximaLetra.matches(expressaoRegular)) {
                contador++;
            }
        }
        return contador;
    }

    public Integer simbolosSequenciais(String senha) {
        return sequenciais(senha, EXPRESSAO_REGULAR_SIMBOLOS);
    }

}
