package br.edu.ifpb.dac.exerciciojpa.mainscelular;


import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.CelularDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Celular;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class MainUniDeleteAllCelular {
	 
	public static void main(String[] args) {
		CelularDAO celularDAO = new CelularDAO();

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
