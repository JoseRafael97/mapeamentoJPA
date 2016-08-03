package br.edu.ifpb.dac.exerciciojpa.exceptions;

public class ExercicioJpaPersistenceException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExercicioJpaPersistenceException(String msg, Throwable erro) {
		super(msg, erro);
	}

}
