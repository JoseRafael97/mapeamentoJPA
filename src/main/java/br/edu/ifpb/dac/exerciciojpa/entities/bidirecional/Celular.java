package br.edu.ifpb.dac.exerciciojpa.entities.bidirecional;

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

import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Chamada;

@Entity(name = "Celular_BI")
@Table(name = "TB_CELULAR")
public class Celular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Integer codPais;

	@Column
	private Integer ddd;

	@Column
	private Integer numero;

	@OneToMany( fetch=FetchType.EAGER,cascade = CascadeType.ALL , mappedBy = "celular")
	private List<Chamada> chamadas;

	public Celular() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodPais() {
		return codPais;
	}

	public void setCodPais(Integer codPais) {
		this.codPais = codPais;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Chamada> getChamadas() {
		return chamadas;
	}

	public void setChamadas(List<Chamada> chamadas) {
		this.chamadas = chamadas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chamadas == null) ? 0 : chamadas.hashCode());
		result = prime * result + ((codPais == null) ? 0 : codPais.hashCode());
		result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Celular other = (Celular) obj;
		if (chamadas == null) {
			if (other.chamadas != null)
				return false;
		} else if (!chamadas.equals(other.chamadas))
			return false;
		if (codPais == null) {
			if (other.codPais != null)
				return false;
		} else if (!codPais.equals(other.codPais))
			return false;
		if (ddd == null) {
			if (other.ddd != null)
				return false;
		} else if (!ddd.equals(other.ddd))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Celular [id=" + id + ", codPais=" + codPais + ", ddd=" + ddd + ", numero=" + numero + ", chamadas="
				+ chamadas + "]";
	}

}