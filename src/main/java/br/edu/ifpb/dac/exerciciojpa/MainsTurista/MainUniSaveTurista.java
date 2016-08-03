package br.edu.ifpb.dac.exerciciojpa.MainsTurista;

import br.edu.ifpb.dac.exerciciojpa.dao.unidirecional.TuristaDAO;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Passaporte;
import br.edu.ifpb.dac.exerciciojpa.entities.uniderecional.Turista;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;
import br.edu.ifpb.dac.exerciciojpa.util.Util;

public class MainUniSaveTurista {

	public static void main(String[] args) {

		TuristaDAO dao = new TuristaDAO();

		try {

			Turista t = new Turista();
			t.setNome("Rafael");
			t.setSobreNome("Feitosa");
			t.setDataNascimento(Util.getDate(1995, 04, 27));

			Passaporte p = new Passaporte();
			p.setNumero(20161);
			p.setDono("Rafael");
			p.setEstado("Amazonas");
			p.setPais("Brazil");
			p.setEndereco("rua sete de setembro, nª1578, centro, Humaitá");

			t.setPassaporte(p);
			
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