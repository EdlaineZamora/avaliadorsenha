package br.com.edlaine.avaliadorsenha.teste.controle;

import br.com.edlaine.avaliadorsenha.controle.SenhaControle;
import junit.framework.TestCase;

public class SenhaControleTeste extends TestCase {
	
	
	public void testQuantidade() {
		
		assertEquals("7", String.valueOf(SenhaControle.quantidade("*****12")));
		assertEquals("14", String.valueOf(SenhaControle.quantidade("AaAAAaAddeqAQQ")));
		assertEquals("5", String.valueOf(SenhaControle.quantidade("12332")));
		assertEquals("5", String.valueOf(SenhaControle.quantidade("DEDFD")));
		assertEquals("0", String.valueOf(SenhaControle.quantidade("")));
		assertEquals("19", String.valueOf(SenhaControle.quantidade("DsDs1ss2DD44555CCDA")));
		assertEquals("10", String.valueOf(SenhaControle.quantidade("D22E***ddd")));
		
	}
	
	public void testLetrasMaiusculas() {
		
		assertEquals("0", String.valueOf(SenhaControle.letrasMaiusculas("*****12")));
		assertEquals("8", String.valueOf(SenhaControle.letrasMaiusculas("AaAAAaAddeqAQQ")));
		assertEquals("0", String.valueOf(SenhaControle.letrasMaiusculas("12332")));
		assertEquals("5", String.valueOf(SenhaControle.letrasMaiusculas("DEDFD")));
		assertEquals("0", String.valueOf(SenhaControle.letrasMaiusculas("")));
		assertEquals("8", String.valueOf(SenhaControle.letrasMaiusculas("DsDs1ss2DD44555CCDA")));
		assertEquals("2", String.valueOf(SenhaControle.letrasMaiusculas("D22E***ddd")));
		
	}
	
	public void testLetrasMinusculas() {
		
		assertEquals("0", String.valueOf(SenhaControle.letrasMinusculas("*****12")));
		assertEquals("6", String.valueOf(SenhaControle.letrasMinusculas("AaAAAaAddeqAQQ")));
		assertEquals("0", String.valueOf(SenhaControle.letrasMinusculas("12332")));
		assertEquals("0", String.valueOf(SenhaControle.letrasMinusculas("DEDFD")));
		assertEquals("0", String.valueOf(SenhaControle.letrasMinusculas("")));
		assertEquals("4", String.valueOf(SenhaControle.letrasMinusculas("DsDs1ss2DD44555CCDA")));
		assertEquals("3", String.valueOf(SenhaControle.letrasMinusculas("D22E***ddd")));
		
	}
	
	public void testNumeros() {
		
		assertEquals("2", String.valueOf(SenhaControle.numeros("*****12")));
		assertEquals("0", String.valueOf(SenhaControle.numeros(" ")));
		assertEquals("5", String.valueOf(SenhaControle.numeros("12332")));
		assertEquals("0", String.valueOf(SenhaControle.numeros("DEDFD")));
		assertEquals("0", String.valueOf(SenhaControle.numeros("")));
		assertEquals("7", String.valueOf(SenhaControle.numeros("DsDs1ss2DD44555CCDA")));
		assertEquals("2", String.valueOf(SenhaControle.numeros("D22E***ddd")));
		
	}
	
