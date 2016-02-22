package br.com.edlaine.avaliadorsenha.teste.controle;

import br.com.edlaine.avaliadorsenha.controller.SenhaController;
import br.com.edlaine.avaliadorsenha.service.SenhaService;
import br.com.edlaine.avaliadorsenha.service.impl.SenhaServiceImpl;
import junit.framework.TestCase;

public class SenhaServiceTeste extends TestCase {


	private SenhaService senhaService = new SenhaServiceImpl();

	public void testQuantidade() {
		
		assertEquals("7", String.valueOf(senhaService.quantidadeDeCaracteres("*****12")));
		assertEquals("14", String.valueOf(senhaService.quantidadeDeCaracteres("AaAAAaAddeqAQQ")));
		assertEquals("5", String.valueOf(senhaService.quantidadeDeCaracteres("12332")));
		assertEquals("5", String.valueOf(senhaService.quantidadeDeCaracteres("DEDFD")));
		assertEquals("0", String.valueOf(senhaService.quantidadeDeCaracteres("")));
		assertEquals("19", String.valueOf(senhaService.quantidadeDeCaracteres("DsDs1ss2DD44555CCDA")));
		assertEquals("10", String.valueOf(senhaService.quantidadeDeCaracteres("D22E***ddd")));
		
	}
	
	public void testLetrasMaiusculas() {
		
		assertEquals("0", String.valueOf(senhaService.quantidadeLetrasMaiusculas("*****12")));
		assertEquals("8", String.valueOf(senhaService.quantidadeLetrasMaiusculas("AaAAAaAddeqAQQ")));
		assertEquals("0", String.valueOf(senhaService.quantidadeLetrasMaiusculas("12332")));
		assertEquals("5", String.valueOf(senhaService.quantidadeLetrasMaiusculas("DEDFD")));
		assertEquals("0", String.valueOf(senhaService.quantidadeLetrasMaiusculas("")));
		assertEquals("8", String.valueOf(senhaService.quantidadeLetrasMaiusculas("DsDs1ss2DD44555CCDA")));
		assertEquals("2", String.valueOf(senhaService.quantidadeLetrasMaiusculas("D22E***ddd")));
		
	}
	
	public void testLetrasMinusculas() {
		
		assertEquals("0", String.valueOf(senhaService.letrasMinusculas("*****12")));
		assertEquals("6", String.valueOf(senhaService.letrasMinusculas("AaAAAaAddeqAQQ")));
		assertEquals("0", String.valueOf(senhaService.letrasMinusculas("12332")));
		assertEquals("0", String.valueOf(senhaService.letrasMinusculas("DEDFD")));
		assertEquals("0", String.valueOf(senhaService.letrasMinusculas("")));
		assertEquals("4", String.valueOf(senhaService.letrasMinusculas("DsDs1ss2DD44555CCDA")));
		assertEquals("3", String.valueOf(senhaService.letrasMinusculas("D22E***ddd")));
		
	}
	
	public void testNumeros() {
		
		assertEquals("2", String.valueOf(senhaService.numeros("*****12")));
		assertEquals("0", String.valueOf(senhaService.numeros(" ")));
		assertEquals("5", String.valueOf(senhaService.numeros("12332")));
		assertEquals("0", String.valueOf(senhaService.numeros("DEDFD")));
		assertEquals("0", String.valueOf(senhaService.numeros("")));
		assertEquals("7", String.valueOf(senhaService.numeros("DsDs1ss2DD44555CCDA")));
		assertEquals("2", String.valueOf(senhaService.numeros("D22E***ddd")));
		
	}
	
