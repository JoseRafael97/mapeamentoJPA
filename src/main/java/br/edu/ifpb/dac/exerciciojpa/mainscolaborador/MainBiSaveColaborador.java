package br.edu.ifpb.dac.exerciciojpa.mainscolaborador;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.edu.ifpb.dac.exerciciojpa.dao.bidirecional.ColaboradorDAO;
import br.edu.ifpb.dac.exerciciojpa.dao.bidirecional.ProjetoDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Colaborador;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Projeto;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;
import br.edu.ifpb.dac.exerciciojpa.util.Util;

public class MainBiSaveColaborador {

	public static void main(String[] args) {

		ColaboradorDAO colaboradorDAO = new ColaboradorDAO();
		ProjetoDAO projetoDAO = new ProjetoDAO();

		try {
			Colaborador colaborador = new Colaborador();
			colaborador.setNome("R.");
			colaborador.setSobreNome("Feitosa");
			colaborador.setSalario(new BigDecimal(3000.322));
			colaborador.setDataNascimento(Util.getDate(1995, 4, 27));
			colaborador.setProjetosTrabalha(new ArrayList<>());

			Projeto projeto1 = new Projeto();
			projeto1.setDuracao(200);
			projeto1.setNome("PROJETO TESTES");
			projeto1.setIntegrantes(new ArrayList<>());

			Projeto projeto2 = new Projeto();
			projeto2.setDuracao(100);
			projeto2.setNome("PROJETO DESKTOP");
			projeto2.setIntegrantes(new ArrayList<>());

			System.out.println("Antes de Salvar: " + colaborador);

			colaboradorDAO.save(colaborador);
			projetoDAO.save(projeto1);
			projetoDAO.save(projeto2);

			System.out.println("Depois de Salvar: " + colaborador);

			colaborador.getProjetosTrabalha().add(projeto1);
			colaborador.getProjetosTrabalha().add(projeto2);
			
			projeto1.getIntegrantes().add(colaborador);
			projeto2.getIntegrantes().add(colaborador);

			System.out.println("Antes de Atualizar: " + colaborador);

			colaboradorDAO.update(colaborador);
			projetoDAO.update(projeto1);
			projetoDAO.update(projeto2);

			System.out.println("Depois de Atualizar: " + colaborador);
			
		} catch (ExercicioJpaPersistenceException e) {
			System.out.println(e);
			e.printStackTrace();

		} finally {
			colaboradorDAO.close();
			projetoDAO.close();
		}

	}
}
