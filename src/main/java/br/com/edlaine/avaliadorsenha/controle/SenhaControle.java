package br.com.edlaine.avaliadorsenha.controle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;

import br.com.edlaine.avaliadorsenha.utils.Complexidade;

@Component("senhaControle")
public class SenhaControle  {
	

	private String senha = "";
	private String percentual = "0%";
	private Complexidade complexidade = Complexidade.MUITOCURTA;
	private boolean visualizarSenha = true;
	
	
	/*Recupera a pontuação de cada regra e gera o total atingido*/
	public void avaliar(/*String senha*/) {
		
		//Adições
		Integer numberOfCharacters = quantidade(senha);
		Integer uppercaseLetters = letrasMaiusculas(senha);
		Integer lowercaseLetters = letrasMinusculas(senha);
		Integer numbers = numeros(senha);
		Integer symbols = simbolos(senha);
		Integer middleNumbersOrSymbols = numerosSimbolosNoMeio(senha);
		Integer requirements = requerimentos(senha);

		//Subtrações
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
		Integer sequentialLetters = letrasSequenciais(senha);
		Integer sequentialNumbers = numerosSequenciais(senha);
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
		
		gerarResultado(total);
		
	}
	
	public void gerarResultado(Integer resultado) {
		complexidade = Complexidade.FORTE;
		percentual = resultado + "%";
		
		if (resultado == 0) {
			complexidade = Complexidade.MUITOCURTA;			
		} else
			if (resultado > 0 && resultado <= 20) {
				complexidade = Complexidade.MUITOFRACA;
			} else 
				if (resultado > 20 && resultado <= 40) {
					complexidade = Complexidade.FRACA;
				} else
					if (resultado > 40 && resultado <= 60) {
						complexidade = Complexidade.BOA;
					} else
						if (resultado > 60 && resultado <= 80) {
							complexidade = Complexidade.FORTE;
						} else
							if (resultado > 80) {
								complexidade = Complexidade.MUITOFORTE;
							}
		
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
	
	public static Integer simbolos(String senha){
		
		return quantidadeCaracteres(senha, "[^a-zA-Z0-9\\s]");
	}
	
	public static Integer numerosSimbolosNoMeio(String senha) {
		
		Integer contador = 0;
		
		if (senha.length() < 3) {
			return contador;
		}
		
		String caracterInicial = String.valueOf(senha.charAt(0));
		String caracterFinal = String.valueOf(senha.charAt(senha.length()-1));
		
		contador += simbolos(senha);
		contador += numeros(senha);
		
		if (caracterInicial.matches("[0-9]+") || caracterInicial.matches("[^a-zA-Z0-9\\s]+")){
			contador -= 1;
		}
		
		if (caracterFinal.matches("[0-9]+") || caracterFinal.matches("[^a-zA-Z0-9\\s]+")){
			contador -= 1;
		}
		
		return contador;
	}
	
	/* Mínimo de 8 caracteres de tamanho
	   Conter 3/4 dos itens a seguir:
	   - Letras Maiúsculas
	   - Letras Minúsculas
	   - Números
	   - Símbolos
	 */
	public static Integer requerimentos(String senha) {
		
		Integer contador = 0;
		if (letrasMaiusculas(senha) > 0) {
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
			return contador = 0;
		}
		
	}
	
	public static boolean soNumeros(String senha) {
		return senha.matches("[0-9]+");
	}
	
	public static boolean soLetras(String senha) {
		
		return senha.matches("[a-zA-Z]+");
	}
	
	/* Não entendi qual fórmula utilizar, pois não diz
	 * no site, está com um (-): "Repeat Characters (Case Insensitive) 	Comp 	-".
	 * Estou considerando a quantidade de caracteres repetidos para somar,
	 * porém, em alguns casos dá divergência.
	 */
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
	
	public static Integer sequenciais(String senha, String expressaoRegular) {
		
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
	
	public static Integer letrasSequenciais(String senha) {
		return sequenciais(senha.toUpperCase(), "[a-zA-Z]+");
	}
	
	public static Integer numerosSequenciais(String senha) {
		return sequenciais(senha, "[0-9]+");
	}
	
	/* Na regra de negócio passada como referência não consegui entender, pois
	 * eu implementei seguindo a sequência da tabela ascii e não está
	 * batendo com o site passado.
	 * */
	public static Integer simbolosSequenciais(String senha) {
		
		return sequenciais(senha, "[^a-zA-Z0-9\\s]+");
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
