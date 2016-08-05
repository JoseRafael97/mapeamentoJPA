package br.edu.ifpb.dac.exerciciojpa.mainslivro;

import br.edu.ifpb.dac.exerciciojpa.dao.bidirecional.AutorDAO;
import br.edu.ifpb.dac.exerciciojpa.dao.bidirecional.LivroDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Autor;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Livro;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class MainBiDeleteAllLivro {
	public static void main(String[] args) {
		LivroDAO livroDao = new LivroDAO();
		AutorDAO autorDao = new AutorDAO();

		try {
			for (Livro l : livroDao.findAll()) {
				livroDao.remove(l);
			}

			System.out.println("Linhas tb_Livro: " + livroDao.findAll().size());

			// Apagar Projetos

			for (Autor a : autorDao.findAll()) {
				autorDao.remove(a);
			}

			System.out.println("Linhas tb_autor: " + autorDao.findAll().size());

		} catch (ExercicioJpaPersistenceException e) {
			System.out.println(e);
			e.printStackTrace();

		} finally {
			livroDao.close();
			autorDao.close();
		}
	}
}