	public void testSimbolos() {
		
		assertEquals("5", String.valueOf(SenhaControle.simbolos("*****12")));
		assertEquals("9", String.valueOf(SenhaControle.simbolos("()(!@##@dws]")));
		assertEquals("0", String.valueOf(SenhaControle.simbolos("12332")));
		assertEquals("0", String.valueOf(SenhaControle.simbolos("DEDFD")));
		assertEquals("0", String.valueOf(SenhaControle.simbolos("")));
		assertEquals("0", String.valueOf(SenhaControle.simbolos(" ")));
		assertEquals("3", String.valueOf(SenhaControle.simbolos("D22E***ddd")));
		
	}
	
	
	public void testNumerosSimbolosNoMeio() {
		
		assertEquals("5", String.valueOf(SenhaControle.numerosSimbolosNoMeio("*****12")));
		assertEquals("8", String.valueOf(SenhaControle.numerosSimbolosNoMeio("()(!@##@dws2EE]")));
		assertEquals("7", String.valueOf(SenhaControle.numerosSimbolosNoMeio("d9*98212e")));
		assertEquals("0", String.valueOf(SenhaControle.numerosSimbolosNoMeio("DEDFD")));
		assertEquals("0", String.valueOf(SenhaControle.numerosSimbolosNoMeio("")));
		assertEquals("0", String.valueOf(SenhaControle.numerosSimbolosNoMeio(" ")));
		assertEquals("5", String.valueOf(SenhaControle.numerosSimbolosNoMeio("D22E***ddd")));
		
	}
	
	
	public void testRequerimentos() {
		
		assertEquals("0", String.valueOf(SenhaControle.requerimentos("*****12")));
		assertEquals("5", String.valueOf(SenhaControle.requerimentos("()(!@##@dws2EE]")));
		assertEquals("4", String.valueOf(SenhaControle.requerimentos("d9*98212e")));
		assertEquals("0", String.valueOf(SenhaControle.requerimentos("DEDFD")));
		assertEquals("0", String.valueOf(SenhaControle.requerimentos("")));
		assertEquals("0", String.valueOf(SenhaControle.requerimentos(" ")));
		assertEquals("5", String.valueOf(SenhaControle.requerimentos("D22E***ddd")));
		
	}
	
	public void testSoNumeros() {
		
		assertTrue(SenhaControle.soNumeros("1236434412"));
		assertFalse(SenhaControle.soNumeros(""));
		assertFalse(SenhaControle.soNumeros("adqw98123"));
		assertFalse(SenhaControle.soNumeros("a&**(dqw98123"));
		assertFalse(SenhaControle.soNumeros("a&**(dqw9;do12"));
	}
	
	public void testSoLetras() {
		
		assertFalse(SenhaControle.soLetras("1231023"));
		assertFalse(SenhaControle.soLetras(""));
		assertTrue(SenhaControle.soLetras("AAASDQWE"));
		assertTrue(SenhaControle.soLetras("asdasdASDEA"));
		assertTrue(SenhaControle.soLetras("aasdjqhuhdas"));
		
	}
	
	public void testCaracteresRepetidos() {
		
		assertEquals("6", String.valueOf(SenhaControle.caracteresRepetidos("AABCCDEE")));
		assertEquals("0", String.valueOf(SenhaControle.caracteresRepetidos("ABCDE")));
		assertEquals("0", String.valueOf(SenhaControle.caracteresRepetidos("")));
		assertEquals("2", String.valueOf(SenhaControle.caracteresRepetidos("ABCDEE")));
		assertEquals("0", String.valueOf(SenhaControle.caracteresRepetidos("ABCDeE")));
		assertEquals("4", String.valueOf(SenhaControle.caracteresRepetidos("233133")));
		assertEquals("9", String.valueOf(SenhaControle.caracteresRepetidos("2222dddqhq")));
		
	}
	
	public void testLetrasMaiusculasConsecutivas() {
		
		assertEquals("2", String.valueOf(SenhaControle.letrasMaiusculasConsecutivas("AaAAAaA")));
		assertEquals("4", String.valueOf(SenhaControle.letrasMaiusculasConsecutivas("AaAAAaAddeqAQQ")));
		assertEquals("0", String.valueOf(SenhaControle.letrasMaiusculasConsecutivas("12332")));
		assertEquals("4", String.valueOf(SenhaControle.letrasMaiusculasConsecutivas("DEDFD")));
		assertEquals("0", String.valueOf(SenhaControle.letrasMaiusculasConsecutivas("")));
		assertEquals("5", String.valueOf(SenhaControle.letrasMaiusculasConsecutivas("DsDsDsDssDDCCDA")));
		assertEquals("1", String.valueOf(SenhaControle.letrasMaiusculasConsecutivas("DE***")));
		
	}
	
	public void testLetrasMinusculasConsecutivas() {
		
		assertEquals("0", String.valueOf(SenhaControle.letrasMinusculasConsecutivas("AaAAAaA")));
		assertEquals("3", String.valueOf(SenhaControle.letrasMinusculasConsecutivas("AaAAAaAddeqAQQ")));
		assertEquals("0", String.valueOf(SenhaControle.letrasMinusculasConsecutivas("12332")));
		assertEquals("0", String.valueOf(SenhaControle.letrasMinusculasConsecutivas("DEDFD")));
		assertEquals("0", String.valueOf(SenhaControle.letrasMinusculasConsecutivas("")));
		assertEquals("1", String.valueOf(SenhaControle.letrasMinusculasConsecutivas("DsDsDsDssDDCCDA")));
		assertEquals("2", String.valueOf(SenhaControle.letrasMinusculasConsecutivas("DE***ddd")));
		
	}
	
