package br.edu.ifpb.dac.exerciciojpa.mainscolaborador;

import br.edu.ifpb.dac.exerciciojpa.dao.bidirecional.ColaboradorDAO;
import br.edu.ifpb.dac.exerciciojpa.dao.bidirecional.ProjetoDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Colaborador;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Projeto;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class MainBiDeleteAllColaborador {

	public static void main(String[] args) {
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
		ProjetoDAO projetoDAO = new ProjetoDAO();

		try {
			for (Colaborador c : colaboradorDAO.findAll()) {
				colaboradorDAO.remove(c);
			}

			System.out.println("Linhas tb_colaboradores: " + colaboradorDAO.findAll().size());

			// Apagar Projetos

			for (Projeto p : projetoDAO.findAll()) {
				projetoDAO.remove(p);
			}

			System.out.println("Linhas tb_projetos: " + projetoDAO.findAll().size());

		} catch (ExercicioJpaPersistenceException e) {
			System.out.println(e);
			e.printStackTrace();

		} finally {
			colaboradorDAO.close();
			projetoDAO.close();
		}
	}

}
