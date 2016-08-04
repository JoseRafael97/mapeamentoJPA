package br.edu.ifpb.dac.exerciciojpa.entities.uniderecional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Funcionario_UNI")
@Table(name = "FUNCIONARIO")
public class Funcionario {
	
	@Id
	@GeneratedValue (strategy =  GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String nome;
	
	@Column(name = "sobre_nome")
	private String sobreNome;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@Column
	private BigDecimal salario;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Funcionario> gerencia;

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

	public List<Funcionario> getGerencia() {
		return gerencia;
	}

	public void setGerencia(List<Funcionario> gerencia) {
		this.gerencia = gerencia;
	}
	
	
	

}