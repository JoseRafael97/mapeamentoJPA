package br.edu.ifpb.dac.exerciciojpa;

import java.util.List;

import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.TuristaDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Turista;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class MainUniDeleteAllTurista {

	public static void main(String[] args) {

		TuristaDAO dao = new TuristaDAO();

		try {
			List<Turista> turistas = dao.findAll();
			
			for (Turista turista : turistas) {
				dao.remove(turista);
			}
			
			System.out.println(dao.findAll().size());
		
		} catch (ExercicioJpaPersistenceException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}finally {
			dao.close();
		}
	}

}
