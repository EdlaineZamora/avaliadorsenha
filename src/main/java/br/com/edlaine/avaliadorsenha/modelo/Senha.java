package br.com.edlaine.avaliadorsenha.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tarefa")
public class Senha {
	
	@Id
	@Column
	@SequenceGenerator(name="autoincIdTarefa",sequenceName="sequenceIdTarefa")
	@GeneratedValue(generator="autoincIdTarefa")
	private Integer id;
	@Column(length=60)
	private String descricao;
	@Column
	private Integer feito;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getFeito() {
		return feito;
	}
	public void setFeito(Integer feito) {
		this.feito = feito;
	}
	
	

}
