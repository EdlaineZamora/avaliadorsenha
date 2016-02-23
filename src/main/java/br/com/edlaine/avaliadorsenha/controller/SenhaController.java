package br.com.edlaine.avaliadorsenha.controller;

import br.com.edlaine.avaliadorsenha.entity.Senha;
import br.com.edlaine.avaliadorsenha.enumerations.Complexidade;
import br.com.edlaine.avaliadorsenha.service.SenhaService;
import br.com.edlaine.avaliadorsenha.service.impl.SenhaServiceImpl;
import org.springframework.stereotype.Component;

@Component("senhaController")
public class SenhaController {


    private Senha senha;
    private String percentual = "0%";
    private boolean visualizarSenha = true;
    private SenhaService senhaService;

    public SenhaController() {
        senhaService = new SenhaServiceImpl();
        senha = new Senha();
    }

    public void recuperarPontuacaoDeCadaRegra() {

        //Adições
        Integer numberOfCharacters = senhaService.getQuantidadeDeCaracteres(senha.getDescricao());
        Integer uppercaseLetters = senhaService.quantidadeLetrasMaiusculas(senha.getDescricao());
        Integer lowercaseLetters = senhaService.getQuantidadeLetrasMinusculas(senha.getDescricao());
        Integer numbers = senhaService.getQuantidadeNumeros(senha.getDescricao());
        Integer symbols = senhaService.getQuantidadeSimbolos(senha.getDescricao());
        Integer middleNumbersOrSymbols = senhaService.getQuantidadeNumerosSimbolosNoMeio(senha.getDescricao());
        Integer requirements = senhaService.getQuantidadeRequerimentos(senha.getDescricao());

        //Subtrações
        Integer lettersOnly = 0;
        if (senhaService.isSoLetras(senha.getDescricao())) {
            lettersOnly = senhaService.getQuantidadeDeCaracteres(senha.getDescricao());
        }
        Integer numbersOnly = 0;
        if (senhaService.isSoNumeros(senha.getDescricao())) {
            numbersOnly = senhaService.getQuantidadeDeCaracteres(senha.getDescricao());
        }
        Integer repeatCharacters = senhaService.isCaracterRepetido(senha.getDescricao());
        Integer consecutiveUppercaseLetters = senhaService.getQuantidadeLetrasMaiusculasConsecutivas(senha.getDescricao());
        Integer consecutiveLowercaseLetters = senhaService.getQuantidadeLetrasMinusculasConsecutivas(senha.getDescricao());
        Integer consecutiveNumbers = senhaService.getQuantidadeNumerosConsecutivos(senha.getDescricao());
        Integer sequentialLetters = senhaService.getQuantidadeLetrasSequenciais(senha.getDescricao());
        Integer sequentialNumbers = senhaService.getQuantidadeNumerosSequenciais(senha.getDescricao());
        //Integer sequentialSymbols3 = simbolosSequenciais3(senha.getDescricao());

        Integer total = 0;
        total += (numberOfCharacters * 4);
        if (uppercaseLetters > 0) {
            total += ((numberOfCharacters - uppercaseLetters) * 2);
        }
        if (lowercaseLetters > 0) {
            total += ((numberOfCharacters - lowercaseLetters) * 2);
        }
        total += (numbers * 4);
        total += (symbols * 6);
        total += (middleNumbersOrSymbols * 2);
        total += (requirements * 2);

        total -= lettersOnly;
        total -= numbersOnly;
        total -= repeatCharacters;
        total -= (consecutiveUppercaseLetters * 2);
        total -= (consecutiveLowercaseLetters * 2);
        total -= (consecutiveNumbers * 2);
        total -= (sequentialLetters * 3);
        total -= (sequentialNumbers * 3);
        //total -= (sequentialSymbols3*3);

        if (total < 0) {
            total = 0;
        }

        if (total > 100) {
            total = 100;
        }

        this.senha.setComplexidade(senhaService.gerarResultado(total));
        this.percentual = total + "%";

    }

    public boolean isComplexidadeMuitoCurta() {
        return senha.getComplexidade() == Complexidade.MUITOCURTA;
    }

    public boolean isComplexidadeMuitoFraca() {
        return senha.getComplexidade() == Complexidade.MUITOFRACA;
    }

    public boolean isComplexidadeFraca() {
        return senha.getComplexidade() == Complexidade.FRACA;
    }

    public boolean isComplexidadeBoa() {
        return senha.getComplexidade() == Complexidade.BOA;
    }

    public boolean isComplexidadeForte() {
        return senha.getComplexidade() == Complexidade.FORTE;
    }

    public boolean isComplexidadeMuitoForte() {
        return senha.getComplexidade() == Complexidade.MUITOFORTE;
    }

    public String getPercentual() {
        return percentual;
    }

    public boolean isVisualizarSenha() {
        return visualizarSenha;
    }

    public void setVisualizarSenha(boolean visualizarSenha) {
        this.visualizarSenha = visualizarSenha;
    }


    public Senha getSenha() {
        return senha;
    }

    public void setSenha(final Senha senha) {
        this.senha = senha;
    }
}
