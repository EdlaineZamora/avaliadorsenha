package br.com.edlaine.avaliadorsenha.teste.controle;

import br.com.edlaine.avaliadorsenha.service.SenhaService;
import br.com.edlaine.avaliadorsenha.service.impl.SenhaServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class SenhaServiceTeste {


    private SenhaService senhaService = new SenhaServiceImpl();

    @Test
    public void testQuantidade() {
        assertEquals(7, senhaService.getQuantidadeDeCaracteres("*****12").intValue());
        assertEquals(14, senhaService.getQuantidadeDeCaracteres("AaAAAaAddeqAQQ").intValue());
        assertEquals(5, senhaService.getQuantidadeDeCaracteres("12332").intValue());
        assertEquals(5, senhaService.getQuantidadeDeCaracteres("DEDFD").intValue());
        assertEquals(0, senhaService.getQuantidadeDeCaracteres("").intValue());
        assertEquals(19, senhaService.getQuantidadeDeCaracteres("DsDs1ss2DD44555CCDA").intValue());
        assertEquals(10, senhaService.getQuantidadeDeCaracteres("D22E***ddd").intValue());
    }

    @Test
    public void testLetrasMaiusculas() {
        assertEquals(0, senhaService.quantidadeLetrasMaiusculas("*****12").intValue());
        assertEquals(8, senhaService.quantidadeLetrasMaiusculas("AaAAAaAddeqAQQ").intValue());
        assertEquals(0, senhaService.quantidadeLetrasMaiusculas("12332").intValue());
        assertEquals(5, senhaService.quantidadeLetrasMaiusculas("DEDFD").intValue());
        assertEquals(0, senhaService.quantidadeLetrasMaiusculas("").intValue());
        assertEquals(8, senhaService.quantidadeLetrasMaiusculas("DsDs1ss2DD44555CCDA").intValue());
        assertEquals(2, senhaService.quantidadeLetrasMaiusculas("D22E***ddd").intValue());
    }

    @Test
    public void testLetrasMinusculas() {
        assertEquals(0, senhaService.getQuantidadeLetrasMinusculas("*****12").intValue());
        assertEquals(6, senhaService.getQuantidadeLetrasMinusculas("AaAAAaAddeqAQQ").intValue());
        assertEquals(0, senhaService.getQuantidadeLetrasMinusculas("12332").intValue());
        assertEquals(0, senhaService.getQuantidadeLetrasMinusculas("DEDFD").intValue());
        assertEquals(0, senhaService.getQuantidadeLetrasMinusculas("").intValue());
        assertEquals(4, senhaService.getQuantidadeLetrasMinusculas("DsDs1ss2DD44555CCDA").intValue());
        assertEquals(3, senhaService.getQuantidadeLetrasMinusculas("D22E***ddd").intValue());
    }

    @Test
    public void testNumeros() {
        assertEquals(2, senhaService.getQuantidadeNumeros("*****12").intValue());
        assertEquals(0, senhaService.getQuantidadeNumeros(" ").intValue());
        assertEquals(5, senhaService.getQuantidadeNumeros("12332").intValue());
        assertEquals(0, senhaService.getQuantidadeNumeros("DEDFD").intValue());
        assertEquals(0, senhaService.getQuantidadeNumeros("").intValue());
        assertEquals(7, senhaService.getQuantidadeNumeros("DsDs1ss2DD44555CCDA").intValue());
        assertEquals(2, senhaService.getQuantidadeNumeros("D22E***ddd").intValue());
    }

    @Test
    public void testSimbolos() {
        assertEquals(5, senhaService.getQuantidadeSimbolos("*****12").intValue());
        assertEquals(9, senhaService.getQuantidadeSimbolos("()(!@##@dws]").intValue());
        assertEquals(0, senhaService.getQuantidadeSimbolos("12332").intValue());
        assertEquals(0, senhaService.getQuantidadeSimbolos("DEDFD").intValue());
        assertEquals(0, senhaService.getQuantidadeSimbolos("").intValue());
        assertEquals(0, senhaService.getQuantidadeSimbolos(" ").intValue());
        assertEquals(3, senhaService.getQuantidadeSimbolos("D22E***ddd").intValue());
    }

    @Test
    public void testNumerosSimbolosNoMeio() {
        assertEquals(5, senhaService.getQuantidadeNumerosSimbolosNoMeio("*****12").intValue());
        assertEquals(8, senhaService.getQuantidadeNumerosSimbolosNoMeio("()(!@##@dws2EE]").intValue());
        assertEquals(7, senhaService.getQuantidadeNumerosSimbolosNoMeio("d9*98212e").intValue());
        assertEquals(0, senhaService.getQuantidadeNumerosSimbolosNoMeio("DEDFD").intValue());
        assertEquals(0, senhaService.getQuantidadeNumerosSimbolosNoMeio("").intValue());
        assertEquals(0, senhaService.getQuantidadeNumerosSimbolosNoMeio(" ").intValue());
        assertEquals(5, senhaService.getQuantidadeNumerosSimbolosNoMeio("D22E***ddd").intValue());
    }

    @Test
    public void testRequerimentos() {
        assertEquals(0, senhaService.getQuantidadeRequerimentos("*****12").intValue());
        assertEquals(5, senhaService.getQuantidadeRequerimentos("()(!@##@dws2EE]").intValue());
        assertEquals(4, senhaService.getQuantidadeRequerimentos("d9*98212e").intValue());
        assertEquals(0, senhaService.getQuantidadeRequerimentos("DEDFD").intValue());
        assertEquals(0, senhaService.getQuantidadeRequerimentos("").intValue());
        assertEquals(0, senhaService.getQuantidadeRequerimentos(" ").intValue());
        assertEquals(5, senhaService.getQuantidadeRequerimentos("D22E***ddd").intValue());
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
        assertEquals(6, senhaService.getQuantidadeCaracterRepetido("AABCCDEE").intValue());
        assertEquals(0, senhaService.getQuantidadeCaracterRepetido("ABCDE").intValue());
        assertEquals(0, senhaService.getQuantidadeCaracterRepetido("").intValue());
        assertEquals(2, senhaService.getQuantidadeCaracterRepetido("ABCDEE").intValue());
        assertEquals(0, senhaService.getQuantidadeCaracterRepetido("ABCDeE").intValue());
        assertEquals(4, senhaService.getQuantidadeCaracterRepetido("233133").intValue());
        assertEquals(9, senhaService.getQuantidadeCaracterRepetido("2222dddqhq").intValue());
    }

    @Test
    public void testLetrasMaiusculasConsecutivas() {
        assertEquals(2, senhaService.getQuantidadeLetrasMaiusculasConsecutivas("AaAAAaA").intValue());
        assertEquals(4, senhaService.getQuantidadeLetrasMaiusculasConsecutivas("AaAAAaAddeqAQQ").intValue());
        assertEquals(0, senhaService.getQuantidadeLetrasMaiusculasConsecutivas("12332").intValue());
        assertEquals(4, senhaService.getQuantidadeLetrasMaiusculasConsecutivas("DEDFD").intValue());
        assertEquals(0, senhaService.getQuantidadeLetrasMaiusculasConsecutivas("").intValue());
        assertEquals(5, senhaService.getQuantidadeLetrasMaiusculasConsecutivas("DsDsDsDssDDCCDA").intValue());
        assertEquals(1, senhaService.getQuantidadeLetrasMaiusculasConsecutivas("DE***").intValue());
    }

    @Test
    public void testLetrasMinusculasConsecutivas() {
        assertEquals(0, senhaService.getQuantidadeLetrasMinusculasConsecutivas("AaAAAaA").intValue());
        assertEquals(3, senhaService.getQuantidadeLetrasMinusculasConsecutivas("AaAAAaAddeqAQQ").intValue());
        assertEquals(0, senhaService.getQuantidadeLetrasMinusculasConsecutivas("12332").intValue());
        assertEquals(0, senhaService.getQuantidadeLetrasMinusculasConsecutivas("DEDFD").intValue());
        assertEquals(0, senhaService.getQuantidadeLetrasMinusculasConsecutivas("").intValue());
        assertEquals(1, senhaService.getQuantidadeLetrasMinusculasConsecutivas("DsDsDsDssDDCCDA").intValue());
        assertEquals(2, senhaService.getQuantidadeLetrasMinusculasConsecutivas("DE***ddd").intValue());
    }

    @Test
    public void testNumerosConsecutivos() {
        assertEquals(1, senhaService.getQuantidadeNumerosConsecutivos("*****12").intValue());
        assertEquals(0, senhaService.getQuantidadeNumerosConsecutivos("AaAAAaAddeqAQQ").intValue());
        assertEquals(4, senhaService.getQuantidadeNumerosConsecutivos("12332").intValue());
        assertEquals(0, senhaService.getQuantidadeNumerosConsecutivos("DEDFD").intValue());
        assertEquals(0, senhaService.getQuantidadeNumerosConsecutivos("").intValue());
        assertEquals(4, senhaService.getQuantidadeNumerosConsecutivos("DsDs1ss2DD44555CCDA").intValue());
        assertEquals(1, senhaService.getQuantidadeNumerosConsecutivos("D22E***ddd").intValue());
    }

    @Test
    public void testLetrasSequenciais() {
        assertEquals(0, senhaService.getQuantidadeLetrasSequenciais("").intValue());
        assertEquals(1, senhaService.getQuantidadeLetrasSequenciais("DsDs1ss2DD44555CCDEA").intValue());
        assertEquals(0, senhaService.getQuantidadeLetrasSequenciais("D22E***ddd").intValue());
        assertEquals(3, senhaService.getQuantidadeLetrasSequenciais("DsDs1ss2DD44555CCDEfg").intValue());
        assertEquals(0, senhaService.getQuantidadeLetrasSequenciais(" ").intValue());
        assertEquals(2, senhaService.getQuantidadeLetrasSequenciais("abdeghij").intValue());
        assertEquals(1, senhaService.getQuantidadeLetrasSequenciais("*((*sdnnnmopq").intValue());
    }

    @Test
    public void testNumerosSequenciais() {
        assertEquals(0, senhaService.getQuantidadeNumerosSequenciais("").intValue());
        assertEquals(0, senhaService.getQuantidadeNumerosSequenciais("DsDs1ss2DD44555CCDEA").intValue());
        assertEquals(2, senhaService.getQuantidadeNumerosSequenciais("D23452E***ddd").intValue());
        assertEquals(1, senhaService.getQuantidadeNumerosSequenciais("DsDs1ss2DD445655CCDEfg").intValue());
        assertEquals(0, senhaService.getQuantidadeNumerosSequenciais(" ").intValue());
        assertEquals(0, senhaService.getQuantidadeNumerosSequenciais("abdeghij").intValue());
        assertEquals(0, senhaService.getQuantidadeNumerosSequenciais("*((*sdnnnmopq").intValue());
    }

    @Test
    public void testSimbolosSequenciais() {
        assertEquals(0, senhaService.getQuantidadeSimbolosSequenciais("").intValue());
        assertEquals(0, senhaService.getQuantidadeSimbolosSequenciais("DsDs1ss2DD44555CCDEA").intValue());
//		assertEquals(2, senhaService.getQuantidadeSimbolosSequenciais("D23452E**^&*()ddd").intValue());
        assertEquals(0, senhaService.getQuantidadeSimbolosSequenciais("DsDs1ss2DD445655CCDEfg").intValue());
        assertEquals(0, senhaService.getQuantidadeSimbolosSequenciais(" ").intValue());
//		assertEquals(7, senhaService.getQuantidadeSimbolosSequenciais("!@#$%^&*()").intValue());
        assertEquals(0, senhaService.getQuantidadeSimbolosSequenciais("*((*sdnnnmopq").intValue());
    }

}
