package br.edu.ifpb.dac.exerciciojpa.mainsfuncionario;

import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.FuncionarioDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Funcionario;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class MainUniDeleteAllFuncionario {

	public static void main(String[] args) {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		try {
			
			for (Funcionario f :  funcionarioDAO.findAll()){
				funcionarioDAO.remove(f);
			}

		} catch (ExercicioJpaPersistenceException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());

		} finally {
			funcionarioDAO.close();
		}

	}

}
