package br.edu.ifpb.dac.exerciciojpa.dao;

import java.util.List;

import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public interface GenericDAO <T, K> {
	
	public void save(T obj)  throws ExercicioJpaPersistenceException;
	
	public void update(T obj)  throws ExercicioJpaPersistenceException;
	
	public void remove(T obj) throws ExercicioJpaPersistenceException;
	
	public T findById(K id)  throws ExercicioJpaPersistenceException;
	
	public List<T> findAll()  throws ExercicioJpaPersistenceException;

}
