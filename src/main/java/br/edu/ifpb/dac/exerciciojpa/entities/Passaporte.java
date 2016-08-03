package br.edu.ifpb.dac.exerciciojpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passaporte {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	private Long id;

}