	public void testSimbolos() {
		
		assertEquals("5", String.valueOf(senhaService.simbolos("*****12")));
		assertEquals("9", String.valueOf(senhaService.simbolos("()(!@##@dws]")));
		assertEquals("0", String.valueOf(senhaService.simbolos("12332")));
		assertEquals("0", String.valueOf(senhaService.simbolos("DEDFD")));
		assertEquals("0", String.valueOf(senhaService.simbolos("")));
		assertEquals("0", String.valueOf(senhaService.simbolos(" ")));
		assertEquals("3", String.valueOf(senhaService.simbolos("D22E***ddd")));
		
	}
	
	
	public void testNumerosSimbolosNoMeio() {
		
		assertEquals("5", String.valueOf(senhaService.numerosSimbolosNoMeio("*****12")));
		assertEquals("8", String.valueOf(senhaService.numerosSimbolosNoMeio("()(!@##@dws2EE]")));
		assertEquals("7", String.valueOf(senhaService.numerosSimbolosNoMeio("d9*98212e")));
		assertEquals("0", String.valueOf(senhaService.numerosSimbolosNoMeio("DEDFD")));
		assertEquals("0", String.valueOf(senhaService.numerosSimbolosNoMeio("")));
		assertEquals("0", String.valueOf(senhaService.numerosSimbolosNoMeio(" ")));
		assertEquals("5", String.valueOf(senhaService.numerosSimbolosNoMeio("D22E***ddd")));
		
	}
	
	
	public void testRequerimentos() {
		
		assertEquals("0", String.valueOf(senhaService.requerimentos("*****12")));
		assertEquals("5", String.valueOf(senhaService.requerimentos("()(!@##@dws2EE]")));
		assertEquals("4", String.valueOf(senhaService.requerimentos("d9*98212e")));
		assertEquals("0", String.valueOf(senhaService.requerimentos("DEDFD")));
		assertEquals("0", String.valueOf(senhaService.requerimentos("")));
		assertEquals("0", String.valueOf(senhaService.requerimentos(" ")));
		assertEquals("5", String.valueOf(senhaService.requerimentos("D22E***ddd")));
		
	}
	
	public void testSoNumeros() {
		
		assertTrue(senhaService.isSoNumeros("1236434412"));
		assertFalse(senhaService.isSoNumeros(""));
		assertFalse(senhaService.isSoNumeros("adqw98123"));
		assertFalse(senhaService.isSoNumeros("a&**(dqw98123"));
		assertFalse(senhaService.isSoNumeros("a&**(dqw9;do12"));
	}
	
	public void testSoLetras() {
		
		assertFalse(senhaService.isSoLetras("1231023"));
		assertFalse(senhaService.isSoLetras(""));
		assertTrue(senhaService.isSoLetras("AAASDQWE"));
		assertTrue(senhaService.isSoLetras("asdasdASDEA"));
		assertTrue(senhaService.isSoLetras("aasdjqhuhdas"));
		
	}
	
	public void testCaracteresRepetidos() {
		
		assertEquals("6", String.valueOf(senhaService.isCaracterRepetido("AABCCDEE")));
		assertEquals("0", String.valueOf(senhaService.isCaracterRepetido("ABCDE")));
		assertEquals("0", String.valueOf(senhaService.isCaracterRepetido("")));
		assertEquals("2", String.valueOf(senhaService.isCaracterRepetido("ABCDEE")));
		assertEquals("0", String.valueOf(senhaService.isCaracterRepetido("ABCDeE")));
		assertEquals("4", String.valueOf(senhaService.isCaracterRepetido("233133")));
		assertEquals("9", String.valueOf(senhaService.isCaracterRepetido("2222dddqhq")));
		
	}
	
	public void testLetrasMaiusculasConsecutivas() {
		
		assertEquals("2", String.valueOf(senhaService.letrasMaiusculasConsecutivas("AaAAAaA")));
		assertEquals("4", String.valueOf(senhaService.letrasMaiusculasConsecutivas("AaAAAaAddeqAQQ")));
		assertEquals("0", String.valueOf(senhaService.letrasMaiusculasConsecutivas("12332")));
		assertEquals("4", String.valueOf(senhaService.letrasMaiusculasConsecutivas("DEDFD")));
		assertEquals("0", String.valueOf(senhaService.letrasMaiusculasConsecutivas("")));
		assertEquals("5", String.valueOf(senhaService.letrasMaiusculasConsecutivas("DsDsDsDssDDCCDA")));
		assertEquals("1", String.valueOf(senhaService.letrasMaiusculasConsecutivas("DE***")));
		
	}
	
