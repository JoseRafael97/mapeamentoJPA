package br.edu.ifpb.dac.exerciciojpa.entities.bidirecional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Colaborador_BI")
@Table(name = "TB_COLABORADOR")
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column
	private String nome;

	@Column(name = "sobre_nome")
	private String sobreNome;

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Column
	private BigDecimal salario;

	@ManyToMany
	@JoinTable(name = "TB_COL_PROJ", joinColumns = @JoinColumn(name = "COLABORADOR_FK"), inverseJoinColumns = @JoinColumn(name = "PROJETO_FK"))
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((projetosTrabalha == null) ? 0 : projetosTrabalha.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		result = prime * result + ((sobreNome == null) ? 0 : sobreNome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Colaborador other = (Colaborador) obj;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (projetosTrabalha == null) {
			if (other.projetosTrabalha != null)
				return false;
		} else if (!projetosTrabalha.equals(other.projetosTrabalha))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		if (sobreNome == null) {
			if (other.sobreNome != null)
				return false;
		} else if (!sobreNome.equals(other.sobreNome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Colaborador [id=" + id + ", nome=" + nome + ", sobreNome=" + sobreNome + ", dataNascimento="
				+ dataNascimento + ", salario=" + salario + ", projetosTrabalha=" + projetosTrabalha + "]";
	}

}
