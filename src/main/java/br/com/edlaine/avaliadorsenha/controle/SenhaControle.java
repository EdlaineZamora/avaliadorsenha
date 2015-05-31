package br.com.edlaine.avaliadorsenha.controle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.stereotype.Component;

import br.com.edlaine.avaliadorsenha.utils.Complexidade;

@Component("senhaControle")
public class SenhaControle  {
	

	private String senha = "";
	private String resultado;
	private String percentual = "0%";
	private Complexidade complexidade = Complexidade.MUITOFRACA;
	
	
	/**/
	public void avaliar(/*String senha*/) {
		
		//Adicoes
		Integer numberOfCharacters = quantidade(senha);
		Integer uppercaseLetters   = letrasMaiusculas(senha);
		Integer lowercaseLetters   = letrasMinusculas(senha);
		Integer numbers            = numeros(senha);
		//Integer symbols = simbolos(senha);
		//Integer middleNumbersOrSymbols = simbolosNumerosNoMeio(senha);
		//Integer requirements = requerimentos(senha);

		//Deducoes
		Integer lettersOnly = 0;
		if (soLetras(senha)) {
			lettersOnly = quantidade(senha);
		}
		Integer numbersOnly = 0; 
		if (soNumeros(senha)) {
			numbersOnly = quantidade(senha);
		}
		Integer repeatCharacters = caracteresRepetidos(senha);
		Integer consecutiveUppercaseLetters = letrasMaiusculasConsecutivas(senha);
		Integer consecutiveLowercaseLetters = letrasMinusculasConsecutivas(senha);
		Integer consecutiveNumbers = numerosConsecutivos(senha);
		//Integer sequentialLetters3 = letrasSequenciais3(senha);
		//Integer sequentialNumbers3 = numerosSequenciais3(senha);
		//Integer sequentialSymbols3 = simbolosSequenciais3(senha);
		
		Integer total = 0;
		total += (numberOfCharacters * 4);
		total += ((numberOfCharacters-uppercaseLetters)*2);
		total += ((numberOfCharacters-uppercaseLetters)*2);
		total += (numbers * 4);
		//total += (symbols * 6);
		//total += (middleNumbersOrSymbols * 2);
		//total += (requirements * 2);
		
		total -= lettersOnly;
		total -= numbersOnly;
		//total -= repeatCharacters;
		total -= (consecutiveUppercaseLetters*2);
		total -= (consecutiveLowercaseLetters*2);
		total -= (consecutiveNumbers*2);
		//total -= (sequentialLetters3*3);
		//total -= (sequentialNumbers3*3);
		//total -= (sequentialSymbols3*3);
		
		gerarResultado(total);
		
	}
	
	public void gerarResultado(Integer resultado) {
		this.resultado = String.valueOf(resultado);
		complexidade = Complexidade.FORTE;
		percentual = "10%";
		System.out.println("Resultado: " + resultado);
	}
	
	public static Integer quantidade(String senha) {
		
		return senha.length();
	}
	
	public static Integer quantidadeCaracteres(String senha, String expressaoRegular) {
		
		Integer contador = 0;
		
		for (int i=0; i<senha.length();i++) {
			String letra = String.valueOf(senha.charAt(i)); 
			if (letra.matches(expressaoRegular)) {
				contador++;
			}
		}
		
		return contador;
	}
	
	public static Integer letrasMaiusculas(String senha) {
		
		return quantidadeCaracteres(senha, "[A-Z]+");

	}
	
	public static Integer letrasMinusculas(String senha) {
		
		return quantidadeCaracteres(senha, "[a-z]+");
		
	}
	
	public static Integer numeros(String senha){
		
		return quantidadeCaracteres(senha, "[0-9]+");
	}
	
	
	public static boolean soNumeros(String senha) {
		return senha.matches("[0-9]+");
	}
	
	public static boolean soLetras(String senha) {
		
		return senha.matches("[a-zA-Z]+");
	}
	
	public static Integer caracteresRepetidos(String senha) {
		
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
		
		Iterator<Entry<String, Integer>> colecaoCaracteres = colecao.entrySet().iterator();
		while (colecaoCaracteres.hasNext()){
			Map.Entry<String,Integer> par = (Map.Entry<String, Integer>) colecaoCaracteres.next();
			if (par.getValue() > 1) {
				contador = contador + par.getValue();
			}
		}
		
		return contador;
	}
	
	public static Integer consecutivos(String senha, String expressaoRegular) {
		
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
	
	public static Integer letrasMaiusculasConsecutivas(String senha) {
		
		return consecutivos(senha, "[A-Z]+");
	}
	
	public static Integer letrasMinusculasConsecutivas(String senha) {
		
		return consecutivos(senha, "[a-z]+");
	}
	
	public static Integer numerosConsecutivos(String senha) {
		
		return consecutivos(senha, "[0-9]+");
	}
	
	public static boolean letrasSequenciais(String senha) {
		return false;
	}
	
	public static boolean numerosSequenciais(String senha) {
		return false;
	}
	
	public static boolean simbolosSequenciais(String senha) {
		return false;
	}	
	
	public boolean complexidadeMuitoCurta() {
		if (complexidade == Complexidade.MUITOCURTA) {
			return true;
		}
		return false;
	}

	public boolean complexidadeMuitoFraca() {
		if (complexidade == Complexidade.MUITOFRACA) {
			return true;
		}
		return false;
	}	
	
	public boolean complexidadeFraca() {
		if (complexidade == Complexidade.FRACA) {
			return true;
		}
		return false;
	}
	
	public boolean complexidadeBoa() {
		if (complexidade == Complexidade.BOA) {
			return true;
		}
		return false;
	}
	
	public boolean complexidadeForte() {
		if (complexidade == Complexidade.FORTE) {
			return true;
		}
		return false;
	}
	
	public boolean complexidadeMuitoForte() {
		if (complexidade == Complexidade.MUITOFORTE) {
			return true;
		}
		return false;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getResultado() {
		return resultado;
	}

	public String getPercentual() {
		return percentual;
	}

	public Complexidade getComplexidade() {
		return complexidade;
	}
	
	


}
