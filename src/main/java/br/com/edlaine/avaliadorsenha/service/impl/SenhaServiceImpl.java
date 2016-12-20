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

    public Integer getQuantidadeDeCaracteres(String senha) {
        return senha.length();
    }

    public Integer quantidadeLetrasMaiusculas(String senha) {
        return getQuantidadeDeCaracteres(senha, EXPRESSAO_REGULAR_LETRAS_MAIUSCULAS);
    }

    public Integer getQuantidadeDeCaracteres(String senha, String expressaoRegular) {
        Integer contador = 0;
        for (int i = 0; i < senha.length(); i++) {
            if (String.valueOf(senha.charAt(i)).matches(expressaoRegular)) {
                contador++;
            }
        }
        return contador;
    }

    public Integer getQuantidadeLetrasMinusculas(String senha) {
        return getQuantidadeDeCaracteres(senha, EXPRESSAO_REGULAR_LETRAS_MINUSCULAS);
    }

    public Integer getQuantidadeNumeros(String senha) {
        return getQuantidadeDeCaracteres(senha, EXPRESSAO_REGULAR_NUMEROS);
    }

    public Integer getQuantidadeSimbolos(String senha) {
        return getQuantidadeDeCaracteres(senha, EXPRESSAO_REGULAR_SIMBOLOS);
    }

    public Integer getQuantidadeNumerosSimbolosNoMeio(String senha) {

        Integer contador = 0;

        if (senha.length() < 3) {
            return contador;
        }

        String caracterInicial = String.valueOf(senha.charAt(0));
        String caracterFinal = String.valueOf(senha.charAt(senha.length() - 1));

        contador += getQuantidadeSimbolos(senha);
        contador += getQuantidadeNumeros(senha);

        if (caracterInicial.matches(EXPRESSAO_REGULAR_NUMEROS) || caracterInicial.matches(EXPRESSAO_REGULAR_SIMBOLOS)) {
            contador -= 1;
        }

        if (caracterFinal.matches(EXPRESSAO_REGULAR_NUMEROS) || caracterFinal.matches(EXPRESSAO_REGULAR_SIMBOLOS)) {
            contador -= 1;
        }

        return contador;
    }

    public Integer getQuantidadeRequerimentos(String senha) {

        Integer contador = 0;
        if (quantidadeLetrasMaiusculas(senha) > 0) {
            contador++;
        }
        if (getQuantidadeLetrasMinusculas(senha) > 0) {
            contador++;
        }
        if (getQuantidadeNumeros(senha) > 0) {
            contador++;
        }
        if (getQuantidadeSimbolos(senha) > 0) {
            contador++;
        }
        if (contador >= 3) {
            if (senha.length() >= 8) {
                contador++;
            }
            return contador;
        }
        return 0;
    }

    public boolean isSoLetras(String senha) {
        return senha.matches(EXPRESSAO_REGULAR_SO_LETRAS);
    }

    public boolean isSoNumeros(String senha) {
        return senha.matches(EXPRESSAO_REGULAR_NUMEROS);
    }

    public Integer getQuantidadeCaracterRepetido(String senha) {
        Integer contador = 0;
        HashMap<String, Integer> colecao = new HashMap<String, Integer>();

        for (int i = 0; i < senha.length(); i++) {
            String chave = String.valueOf(senha.charAt(i));
            if (colecao.containsKey(chave)) {
                colecao.put(chave, colecao.get(chave) + 1);
            } else {
                colecao.put(chave, 1);
            }
        }

        Iterator<Map.Entry<String, Integer>> colecaoCaracteres = colecao.entrySet().iterator();
        while (colecaoCaracteres.hasNext()) {
            Map.Entry<String, Integer> par = colecaoCaracteres.next();
            if (par.getValue() > 1) {
                contador = contador + par.getValue();
            }
        }
        return contador;
    }

    public Integer getQuantidadeLetrasMaiusculasConsecutivas(String senha) {
        return getQuantidadeConsecutivos(senha, EXPRESSAO_REGULAR_LETRAS_MAIUSCULAS);
    }

    public Integer getQuantidadeLetrasMinusculasConsecutivas(String senha) {
        return getQuantidadeConsecutivos(senha, EXPRESSAO_REGULAR_LETRAS_MINUSCULAS);
    }

    public Integer getQuantidadeNumerosConsecutivos(String senha) {
        return getQuantidadeConsecutivos(senha, EXPRESSAO_REGULAR_NUMEROS);
    }

    public Integer getQuantidadeLetrasSequenciais(String senha) {
        return getQuantidadeSequenciais(senha.toUpperCase(), EXPRESSAO_REGULAR_SO_LETRAS);
    }

    public Integer getQuantidadeNumerosSequenciais(String senha) {
        return getQuantidadeSequenciais(senha, EXPRESSAO_REGULAR_NUMEROS);
    }

    public Integer getQuantidadeSequenciais(String senha, String expressaoRegular) {
        Integer contador = 0;

        for (int i = 0; i < senha.length() - 1; i++) {
            if (i + 2 >= senha.length()) {
                continue;
            }
            if (isCaracterSequencial(senha, expressaoRegular, i)) {
                contador++;
            }
        }
        return contador;
    }

    private boolean isCaracterSequencial(final String senha, final String expressaoRegular, final int i) {
        Integer codigoAscPrimeiraLetra = (int) senha.charAt(i);
        Integer codigoAscSegundaLetra = (int) senha.charAt(i + 1);
        Integer codigoAscTerceiraLetra = (int) senha.charAt(i + 2);

        return (codigoAscPrimeiraLetra + 1 == codigoAscSegundaLetra) && (codigoAscSegundaLetra + 1 == codigoAscTerceiraLetra)
                && (String.valueOf(senha.charAt(i)).matches(expressaoRegular))
                && (String.valueOf(senha.charAt(i + 1)).matches(expressaoRegular))
                && (String.valueOf(senha.charAt(i + 2)).matches(expressaoRegular));
    }


    public Integer getQuantidadeConsecutivos(String senha, String expressaoRegular) {
        Integer contador = 0;

        for (int i = 0; i < senha.length() - 1; i++) {
            if (String.valueOf(senha.charAt(i)).matches(expressaoRegular)
                    && String.valueOf(senha.charAt(i + 1)).matches(expressaoRegular)) {
                contador++;
            }
        }
        return contador;
    }

    public Integer getQuantidadeSimbolosSequenciais(String senha) {
        return getQuantidadeSequenciais(senha, EXPRESSAO_REGULAR_SIMBOLOS);
    }

    public Integer getPontuacaoPositiva(String descricaoSenha) {
        Integer total = 0;

        Integer numberOfCharacters = getQuantidadeDeCaracteres(descricaoSenha);
        Integer uppercaseLetters = quantidadeLetrasMaiusculas(descricaoSenha);
        Integer lowercaseLetters = getQuantidadeLetrasMinusculas(descricaoSenha);

        if (uppercaseLetters > 0) {
            total += ((numberOfCharacters - uppercaseLetters) * 2);
        }
        if (lowercaseLetters > 0) {
            total += ((numberOfCharacters - lowercaseLetters) * 2);
        }

        total += numberOfCharacters * 4;
        total += getQuantidadeNumeros(descricaoSenha) * 4;
        total += getQuantidadeSimbolos(descricaoSenha) * 6;
        total += getQuantidadeNumerosSimbolosNoMeio(descricaoSenha) * 2;
        total += getQuantidadeRequerimentos(descricaoSenha) * 2;

        return total;
    }

    public Integer getPontuacaoNegativa(String descricaoSenha) {
        Integer total = 0;

        if (isSoLetras(descricaoSenha)) {
            total -= getQuantidadeDeCaracteres(descricaoSenha);
        }
        if (isSoNumeros(descricaoSenha)) {
            total -= getQuantidadeDeCaracteres(descricaoSenha);
        }

        total -= getQuantidadeCaracterRepetido(descricaoSenha);
        total -= getQuantidadeLetrasMaiusculasConsecutivas(descricaoSenha) * 2;
        total -= getQuantidadeLetrasMinusculasConsecutivas(descricaoSenha) * 2;
        total -= getQuantidadeNumerosConsecutivos(descricaoSenha) * 2;
        total -= getQuantidadeLetrasSequenciais(descricaoSenha) * 3;
        total -= getQuantidadeNumerosSequenciais(descricaoSenha) * 3;

        return total;
    }

}
