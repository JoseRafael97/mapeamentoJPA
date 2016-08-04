package br.edu.ifpb.dac.exerciciojpa.mainspostagens;


import br.edu.ifpb.dac.exerciciojpa.dao.bidirecional.PostagemDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Postagem;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class MainBiDeleteAllPostagem {

	public static void main(String[] args) {

		PostagemDAO postagemDAO = new PostagemDAO();

		try {

			for (Postagem p : postagemDAO.findAll()) {
				postagemDAO.remove(p);
			}

			System.out.println("Linhas : " + postagemDAO.findAll().size());

		} catch (ExercicioJpaPersistenceException e) {

			e.printStackTrace();

			System.out.println(e.getMessage());
		} finally {
			postagemDAO.close();
		}

	}

}
