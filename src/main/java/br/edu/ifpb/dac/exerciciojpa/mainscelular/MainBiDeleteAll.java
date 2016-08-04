package br.edu.ifpb.dac.exerciciojpa.mainscelular;

import br.edu.ifpb.dac.exerciciojpa.dao.bidirecional.CelularDao;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Celular;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class MainBiDeleteAll {
	
	public static void main(String[] args) {
		
		CelularDao celularDAO = new CelularDao();
		
		try {

			for(Celular c : celularDAO.findAll()){
				celularDAO.remove(c);
			}
			
			System.out.println(celularDAO.findAll().size());
		} catch (ExercicioJpaPersistenceException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());

		} finally {
			celularDAO.close();
		}
	}

}
