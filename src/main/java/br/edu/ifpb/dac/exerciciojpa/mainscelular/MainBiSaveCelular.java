package br.edu.ifpb.dac.exerciciojpa.mainscelular;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifpb.dac.exerciciojpa.dao.bidirecional.CelularDao;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Celular;
import br.edu.ifpb.dac.exerciciojpa.entities.bidirecional.Chamada;
import br.edu.ifpb.dac.exerciciojpa.exceptions.ExercicioJpaPersistenceException;

public class MainBiSaveCelular {

	public static void main(String[] args) {

		CelularDao celularDAO = new CelularDao();

		try {

			Celular celular = new Celular();
			celular.setCodPais(55);
			celular.setDdd(97);
			celular.setNumero(1223432428);

			List<Chamada> list = new ArrayList<>();

			Chamada cha1 = new Chamada();
			cha1.setDuracao(100);
			cha1.setHoraInicio(new Date());

			Chamada cha2 = new Chamada();
			cha2.setDuracao(600);
			cha2.setHoraInicio(new Date());

			cha1.setCelular(celular);
			cha2.setCelular(celular);
			
			list.add(cha1);
			list.add(cha2);
			

			celular.setChamadas(list);
			System.out.println("Antes de Salvar: " + celular);

			celularDAO.save(celular);

			System.out.println("Depois de Salvar: " + celular);

		} catch (ExercicioJpaPersistenceException e) {

			e.printStackTrace();
			System.out.println(e.getMessage());

		} finally {
			celularDAO.close();
		}

	}
}
