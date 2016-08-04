package br.edu.ifpb.dac.exerciciojpa.entities.uniderecional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Projeto_UNI")
@Table (name = "TB_PROJETO")
public class Projeto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	private Integer duracao;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getDuracao() {
		return duracao;
	}
	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}
	
	

}