	public void testLetrasMinusculasConsecutivas() {
		
		assertEquals("0", String.valueOf(senhaService.letrasMinusculasConsecutivas("AaAAAaA")));
		assertEquals("3", String.valueOf(senhaService.letrasMinusculasConsecutivas("AaAAAaAddeqAQQ")));
		assertEquals("0", String.valueOf(senhaService.letrasMinusculasConsecutivas("12332")));
		assertEquals("0", String.valueOf(senhaService.letrasMinusculasConsecutivas("DEDFD")));
		assertEquals("0", String.valueOf(senhaService.letrasMinusculasConsecutivas("")));
		assertEquals("1", String.valueOf(senhaService.letrasMinusculasConsecutivas("DsDsDsDssDDCCDA")));
		assertEquals("2", String.valueOf(senhaService.letrasMinusculasConsecutivas("DE***ddd")));
		
	}
	
	public void testNumerosConsecutivos() {
		
		assertEquals("1", String.valueOf(senhaService.numerosConsecutivos("*****12")));
		assertEquals("0", String.valueOf(senhaService.numerosConsecutivos("AaAAAaAddeqAQQ")));
		assertEquals("4", String.valueOf(senhaService.numerosConsecutivos("12332")));
		assertEquals("0", String.valueOf(senhaService.numerosConsecutivos("DEDFD")));
		assertEquals("0", String.valueOf(senhaService.numerosConsecutivos("")));
		assertEquals("4", String.valueOf(senhaService.numerosConsecutivos("DsDs1ss2DD44555CCDA")));
		assertEquals("1", String.valueOf(senhaService.numerosConsecutivos("D22E***ddd")));
		
	}
	
	public void testLetrasSequenciais() {
		
		assertEquals("0", String.valueOf(senhaService.letrasSequenciais("")));
		assertEquals("1", String.valueOf(senhaService.letrasSequenciais("DsDs1ss2DD44555CCDEA")));
		assertEquals("0", String.valueOf(senhaService.letrasSequenciais("D22E***ddd")));
		assertEquals("3", String.valueOf(senhaService.letrasSequenciais("DsDs1ss2DD44555CCDEfg")));
		assertEquals("0", String.valueOf(senhaService.letrasSequenciais(" ")));
		assertEquals("2", String.valueOf(senhaService.letrasSequenciais("abdeghij")));
		assertEquals("1", String.valueOf(senhaService.letrasSequenciais("*((*sdnnnmopq")));
		
	}
	
	public void testNumerosSequenciais() {
		
		assertEquals("0", String.valueOf(senhaService.numerosSequenciais("")));
		assertEquals("0", String.valueOf(senhaService.numerosSequenciais("DsDs1ss2DD44555CCDEA")));
		assertEquals("2", String.valueOf(senhaService.numerosSequenciais("D23452E***ddd")));
		assertEquals("1", String.valueOf(senhaService.numerosSequenciais("DsDs1ss2DD445655CCDEfg")));
		assertEquals("0", String.valueOf(senhaService.numerosSequenciais(" ")));
		assertEquals("0", String.valueOf(senhaService.numerosSequenciais("abdeghij")));
		assertEquals("0", String.valueOf(senhaService.numerosSequenciais("*((*sdnnnmopq")));
		
	}
	
	public void testSimbolosSequenciais() {
		
		assertEquals("0", String.valueOf(senhaService.simbolosSequenciais("")));
		assertEquals("0", String.valueOf(senhaService.simbolosSequenciais("DsDs1ss2DD44555CCDEA")));
//		assertEquals("2", String.valueOf(senhaService.simbolosSequenciais("D23452E**^&*()ddd")));
		assertEquals("0", String.valueOf(senhaService.simbolosSequenciais("DsDs1ss2DD445655CCDEfg")));
		assertEquals("0", String.valueOf(senhaService.simbolosSequenciais(" ")));
//		assertEquals("7", String.valueOf(senhaService.simbolosSequenciais("!@#$%^&*()")));
		assertEquals("0", String.valueOf(senhaService.simbolosSequenciais("*((*sdnnnmopq")));
		
	}

}
