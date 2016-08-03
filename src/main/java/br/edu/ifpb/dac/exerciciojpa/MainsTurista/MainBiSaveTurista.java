package br.edu.ifpb.dac.exerciciojpa.MainsTurista;

import br.edu.ifpb.dac.exerciciojpa.dao.bidirecional.TuristaDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Passaporte;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Turista;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;
import br.edu.ifpb.dac.exerciciojpa.util.Util;

public class MainBiSaveTurista {

	public static void main(String[] args) {
		TuristaDAO dao = new TuristaDAO();

		try {

			Turista t = new Turista();
			t.setNome("Rafael4");
			t.setSobreNome("Feitosa4");
			t.setDataNascimento(Util.getDate(2000, 04, 27));

			Passaporte p = new Passaporte();
			p.setNumero(20161);
			p.setDono("Rafa");
			p.setEstado("Paraíba");
			p.setPais("Brazil");
			p.setEndereco("rua sete de setembro, nª158, centro, Humaitá");

			t.setPassaporte(p);

			//diferença do anterior uniderecional
			p.setTurista(t);

			System.out.println("Antes de salvar: "+t);


			dao.save(t);

			System.out.println("Depois de salvar: "+t);

		} catch (ExercicioJpaPersistenceException e) {

			e.printStackTrace();

			System.out.println(e.getMessage());
		} finally {
			dao.close();
		}

	}

}
