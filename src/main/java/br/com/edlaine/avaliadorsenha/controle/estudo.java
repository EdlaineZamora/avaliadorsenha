package br.com.edlaine.avaliadorsenha.controle;

import javax.swing.JOptionPane;

public class estudo {

	public static void main(String[] args) {
		String senha = JOptionPane.showInputDialog("Insira a senha");
		
		if (soNumeros(senha)) {
			System.out.println("Senha: " + senha + " só contém números");
		} else {
			System.out.println("Senha: " + senha + " não contém só números");
		}
		
		if (soLetras(senha)) {
			System.out.println("Senha: " + senha + " só contém letras");
		} else {
			System.out.println("Senha: " + senha + " não contém só letras");
		}
		
		if (caracteresRepetidos(senha)) {
			System.out.println("Senha: " + senha + " contém caracteres repetidos");
		} else {
			System.out.println("Senha: " + senha + " não contém caracteres repetidos");
		}

	}
	
	public static boolean soNumeros(String senha) {
		
		return senha.matches("[0-9]*");
	}
	
	public static boolean soLetras(String senha) {
		
		return senha.matches("[a-zA-Z]*");
	}
	
	public static boolean caracteresRepetidos(String senha) {
		return senha.matches("[a-z]{2,}|[A-Z]{2,}|\\d{2,}");
	}
	
	public static boolean letrasMaiusculasConsecutivas(String senha) {
		return senha.matches("[A-Z]");
	}
	
	public static boolean letrasMinusculasConsecutivas(String senha) {
		return false;
	}
	
	public static boolean numerosConsecutivos(String senha) {
		return false;
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
	
}
