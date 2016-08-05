package br.edu.ifpb.dac.exerciciojpa.entities.bidirecional;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Chamada;

@Entity(name = "Chamada_BI")
@Table(name = "TB_CHAMADA")
public class Chamada {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column
	private Integer duracao;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaInicio;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CELULAR_FK")
	private Celular celular;

	public Chamada() {
	}
	
	

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public Date getHoraInicio() {
		return horaInicio;

	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	public Celular getCelular() {
		return celular;
	}

	public void setCelular(Celular celular) {
		this.celular = celular;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duracao == null) ? 0 : duracao.hashCode());
		result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Chamada other = (Chamada) obj;
		if (duracao == null) {
			if (other.duracao != null)
				return false;
		} else if (!duracao.equals(other.duracao))
			return false;
		if (horaInicio == null) {
			if (other.horaInicio != null)
				return false;
		} else if (!horaInicio.equals(other.horaInicio))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Chamada [id=" + id + ", duracao=" + duracao + ", horaInicio=" + horaInicio + "]";
	}

}