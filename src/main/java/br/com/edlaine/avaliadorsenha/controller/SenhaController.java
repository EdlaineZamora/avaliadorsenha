package br.com.edlaine.avaliadorsenha.controller;

import br.com.edlaine.avaliadorsenha.service.SenhaService;
import br.com.edlaine.avaliadorsenha.service.impl.SenhaServiceImpl;
import org.springframework.stereotype.Component;

import br.com.edlaine.avaliadorsenha.enumerations.Complexidade;

@Component("senhaControle")
public class SenhaController {
	

	private String senha = "";
	private String percentual = "0%";
	private Complexidade complexidade = Complexidade.MUITOCURTA;
	private boolean visualizarSenha = true;
	private SenhaService senhaService;

	public SenhaController() {
		senhaService = new SenhaServiceImpl();
	}

	public void recuperarPontuacaoDeCadaRegra() {
		
		//Adições
		Integer numberOfCharacters = senhaService.quantidadeDeCaracteres(senha);
		Integer uppercaseLetters = senhaService.quantidadeLetrasMaiusculas(senha);
		Integer lowercaseLetters = senhaService.letrasMinusculas(senha);
		Integer numbers = senhaService.numeros(senha);
		Integer symbols = senhaService.simbolos(senha);
		Integer middleNumbersOrSymbols = senhaService.numerosSimbolosNoMeio(senha);
		Integer requirements = senhaService.requerimentos(senha);

		//Subtrações
		Integer lettersOnly = 0;
		if (senhaService.isSoLetras(senha)) {
			lettersOnly = senhaService.quantidadeDeCaracteres(senha);
		}
		Integer numbersOnly = 0; 
		if (senhaService.isSoNumeros(senha)) {
			numbersOnly = senhaService.quantidadeDeCaracteres(senha);
		}
		Integer repeatCharacters = senhaService.isCaracterRepetido(senha);
		Integer consecutiveUppercaseLetters = senhaService.letrasMaiusculasConsecutivas(senha);
		Integer consecutiveLowercaseLetters = senhaService.letrasMinusculasConsecutivas(senha);
		Integer consecutiveNumbers = senhaService.numerosConsecutivos(senha);
		Integer sequentialLetters = senhaService.letrasSequenciais(senha);
		Integer sequentialNumbers = senhaService.numerosSequenciais(senha);
		//Integer sequentialSymbols3 = simbolosSequenciais3(senha);
		
		Integer total = 0;
		total += (numberOfCharacters * 4);
		if (uppercaseLetters > 0) {
			total += ((numberOfCharacters-uppercaseLetters)*2);			
		}
		if (lowercaseLetters > 0) {
			total += ((numberOfCharacters-lowercaseLetters)*2);	
		}
		total += (numbers * 4);
		total += (symbols * 6);
		total += (middleNumbersOrSymbols * 2);
		total += (requirements * 2);
		
		total -= lettersOnly;
		total -= numbersOnly;
		total -= repeatCharacters;
		total -= (consecutiveUppercaseLetters*2);
		total -= (consecutiveLowercaseLetters*2);
		total -= (consecutiveNumbers*2);
		total -= (sequentialLetters*3);
		total -= (sequentialNumbers*3);
		//total -= (sequentialSymbols3*3);
		
		if (total < 0) {
			total = 0;
		}
		
		if (total > 100) {
			total = 100;
		}

		this.complexidade = senhaService.gerarResultado(total);
		this.percentual = total + "%";
		
	}

	public boolean isComplexidadeMuitoCurta() {
		return complexidade == Complexidade.MUITOCURTA;
	}

	public boolean isComplexidadeMuitoFraca() {
		return complexidade == Complexidade.MUITOFRACA;
	}	
	
	public boolean isComplexidadeFraca() {
		return complexidade == Complexidade.FRACA;
	}
	
	public boolean isComplexidadeBoa() {
		return complexidade == Complexidade.BOA;
	}
	
	public boolean isComplexidadeForte() {
		return complexidade == Complexidade.FORTE;
	}
	
	public boolean isComplexidadeMuitoForte() {
		return complexidade == Complexidade.MUITOFORTE;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPercentual() {
		return percentual;
	}

	public Complexidade getComplexidade() {
		return complexidade;
	}

	public boolean isVisualizarSenha() {
		return visualizarSenha;
	}

	public void setVisualizarSenha(boolean visualizarSenha) {
		this.visualizarSenha = visualizarSenha;
	}
	
	


}
