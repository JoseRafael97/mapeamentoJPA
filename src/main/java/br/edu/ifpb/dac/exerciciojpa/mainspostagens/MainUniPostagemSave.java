package br.edu.ifpb.dac.exerciciojpa.mainspostagens;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.PostagemDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Comentario;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Postagem;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;
import br.edu.ifpb.dac.exerciciojpa.util.Util;

public class MainUniPostagemSave {

	public static void main(String[] args) {

		PostagemDAO postagemDAO = new PostagemDAO();

		try {

			Postagem post = new Postagem();
			post.setDataPublicacao(Util.getDate(2015, 04, 27));
			post.setTitulo("Testando postagem");

			List<Comentario> comentarios = new ArrayList<>();

			Comentario com = new Comentario();
			com.setConteudo("Olá estou testando o comentário");
			com.setLikes(2);

			Comentario com2 = new Comentario();
			com2.setConteudo("Testando outro cometário");
			com2.setLikes(5);
			
			
			comentarios.add(com);
			comentarios.add(com2);

			post.setComentarios(comentarios);

			System.out.println("Antes de salvar: " + post);

			postagemDAO.save(post);

			System.out.println("Depois de salvar: " + post);

		} catch (ExercicioJpaPersistenceException e) {

			e.printStackTrace();

			System.out.println(e.getMessage());
		} finally {
			postagemDAO.close();
		}

	}

}
