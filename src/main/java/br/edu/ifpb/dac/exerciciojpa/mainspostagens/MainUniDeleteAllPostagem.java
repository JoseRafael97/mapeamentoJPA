package br.edu.ifpb.dac.exerciciojpa.mainspostagens;


import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.PostagemDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Postagem;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class MainUniDeleteAllPostagem {

	public static void main(String[] args) {

		PostagemDAO postagemDAO = new PostagemDAO();

		try {

			for (Postagem p : postagemDAO.findAll()) {
				postagemDAO.remove(p);
			}
			
			System.out.println("Linhas : "+postagemDAO.findAll().size());

		} catch (ExercicioJpaPersistenceException e) {

			e.printStackTrace();

			System.out.println(e.getMessage());
		} finally {
			postagemDAO.close();
		}

	}

}
