package br.edu.ifpb.dac.exerciciojpa;

import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.DepartamentoDAO;
import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.EmpregadoDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Departamento;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class MainUniDeleteAllDepartamentos {
	public static void main(String[] args) {
		
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		EmpregadoDAO empregadoDAO = new EmpregadoDAO();

		try {

			for(Departamento d : departamentoDAO.findAll()){
				departamentoDAO.remove(d);
			}
		} catch (ExercicioJpaPersistenceException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());

		} finally {
			departamentoDAO.close();
			empregadoDAO.close();
		}

	}

}
