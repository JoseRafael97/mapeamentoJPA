package br.edu.ifpb.dac.exerciciojpa.mainslivro;

import java.util.ArrayList;

import br.edu.ifpb.dac.exerciciojpa.dao.bidirecional.AutorDAO;
import br.edu.ifpb.dac.exerciciojpa.dao.bidirecional.LivroDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Autor;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Livro;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;
import br.edu.ifpb.dac.exerciciojpa.util.Util;

public class MainsBiSaveLivro {

	public static void main(String[] args) {
		
		LivroDAO livroDao = new LivroDAO();
		AutorDAO autorDao = new AutorDAO();

		try {
			Livro livro = new Livro();
			livro.setAno(2010);
			livro.setEdicao(3);
			livro.setNome("Senho dos Anéis I");
			livro.setAutores(new ArrayList<>());

			Livro livro2 = new Livro();
			livro2.setAno(2011);
			livro2.setEdicao(1);
			livro2.setNome("Senho dos Anéis II");
			livro2.setAutores(new ArrayList<>());

			Autor autor = new Autor();
			autor.setNome("Fulano");
			autor.setSobreNome("Silva");
			autor.setDataNascimento(Util.getDate(2000, 7, 23));
			autor.setPublicacoes(new ArrayList<>());

			Autor autor2 = new Autor();
			autor2.setNome("Sicrano");
			autor2.setSobreNome("Motta");
			autor2.setDataNascimento(Util.getDate(2000, 7, 23));
			autor2.setPublicacoes(new ArrayList<>());

			Autor autor3 = new Autor();
			autor3.setNome("João");
			autor3.setSobreNome("Ferreiro");
			autor3.setDataNascimento(Util.getDate(2000, 7, 23));
			autor3.setPublicacoes(new ArrayList<>());


			System.out.println("Antes de Salvar: " + livro);
			System.out.println("Antes de Salvar: " + livro2);
			System.out.println("Antes de Salvar: " + autor);
			System.out.println("Antes de Salvar: " + autor2);
			System.out.println("Antes de Salvar: " + autor3);

			livroDao.save(livro);
			livroDao.save(livro2);

			autorDao.save(autor);
			autorDao.save(autor2);
			autorDao.save(autor3);

			System.out.println("Antes de Salvar: " + livro);
			System.out.println("Depois de Salvar: " + livro2);
			System.out.println("Depois de Salvar: " + autor);
			System.out.println("Depois de Salvar: " + autor2);
			System.out.println("Depois de Salvar: " + autor3);

			livro.getAutores().add(autor);
			livro.getAutores().add(autor2);
			livro2.getAutores().add(autor3);
			
			autor.getPublicacoes().add(livro);
			autor2.getPublicacoes().add(livro);
			autor3.getPublicacoes().add(livro2);

			livroDao.update(livro);
			livroDao.update(livro2);
			autorDao.update(autor);
			autorDao.update(autor2);
			autorDao.update(autor3);

		} catch (ExercicioJpaPersistenceException e) {
			System.out.println(e);
			e.printStackTrace();

		} finally {
			autorDao.close();
			livroDao.close();
		}
	}

}