	public void testNumerosConsecutivos() {
		
		assertEquals("1", String.valueOf(SenhaControle.numerosConsecutivos("*****12")));
		assertEquals("0", String.valueOf(SenhaControle.numerosConsecutivos("AaAAAaAddeqAQQ")));
		assertEquals("4", String.valueOf(SenhaControle.numerosConsecutivos("12332")));
		assertEquals("0", String.valueOf(SenhaControle.numerosConsecutivos("DEDFD")));
		assertEquals("0", String.valueOf(SenhaControle.numerosConsecutivos("")));
		assertEquals("4", String.valueOf(SenhaControle.numerosConsecutivos("DsDs1ss2DD44555CCDA")));
		assertEquals("1", String.valueOf(SenhaControle.numerosConsecutivos("D22E***ddd")));
		
	}
	
	public void testLetrasSequenciais() {
		
		assertEquals("0", String.valueOf(SenhaControle.letrasSequenciais("")));
		assertEquals("1", String.valueOf(SenhaControle.letrasSequenciais("DsDs1ss2DD44555CCDEA")));
		assertEquals("0", String.valueOf(SenhaControle.letrasSequenciais("D22E***ddd")));
		assertEquals("3", String.valueOf(SenhaControle.letrasSequenciais("DsDs1ss2DD44555CCDEfg")));
		assertEquals("0", String.valueOf(SenhaControle.letrasSequenciais(" ")));
		assertEquals("2", String.valueOf(SenhaControle.letrasSequenciais("abdeghij")));
		assertEquals("1", String.valueOf(SenhaControle.letrasSequenciais("*((*sdnnnmopq")));
		
	}
	
	public void testNumerosSequenciais() {
		
		assertEquals("0", String.valueOf(SenhaControle.numerosSequenciais("")));
		assertEquals("0", String.valueOf(SenhaControle.numerosSequenciais("DsDs1ss2DD44555CCDEA")));
		assertEquals("2", String.valueOf(SenhaControle.numerosSequenciais("D23452E***ddd")));
		assertEquals("1", String.valueOf(SenhaControle.numerosSequenciais("DsDs1ss2DD445655CCDEfg")));
		assertEquals("0", String.valueOf(SenhaControle.numerosSequenciais(" ")));
		assertEquals("0", String.valueOf(SenhaControle.numerosSequenciais("abdeghij")));
		assertEquals("0", String.valueOf(SenhaControle.numerosSequenciais("*((*sdnnnmopq")));
		
	}
	
	public void testSimbolosSequenciais() {
		
		assertEquals("0", String.valueOf(SenhaControle.simbolosSequenciais("")));
		assertEquals("0", String.valueOf(SenhaControle.simbolosSequenciais("DsDs1ss2DD44555CCDEA")));
		assertEquals("2", String.valueOf(SenhaControle.simbolosSequenciais("D23452E**^&*()ddd")));
		assertEquals("0", String.valueOf(SenhaControle.simbolosSequenciais("DsDs1ss2DD445655CCDEfg")));
		assertEquals("0", String.valueOf(SenhaControle.simbolosSequenciais(" ")));
		assertEquals("7", String.valueOf(SenhaControle.simbolosSequenciais("!@#$%^&*()")));
		assertEquals("0", String.valueOf(SenhaControle.simbolosSequenciais("*((*sdnnnmopq")));
		
	}
	
	/*public void testAvaliar() {
		
		assertEquals("20", String.valueOf(SenhaControle.avaliar("*%")));
		assertEquals("10", String.valueOf(SenhaControle.avaliar("*")));
		assertEquals("30", String.valueOf(SenhaControle.avaliar("*%9")));
        assertEquals("100", String.valueOf(SenhaControle.avaliar("DsDs1ss2DD44555CCDEA")));
		assertEquals("100", String.valueOf(SenhaControle.avaliar("DsDs1ss2DD445655CCDEfg")));
		assertEquals("4", String.valueOf(SenhaControle.avaliar(" ")));
		assertEquals("39", String.valueOf(SenhaControle.avaliar("(*sdnmopq")));
		
	}*/

}
