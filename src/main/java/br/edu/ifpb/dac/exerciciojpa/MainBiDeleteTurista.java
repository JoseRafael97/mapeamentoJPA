package br.edu.ifpb.dac.exerciciojpa;

import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.TuristaDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Passaporte;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Turista;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;
import br.edu.ifpb.dac.exerciciojpa.util.Util;

public class MainBiDeleteTurista {

	public static void main(String[] args) {

		TuristaDAO dao = new TuristaDAO();

		try {

			Turista t = new Turista();
			t.setNome("Rafael2");
			t.setSobreNome("Feitosa2");
			t.setDataNascimento(Util.getDate(1994, 04, 27));

			Passaporte p = new Passaporte();
			p.setNumero(20162);
			p.setDono("Rafael2");
			p.setEstado("Amazonas");
			p.setPais("Brazil");
			p.setEndereco("rua sete de setembro, nª1578, centro, Humaitá");

			t.setPassaporte(p);

			dao.save(t);

			System.out.println(dao.findAll().size());

			dao.remove(t);

			System.out.println(dao.findAll().size());

		} catch (ExercicioJpaPersistenceException e) {

			e.printStackTrace();

			System.out.println(e.getMessage());
		} finally {
			dao.close();
		}

	}

}
