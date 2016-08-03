
package br.edu.ifpb.dac.exerciciojpa.entities.bidirecional;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.edu.ifpb.dac.exerciciojpa.entities.Passaporte;

@Entity(name = "Turista_BI")
public class Turista {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private Long id;
	
	@Column
	private String nome;
	
	@Column(name = "sobre_nome")
	private String sobreNome;
	
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@OneToOne
	private Passaporte passaporte;

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

	public Passaporte getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(Passaporte passaporte) {
		this.passaporte = passaporte;
	}
	


}
