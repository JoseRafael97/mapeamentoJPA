package br.edu.ifpb.dac.exerciciojpa.entities.uniderecional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Colaborador_UNI")
@Table(name = "TB_COLABORADOR")
public class Colaborador {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String nome;
	
	@Column(name = "sobre_nome")
	private String sobreNome;
	
	@Column(name = "data_Nascimento")
	private Date dataNascimento;
	
	private BigDecimal salario;
	
	private List<Projeto> projetosTrabalha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public List<Projeto> getProjetosTrabalha() {
		return projetosTrabalha;
	}

	public void setProjetosTrabalha(List<Projeto> projetosTrabalha) {
		this.projetosTrabalha = projetosTrabalha;
	}
	
	

}
