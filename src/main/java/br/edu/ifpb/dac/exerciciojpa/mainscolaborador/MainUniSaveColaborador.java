package br.edu.ifpb.dac.exerciciojpa.mainscolaborador;

import java.math.BigDecimal;
import java.util.ArrayList;
import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.ColaboradorDAO;
import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.ProjetoDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Colaborador;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Projeto;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;
import br.edu.ifpb.dac.exerciciojpa.util.Util;

public class MainUniSaveColaborador {

	public static void main(String[] args) {
		ProjetoDAO projetoDAO = new ProjetoDAO();
		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();

		try {
			Colaborador colaborador = new Colaborador();
			colaborador.setNome("Rafael Feitosa");
			colaborador.setSobreNome("Feitosa");
			colaborador.setSalario(new BigDecimal(3000.322));
			colaborador.setDataNascimento(Util.getDate(1995, 4, 27));
			colaborador.setProjetosTrabalha(new ArrayList<>());

			Projeto projeto1 = new Projeto();
			projeto1.setDuracao(500);
			projeto1.setNome("PROJETO ANDROID");

			Projeto projeto2 = new Projeto();
			projeto2.setDuracao(500);
			projeto2.setNome("PROJETO WEB");

			System.out.println("Antes de Salvar: " + colaborador);

			colaboradorDAO.save(colaborador);
			projetoDAO.save(projeto1);
			projetoDAO.save(projeto2);

			System.out.println("Depois de Salvar: " + colaborador);

			colaborador.getProjetosTrabalha().add(projeto1);
			colaborador.getProjetosTrabalha().add(projeto2);

			System.out.println("Antes de Atualizar: " + colaborador);

			colaboradorDAO.update(colaborador);

			System.out.println("Depois de Atualizar: " + colaborador);

		} catch (ExercicioJpaPersistenceException e) {
			System.out.println(e);
			e.printStackTrace();

		} finally {
			colaboradorDAO.close();
		}
	}

}
