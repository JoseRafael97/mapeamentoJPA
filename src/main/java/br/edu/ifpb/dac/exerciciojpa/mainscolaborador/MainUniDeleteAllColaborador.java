package br.edu.ifpb.dac.exerciciojpa.mainscolaborador;

import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.ColaboradorDAO;
import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.ProjetoDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Colaborador;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Projeto;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class MainUniDeleteAllColaborador {

	public static void main(String[] args) {
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
		ProjetoDAO projetoDAO = new ProjetoDAO();

		try {
			for (Colaborador c : colaboradorDAO.findAll()) {
				colaboradorDAO.remove(c);
			}

			System.out.println("Linhas tb_colaboradores: "+colaboradorDAO.findAll().size());

			// Apagar Projetos

			for (Projeto p : projetoDAO.findAll()) {
				projetoDAO.remove(p);
			}
			
			System.out.println("Linhas tb_projetos: "+projetoDAO.findAll().size());


		} catch (ExercicioJpaPersistenceException e) {
			System.out.println(e);
			e.printStackTrace();

		} finally {
			colaboradorDAO.close();
			projetoDAO.close();
		}
	}

}
