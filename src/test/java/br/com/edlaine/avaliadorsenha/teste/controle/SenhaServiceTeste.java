package br.com.edlaine.avaliadorsenha.teste.controle;

import br.com.edlaine.avaliadorsenha.service.SenhaService;
import br.com.edlaine.avaliadorsenha.service.impl.SenhaServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class SenhaServiceTeste {


    private SenhaService senhaService = new SenhaServiceImpl();

    @Test
    public void testQuantidade() {

        assertEquals("7", String.valueOf(senhaService.getQuantidadeDeCaracteres("*****12")));
        assertEquals("14", String.valueOf(senhaService.getQuantidadeDeCaracteres("AaAAAaAddeqAQQ")));
        assertEquals("5", String.valueOf(senhaService.getQuantidadeDeCaracteres("12332")));
        assertEquals("5", String.valueOf(senhaService.getQuantidadeDeCaracteres("DEDFD")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeDeCaracteres("")));
        assertEquals("19", String.valueOf(senhaService.getQuantidadeDeCaracteres("DsDs1ss2DD44555CCDA")));
        assertEquals("10", String.valueOf(senhaService.getQuantidadeDeCaracteres("D22E***ddd")));

    }

    @Test
    public void testLetrasMaiusculas() {

        assertEquals("0", String.valueOf(senhaService.quantidadeLetrasMaiusculas("*****12")));
        assertEquals("8", String.valueOf(senhaService.quantidadeLetrasMaiusculas("AaAAAaAddeqAQQ")));
        assertEquals("0", String.valueOf(senhaService.quantidadeLetrasMaiusculas("12332")));
        assertEquals("5", String.valueOf(senhaService.quantidadeLetrasMaiusculas("DEDFD")));
        assertEquals("0", String.valueOf(senhaService.quantidadeLetrasMaiusculas("")));
        assertEquals("8", String.valueOf(senhaService.quantidadeLetrasMaiusculas("DsDs1ss2DD44555CCDA")));
        assertEquals("2", String.valueOf(senhaService.quantidadeLetrasMaiusculas("D22E***ddd")));

    }

    @Test
    public void testLetrasMinusculas() {

        assertEquals("0", String.valueOf(senhaService.getQuantidadeLetrasMinusculas("*****12")));
        assertEquals("6", String.valueOf(senhaService.getQuantidadeLetrasMinusculas("AaAAAaAddeqAQQ")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeLetrasMinusculas("12332")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeLetrasMinusculas("DEDFD")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeLetrasMinusculas("")));
        assertEquals("4", String.valueOf(senhaService.getQuantidadeLetrasMinusculas("DsDs1ss2DD44555CCDA")));
        assertEquals("3", String.valueOf(senhaService.getQuantidadeLetrasMinusculas("D22E***ddd")));

    }

    @Test
    public void testNumeros() {

        assertEquals("2", String.valueOf(senhaService.getQuantidadeNumeros("*****12")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeNumeros(" ")));
        assertEquals("5", String.valueOf(senhaService.getQuantidadeNumeros("12332")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeNumeros("DEDFD")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeNumeros("")));
        assertEquals("7", String.valueOf(senhaService.getQuantidadeNumeros("DsDs1ss2DD44555CCDA")));
        assertEquals("2", String.valueOf(senhaService.getQuantidadeNumeros("D22E***ddd")));

    }

    @Test
    public void testSimbolos() {

        assertEquals("5", String.valueOf(senhaService.getQuantidadeSimbolos("*****12")));
        assertEquals("9", String.valueOf(senhaService.getQuantidadeSimbolos("()(!@##@dws]")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeSimbolos("12332")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeSimbolos("DEDFD")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeSimbolos("")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeSimbolos(" ")));
        assertEquals("3", String.valueOf(senhaService.getQuantidadeSimbolos("D22E***ddd")));

    }

    @Test
    public void testNumerosSimbolosNoMeio() {

        assertEquals("5", String.valueOf(senhaService.getQuantidadeNumerosSimbolosNoMeio("*****12")));
        assertEquals("8", String.valueOf(senhaService.getQuantidadeNumerosSimbolosNoMeio("()(!@##@dws2EE]")));
        assertEquals("7", String.valueOf(senhaService.getQuantidadeNumerosSimbolosNoMeio("d9*98212e")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeNumerosSimbolosNoMeio("DEDFD")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeNumerosSimbolosNoMeio("")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeNumerosSimbolosNoMeio(" ")));
        assertEquals("5", String.valueOf(senhaService.getQuantidadeNumerosSimbolosNoMeio("D22E***ddd")));

    }

    @Test
    public void testRequerimentos() {

        assertEquals("0", String.valueOf(senhaService.getQuantidadeRequerimentos("*****12")));
        assertEquals("5", String.valueOf(senhaService.getQuantidadeRequerimentos("()(!@##@dws2EE]")));
        assertEquals("4", String.valueOf(senhaService.getQuantidadeRequerimentos("d9*98212e")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeRequerimentos("DEDFD")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeRequerimentos("")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeRequerimentos(" ")));
        assertEquals("5", String.valueOf(senhaService.getQuantidadeRequerimentos("D22E***ddd")));

    }

    @Test
    public void testSoNumeros() {

        assertTrue(senhaService.isSoNumeros("1236434412"));
        assertFalse(senhaService.isSoNumeros(""));
        assertFalse(senhaService.isSoNumeros("adqw98123"));
        assertFalse(senhaService.isSoNumeros("a&**(dqw98123"));
        assertFalse(senhaService.isSoNumeros("a&**(dqw9;do12"));
    }

    @Test
    public void testSoLetras() {

        assertFalse(senhaService.isSoLetras("1231023"));
        assertFalse(senhaService.isSoLetras(""));
        assertTrue(senhaService.isSoLetras("AAASDQWE"));
        assertTrue(senhaService.isSoLetras("asdasdASDEA"));
        assertTrue(senhaService.isSoLetras("aasdjqhuhdas"));

    }

    @Test
    public void testCaracteresRepetidos() {

        assertEquals("6", String.valueOf(senhaService.isCaracterRepetido("AABCCDEE")));
        assertEquals("0", String.valueOf(senhaService.isCaracterRepetido("ABCDE")));
        assertEquals("0", String.valueOf(senhaService.isCaracterRepetido("")));
        assertEquals("2", String.valueOf(senhaService.isCaracterRepetido("ABCDEE")));
        assertEquals("0", String.valueOf(senhaService.isCaracterRepetido("ABCDeE")));
        assertEquals("4", String.valueOf(senhaService.isCaracterRepetido("233133")));
        assertEquals("9", String.valueOf(senhaService.isCaracterRepetido("2222dddqhq")));

    }

    @Test
    public void testLetrasMaiusculasConsecutivas() {

        assertEquals("2", String.valueOf(senhaService.getQuantidadeLetrasMaiusculasConsecutivas("AaAAAaA")));
        assertEquals("4", String.valueOf(senhaService.getQuantidadeLetrasMaiusculasConsecutivas("AaAAAaAddeqAQQ")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeLetrasMaiusculasConsecutivas("12332")));
        assertEquals("4", String.valueOf(senhaService.getQuantidadeLetrasMaiusculasConsecutivas("DEDFD")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeLetrasMaiusculasConsecutivas("")));
        assertEquals("5", String.valueOf(senhaService.getQuantidadeLetrasMaiusculasConsecutivas("DsDsDsDssDDCCDA")));
        assertEquals("1", String.valueOf(senhaService.getQuantidadeLetrasMaiusculasConsecutivas("DE***")));

    }

    @Test
    public void testLetrasMinusculasConsecutivas() {

        assertEquals("0", String.valueOf(senhaService.getQuantidadeLetrasMinusculasConsecutivas("AaAAAaA")));
        assertEquals("3", String.valueOf(senhaService.getQuantidadeLetrasMinusculasConsecutivas("AaAAAaAddeqAQQ")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeLetrasMinusculasConsecutivas("12332")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeLetrasMinusculasConsecutivas("DEDFD")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeLetrasMinusculasConsecutivas("")));
        assertEquals("1", String.valueOf(senhaService.getQuantidadeLetrasMinusculasConsecutivas("DsDsDsDssDDCCDA")));
        assertEquals("2", String.valueOf(senhaService.getQuantidadeLetrasMinusculasConsecutivas("DE***ddd")));

    }

    @Test
    public void testNumerosConsecutivos() {

        assertEquals("1", String.valueOf(senhaService.getQuantidadeNumerosConsecutivos("*****12")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeNumerosConsecutivos("AaAAAaAddeqAQQ")));
        assertEquals("4", String.valueOf(senhaService.getQuantidadeNumerosConsecutivos("12332")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeNumerosConsecutivos("DEDFD")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeNumerosConsecutivos("")));
        assertEquals("4", String.valueOf(senhaService.getQuantidadeNumerosConsecutivos("DsDs1ss2DD44555CCDA")));
        assertEquals("1", String.valueOf(senhaService.getQuantidadeNumerosConsecutivos("D22E***ddd")));

    }

    @Test
    public void testLetrasSequenciais() {

        assertEquals("0", String.valueOf(senhaService.getQuantidadeLetrasSequenciais("")));
        assertEquals("1", String.valueOf(senhaService.getQuantidadeLetrasSequenciais("DsDs1ss2DD44555CCDEA")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeLetrasSequenciais("D22E***ddd")));
        assertEquals("3", String.valueOf(senhaService.getQuantidadeLetrasSequenciais("DsDs1ss2DD44555CCDEfg")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeLetrasSequenciais(" ")));
        assertEquals("2", String.valueOf(senhaService.getQuantidadeLetrasSequenciais("abdeghij")));
        assertEquals("1", String.valueOf(senhaService.getQuantidadeLetrasSequenciais("*((*sdnnnmopq")));

    }

    @Test
    public void testNumerosSequenciais() {

        assertEquals("0", String.valueOf(senhaService.getQuantidadeNumerosSequenciais("")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeNumerosSequenciais("DsDs1ss2DD44555CCDEA")));
        assertEquals("2", String.valueOf(senhaService.getQuantidadeNumerosSequenciais("D23452E***ddd")));
        assertEquals("1", String.valueOf(senhaService.getQuantidadeNumerosSequenciais("DsDs1ss2DD445655CCDEfg")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeNumerosSequenciais(" ")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeNumerosSequenciais("abdeghij")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeNumerosSequenciais("*((*sdnnnmopq")));

    }

    @Test
    public void testSimbolosSequenciais() {

        assertEquals("0", String.valueOf(senhaService.getQuantidadeSimbolosSequenciais("")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeSimbolosSequenciais("DsDs1ss2DD44555CCDEA")));
//		assertEquals("2", String.valueOf(senhaService.getQuantidadeSimbolosSequenciais("D23452E**^&*()ddd")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeSimbolosSequenciais("DsDs1ss2DD445655CCDEfg")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeSimbolosSequenciais(" ")));
//		assertEquals("7", String.valueOf(senhaService.getQuantidadeSimbolosSequenciais("!@#$%^&*()")));
        assertEquals("0", String.valueOf(senhaService.getQuantidadeSimbolosSequenciais("*((*sdnnnmopq")));

    }

}
